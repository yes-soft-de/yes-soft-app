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
import de.yessoft.android.activity.EmployeesActivity;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardViewHolder> {
    private List<mItem> items = new ArrayList<>();

    private Context mContext;

    public DashboardAdapter(Context context) {
        mContext = context;
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

        holder.card.setOnClickListener((v) -> {
            if (position == 1)
                mContext.startActivity(new Intent(mContext, EmployeesActivity.class));
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
