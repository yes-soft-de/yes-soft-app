package de.yessoft.android.adapter.blogs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import de.yessoft.android.R;
import de.yessoft.android.entity.Blog;

public class BlogsListAdapter extends RecyclerView.Adapter<BlogViewHolder> {
    Context mContext;
    List<Blog> mBlogList;

    public BlogsListAdapter(Context context) {
        mContext = context;
        mBlogList = new ArrayList<>();
    }

    public BlogsListAdapter(Context context, List<Blog> blogList) {
        mContext = context;
        mBlogList = blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        mBlogList = blogList;
    }

    @NonNull
    @Override
    public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_employee_blog, parent, false);

        return new BlogViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogViewHolder holder, int position) {
        holder.tvDate.setText(mBlogList.get(position).getPublishDate());
        holder.tvTitle.setText(mBlogList.get(position).getTitle());
        holder.tvLink.setOnClickListener((btn) -> {
            mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(mBlogList.get(position).getLink())));
        });
    }

    @Override
    public int getItemCount() {
        if (mBlogList == null) {
            return 0;
        }
        return mBlogList.size();
    }
}
