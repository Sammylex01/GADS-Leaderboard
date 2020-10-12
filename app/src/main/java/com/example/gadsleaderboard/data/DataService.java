package com.example.gadsleaderboard.data;

import android.os.Handler;

import androidx.annotation.NonNull;

import com.example.gadsleaderboard.api.ApiResponseCallback;
import com.example.gadsleaderboard.api.GadsApiService;
import com.example.gadsleaderboard.model.LearningLeader;
import com.example.gadsleaderboard.model.SkillIQLeader;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.LogRecord;

public class DataService {
    public static android.os.Handler handler = new Handler();

    public static void getLearningLeaders(@NonNull final DataResponseCallback<List<LearningLeader>> callback) {
        GadsApiService.getLearningLeaders(new ApiResponseCallback<List<LearningLeader>>() {
            @Override
            public void onResponse(final List<LearningLeader> response) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Collections.sort(response, new Comparator<LearningLeader>() {
                            @Override
                            public int compare(LearningLeader a, LearningLeader b) {
                                return (int)Math.signum( b.getHours()-a.getHours() );
                            }
                        });
                        callback.onResponse(response);
                    }
                });
            }

            @Override
            public void onError(Throwable error) {
                callback.onError(error);
            }
        });
    }

    public static void getSkillLeaders(@NonNull final DataResponseCallback<List<SkillIQLeader>> callback) {
        GadsApiService.getSkillLeaders(new ApiResponseCallback<List<SkillIQLeader>>() {
            @Override
            public void onResponse(final List<SkillIQLeader> response) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Collections.sort(response, new Comparator<SkillIQLeader>() {
                            @Override
                            public int compare(SkillIQLeader a, SkillIQLeader b) {
                                return (int)Math.signum(b.getScore() -a.getScore()  );
                            }
                        });
                        callback.onResponse(response);
                    }
                });
            }

            @Override
            public void onError(final Throwable error) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError(error);
                    }
                });
            }
        });
    }
    }
