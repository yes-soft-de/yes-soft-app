package de.yessoft.android.adapter.dashboard;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import de.yessoft.android.R;

public class DashboardViewHolder extends RecyclerView.ViewHolder {

    AppCompatImageView image;
    TextView text;
    ConstraintLayout card;

    public DashboardViewHolder(@NonNull View itemView) {
        super(itemView);

        image = itemView.findViewById(R.id.iv_i_dashboard_image);
        text = itemView.findViewById(R.id.iv_i_dashboard_text);
        card = itemView.findViewById(R.id.dashboard_card);
    }
}
