package de.yessoft.android.adapter.dashboard;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import de.yessoft.android.R;
import de.yessoft.android.activity.BlogsActivity;
import de.yessoft.android.activity.EmployeesActivity;
import de.yessoft.android.activity.MainActivity.IMainActivity;
import de.yessoft.android.activity.ServicesActivity;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardViewHolder> {
    private List<mItem> items = new ArrayList<>();

    private Context mContext;
    private IMainActivity mParentActivity;

    public DashboardAdapter(Context context) {
        mContext = context;
        initAdapter(context);
    }

    public DashboardAdapter(Context context, IMainActivity parent) {
        mContext = context;
        initAdapter(context);
        mParentActivity = parent;
    }

    void initAdapter(Context context) {
        items.add(new mItem("Our Services", context.getDrawable(R.color.card_01), R.drawable.dashboard_services));
        items.add(new mItem("Our Team", context.getDrawable(R.color.card_02), R.drawable.dashboard_team));
        items.add(new mItem("Hire Us", context.getDrawable(R.color.card_03), R.drawable.dashboard_contact));
        items.add(new mItem("Blogs", context.getDrawable(R.color.card_01), R.drawable.dashboard_blogs));
    }

    @NonNull
    @Override
    public DashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(mContext)
                .inflate(R.layout.item_dashboard, parent, false);
        return new DashboardViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardViewHolder holder, int position) {
        holder.card.setBackground(items.get(position).mBg);
        holder.image.setImageResource(items.get(position).mImageResource);
        holder.text.setText(items.get(position).mText);

        if (position == 0) {
            holder.card.setOnClickListener((v) -> {
                mContext.startActivity(new Intent(mContext, ServicesActivity.class));
            });
        }
        if (position == 1)
            holder.card.setOnClickListener((v) -> {

                mContext.startActivity(new Intent(mContext, EmployeesActivity.class));
            });
        if (position == 2) {
            holder.card.setOnClickListener((v) -> {
                mParentActivity.openSheets();
            });
        }
        if (position == 3)
            holder.card.setOnClickListener((v) -> {

                mContext.startActivity(new Intent(mContext, BlogsActivity.class));
            });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private class mItem {
        String mText;
        int mImageResource;
        Drawable mBg;

        mItem(String text, Drawable bgResource, int imageResource) {
            mBg = bgResource;
            mText = text;
            mImageResource = imageResource;
        }
    }
}
