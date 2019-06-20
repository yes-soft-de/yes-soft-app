package de.yessoft.android.mohammad.fragments.ServicesFragment.ServicesAdapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import de.yessoft.android.mohammad.R;

public class ServicesVH extends RecyclerView.ViewHolder {

    AppCompatImageView ivServiceImage;
    TextView tvServiceName;
    TextView tvServiceSummery;
    Button btnMore;

    public ServicesVH(@NonNull View itemView) {
        super(itemView);

        ivServiceImage = itemView.findViewById(R.id.iv_service_image);
        tvServiceName = itemView.findViewById(R.id.tv_service_header);
        tvServiceSummery = itemView.findViewById(R.id.tv_service_body);
        btnMore = itemView.findViewById(R.id.btn_more);
    }
}
