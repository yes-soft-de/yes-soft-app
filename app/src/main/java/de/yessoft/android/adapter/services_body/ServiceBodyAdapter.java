package de.yessoft.android.adapter.services_body;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.yessoft.android.R;
import de.yessoft.android.entity.PitchInfo;

public class ServiceBodyAdapter extends RecyclerView.Adapter<ServicesBodyViewHolder> {

    private Context mContext;
    private List<PitchInfo> mServiceList;

    public ServiceBodyAdapter(Context context, List<PitchInfo> serviceBody) {
        mContext = context;
        mServiceList = serviceBody;
    }

    public void setList(List<PitchInfo> serviceBody) {
        mServiceList = serviceBody;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ServicesBodyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_service_body, parent, false);
        return new ServicesBodyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicesBodyViewHolder holder, int position) {
        holder.image.setAnimationFromUrl(mServiceList.get(position).imageLink);
        holder.image.playAnimation();
        holder.cardView.setCardBackgroundColor(Color.parseColor(mServiceList.get(position).bg));
        holder.tvService.setText(mServiceList.get(position).text);
    }

    @Override
    public int getItemCount() {
        if (mServiceList == null)
            return 0;
        return mServiceList.size();
    }
}
