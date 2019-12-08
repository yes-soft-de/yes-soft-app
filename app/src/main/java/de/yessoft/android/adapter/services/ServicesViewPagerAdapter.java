package de.yessoft.android.adapter.services;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.yessoft.android.R;
import de.yessoft.android.entity.PitchInfo;

public class ServicesViewPagerAdapter extends RecyclerView.Adapter<ServiceViewHolder> {
    private List<PitchInfo> mInfoList;
    private Context mContext;


    public ServicesViewPagerAdapter(Context context, List<PitchInfo> infosList) {
        mContext = context;
        mInfoList = infosList;
    }

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_sales_pitch, parent, false);
        return new ServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder holder, int position) {
        holder.tvText.setText(mInfoList.get(position).text);
        Glide.with(mContext)
                .load(mInfoList.get(position).imageLink)
                .into(holder.ivAvatar);
        holder.tvText.setTextColor(Color.parseColor(mInfoList.get(position).textColor));
        holder.ivBg.setBackgroundColor(Color.parseColor(mInfoList.get(position).bg));
    }

    @Override
    public int getItemCount() {
        if (mInfoList == null)
            return 0;
        return mInfoList.size();
    }
}
