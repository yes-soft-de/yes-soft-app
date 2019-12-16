package de.yessoft.android.adapter.services_body;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.card.MaterialCardView;

import de.yessoft.android.R;

public class ServicesBodyViewHolder extends RecyclerView.ViewHolder {

    MaterialCardView cardView;
    LottieAnimationView image;
    TextView tvService;

    public ServicesBodyViewHolder(@NonNull View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.card_service_body);
        image = itemView.findViewById(R.id.card_service_body_image);
        tvService = itemView.findViewById(R.id.card_service_body_text);
    }
}
