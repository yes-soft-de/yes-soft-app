package de.yessoft.android.adapter.services_header;

import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import de.yessoft.android.R;

public class ServiceViewHolder extends RecyclerView.ViewHolder {
    LottieAnimationView ivAvatar;
    FrameLayout ivBg;

    public ServiceViewHolder(@NonNull View itemView) {
        super(itemView);
        ivAvatar = itemView.findViewById(R.id.sales_avatar);
        ivBg = itemView.findViewById(R.id.sales_bg);
    }
}
