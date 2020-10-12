package com.example.gadsleaderboard.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.model.SkillIQLeader;
import com.example.gadsleaderboard.R;

import java.util.List;

public class SkillIQLeadersAdapter extends RecyclerView.Adapter<SkillIQLeadersAdapter.ViewHolder>{
    public Context mContext;
    public List<SkillIQLeader> mSkillIQLeaderList;

    public SkillIQLeadersAdapter(Context context){
        this.mContext = context;
    }

    public void setSkillIQLeaderList(List<SkillIQLeader> skillIQLeaderList) {
        this.mSkillIQLeaderList = skillIQLeaderList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.skill_iq_leaders_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SkillIQLeader item = mSkillIQLeaderList.get(position);
        holder.txtTitle.setText(item.getName());
        holder.txtSubtitle.setText(mContext.getString(R.string.skill_leader_details, item.getScore(), item.getCountry()));
    }

    @Override
    public int getItemCount() {
        return mSkillIQLeaderList == null ? 0: mSkillIQLeaderList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTitle, txtSubtitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtSubtitle = itemView.findViewById(R.id.txtSubtitle);
        }
    }
}

