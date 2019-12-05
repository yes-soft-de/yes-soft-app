package de.yessoft.android.fragments.SalesPitchFragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.PictureDrawable;
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
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.material.button.MaterialButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.yessoft.android.R;
import de.yessoft.android.decoders.SvgSoftwareLayerSetter;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class SalesPitchFragment extends Fragment {

    private ISalesPitchList mParent;
    private RequestBuilder<PictureDrawable> requestBuilder;

    @BindView(R.id.sales_avatar)
    AppCompatImageView ivAvatar;

    @BindView(R.id.sales_bg)
    ConstraintLayout ivBg;

    @BindView(R.id.sales_next)
    MaterialButton btnNext;

    @BindView(R.id.sales_text)
    TextView tvText;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mParent = (ISalesPitchList) getParentFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sales_pitch, container, false);
        ButterKnife.bind(this, view);

        requestBuilder =
                Glide.with(this)
                        .as(PictureDrawable.class)
                        .placeholder(R.drawable.ic_yes_soft_logo)
                        .error(R.drawable.ic_under_construction)
                        .transition(withCrossFade())
                        .listener(new SvgSoftwareLayerSetter());

        initViews();
        return view;
    }

    private void initViews() {
        tvText.setText(mParent.getCurrentInfo().text);
        ivBg.setBackgroundColor(Color.parseColor(mParent.getCurrentInfo().bg));
        requestBuilder
                .load(mParent.getCurrentInfo().imageLink)
                .into(ivAvatar);
        btnNext.setOnClickListener((v) -> {
            mParent.showNextPage();
        });
    }
}

