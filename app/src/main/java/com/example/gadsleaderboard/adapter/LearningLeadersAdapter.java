package com.example.gadsleaderboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.model.LearningLeader;
import com.example.gadsleaderboard.R;

import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder> {
    public Context mContext;
    public List<LearningLeader> mLearningLeaderList;

    public LearningLeadersAdapter( Context context) {
        this.mContext = context;
    }

    public void setLearningLeaderList(List<LearningLeader> learningLeaderList) {
        this.mLearningLeaderList = learningLeaderList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.learning_leaders_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LearningLeader item = mLearningLeaderList.get(position);
        holder.txtTitle.setText(item.getName());
        holder.txtSubtitle.setText(mContext.getString(R.string.learning_leader_details, item.getHours(), item.getCountry()));

    }

    @Override
    public int getItemCount() {
        return mLearningLeaderList == null ? 0: mLearningLeaderList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle, txtSubtitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtSubtitle = itemView.findViewById(R.id.txtSubtitle);
        }
    }
}
