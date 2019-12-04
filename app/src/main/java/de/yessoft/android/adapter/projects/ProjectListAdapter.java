package de.yessoft.android.adapter.projects;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.yessoft.android.R;
import de.yessoft.android.entity.Project;

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectViewHolder> {
    private Context mContext;
    private List<Project> mProjctList;

    public ProjectListAdapter(Context context) {
        mContext = context;
    }

    public ProjectListAdapter(Context context, List<Project> projectList) {
        mContext = context;
        mProjctList = projectList;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_employee_project, parent, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position) {
        holder.tvProjectDate.setText(mProjctList.get(position).getEndDate());
        holder.tvProjectEnd.setText(mProjctList.get(position).getEndDate());
        holder.tvProjectStart.setText(mProjctList.get(position).getStartDate());

        holder.tvProjectNameFolded.setText(mProjctList.get(position).getTitle());
        holder.tvProjectNameUnfolded.setText(mProjctList.get(position).getTitle());

        holder.fl_fold.setOnClickListener((view) -> {
            holder.foldingCell.toggle(false);
        });

        holder.iv_unfold.setOnClickListener((view) -> {
            holder.foldingCell.toggle(false);
        });

        holder.btnProjectLink.setOnClickListener((view) -> {
            mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(mProjctList.get(position).getLink())));
        });
    }

    @Override
    public int getItemCount() {
        if (mProjctList == null) {
            return 0;
        }
        return mProjctList.size();
    }
}
