package de.yessoft.android.fragments.SalesPitchFragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.yessoft.android.R;

public class SalesPitchFragment extends Fragment {

    @BindView(R.id.sales_avatar)
    AppCompatImageView ivAvatar;

    @BindView(R.id.sales_bg)
    ConstraintLayout ivBg;

    @BindView(R.id.sales_text)
    TextView tvText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sales_pitch, container, false);
        ButterKnife.bind(this, view);

        initViews();
        return view;
    }

    private void initViews() {
        if (getArguments() == null)
            return;

        String txt = getArguments().getString("text");
        String link = getArguments().getString("link");
        String bg = getArguments().getString("bg");

        if (txt != null)
            tvText.setText(txt);

        try {
            ivBg.setBackgroundColor(Color.parseColor(bg));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }


        Glide.with(this)
                .load(link)
                .into(ivAvatar);
    }
}

