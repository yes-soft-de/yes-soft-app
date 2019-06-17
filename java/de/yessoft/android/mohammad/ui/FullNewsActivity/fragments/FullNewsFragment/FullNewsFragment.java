package de.yessoft.android.mohammad.ui.FullNewsActivity.fragments.FullNewsFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import de.yessoft.android.mohammad.R;
import de.yessoft.android.mohammad.mappers.FullNewsMapper;
import de.yessoft.android.mohammad.model.FullNewsItem;

public class FullNewsFragment extends Fragment {
    private static final String TAG = "ML_FullNewsFragment";

    private FullNewsMapper fullNewsMapper = new FullNewsMapper();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_full_news, container, false);

        FullNewsItem item = fullNewsMapper.extractFullNewsFromBundle(getArguments());

        TextView tvHeader = v.findViewById(R.id.tv_full_news_header);
        TextView tvBody = v.findViewById(R.id.tv_full_news_body);
        AppCompatImageView ivImage = v.findViewById(R.id.iv_full_news_image);

        tvHeader.setText(item.getHeading());
        tvBody.setText(item.getBody());
        Picasso.get().load(item.getImgURL()).into(ivImage);

        return v;
    }
}
