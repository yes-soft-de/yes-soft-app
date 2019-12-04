package de.yessoft.android.adapter.blogs;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import de.yessoft.android.R;

public class BlogViewHolder extends RecyclerView.ViewHolder {
    TextView tvDate;
    TextView tvTitle;
    TextView tvLink;

    public BlogViewHolder(@NonNull View itemView) {
        super(itemView);

        tvDate = itemView.findViewById(R.id.tv_i_project_date);
        tvTitle = itemView.findViewById(R.id.tv_i_project_name_folded);
        tvLink = itemView.findViewById(R.id.tv_i_blog_link);
    }
}
