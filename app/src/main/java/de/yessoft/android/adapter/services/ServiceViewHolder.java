package de.yessoft.android.adapter.services;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import de.yessoft.android.R;

public class ServiceViewHolder extends RecyclerView.ViewHolder {
    AppCompatImageView ivAvatar;
    ConstraintLayout ivBg;
    TextView tvText;

    public ServiceViewHolder(@NonNull View itemView) {
        super(itemView);
        ivAvatar = itemView.findViewById(R.id.sales_avatar);
        ivBg = itemView.findViewById(R.id.sales_bg);
        tvText = itemView.findViewById(R.id.sales_text);
    }
}
