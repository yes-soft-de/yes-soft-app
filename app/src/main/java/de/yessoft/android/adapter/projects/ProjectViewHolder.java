package de.yessoft.android.adapter.projects;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.ramotion.foldingcell.FoldingCell;

import de.yessoft.android.R;

public class ProjectViewHolder extends RecyclerView.ViewHolder {

    // Cell
    FoldingCell foldingCell;

    // Details
    FrameLayout fl_fold;
    TextView tvProjectNameUnfolded;
    TextView tvProjectStart;
    TextView tvProjectEnd;

    MaterialButton btnProjectLink;

    // Overview
    TextView tvProjectNameFolded;
    TextView tvProjectDate;
    AppCompatImageView iv_unfold;


    public ProjectViewHolder(@NonNull View itemView) {
        super(itemView);

        foldingCell = itemView.findViewById(R.id.folding_cell);

        fl_fold = itemView.findViewById(R.id.fl_i_toggler);
        tvProjectNameUnfolded = itemView.findViewById(R.id.tv_i_project_name_unfolded);
        tvProjectStart = itemView.findViewById(R.id.tv_i_project_start);
        tvProjectEnd = itemView.findViewById(R.id.tv_i_project_end);
        btnProjectLink = itemView.findViewById(R.id.btn_i_project_link);

        tvProjectNameFolded = itemView.findViewById(R.id.tv_i_project_name_folded);
        tvProjectDate = itemView.findViewById(R.id.tv_i_project_date);
        iv_unfold = itemView.findViewById(R.id.iv_i_project_unfold);
    }
}
