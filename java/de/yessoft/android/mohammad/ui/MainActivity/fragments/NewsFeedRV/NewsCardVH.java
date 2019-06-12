package de.yessoft.android.mohammad.ui.MainActivity.fragments.NewsFeedRV;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import de.yessoft.android.mohammad.R;

public class NewsCardVH extends RecyclerView.ViewHolder {

    TextView tvSource; // The White on Colour Text

    TextView tvHeader; // The One u actually read
    TextView tvSummery; // More on the subject
    Button btnMore; // This takes u to the full news Activity
    AppCompatImageView ivImg; // This is an image that would zoom, well not yet :)

    NewsCardVH(@NonNull View itemView) {
        super(itemView);

        tvSource = itemView.findViewById(R.id.tv_news_source);
        tvHeader = itemView.findViewById(R.id.tv_news_header);
        tvSummery = itemView.findViewById(R.id.tv_news_summery);

        btnMore = itemView.findViewById(R.id.btn_holder);

        ivImg = itemView.findViewById(R.id.iv_news_image);

    }
}
