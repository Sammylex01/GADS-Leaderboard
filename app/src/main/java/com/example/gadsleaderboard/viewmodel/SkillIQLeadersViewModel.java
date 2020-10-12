package com.example.gadsleaderboard.viewmodel;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gadsleaderboard.data.DataResponseCallback;
import com.example.gadsleaderboard.data.DataService;
import com.example.gadsleaderboard.model.SkillIQLeader;

import java.util.List;

public class SkillIQLeadersViewModel extends ViewModel {
    private MutableLiveData<List<SkillIQLeader>> skillIqLeaders;
    private MutableLiveData<Boolean> error = new MutableLiveData<>(false);
    private Handler handler = new Handler();

    public LiveData<List<SkillIQLeader>> getSkillIQLeader() {
        if (skillIqLeaders == null) {
            skillIqLeaders = new MutableLiveData<>();
            refreshList();
        }

        return skillIqLeaders;
    }

    public LiveData<Boolean> getError(){
        return error;
    }

    public void refreshList() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                DataService.getSkillLeaders(new DataResponseCallback<List<SkillIQLeader>>() {
                    @Override
                    public void onResponse(List<SkillIQLeader> response) {
                        skillIqLeaders.setValue(response);
                        error.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        error.setValue(true);
                    }
                });
            }
        }, 1000);
    }
}
