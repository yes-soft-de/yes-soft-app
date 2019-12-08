package de.yessoft.android.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.yessoft.android.R;

public class SheetsFragment extends Fragment {

    @BindView(R.id.ll_facebook) LinearLayout facebook;
    @BindView(R.id.ll_linked_in) LinearLayout linkedIn;
    @BindView(R.id.ll_phone_01) LinearLayout phone01;
    @BindView(R.id.ll_phone_02) LinearLayout phone02;
    @BindView(R.id.ll_web) LinearLayout web;
    @BindView(R.id.ll_whatsapp) LinearLayout whatsapp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        assert getContext() != null;
        facebook.setOnClickListener((v) -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getContext().getString(R.string.link_facebook_page)))));
        linkedIn.setOnClickListener((v) -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getContext().getString(R.string.link_linked_in)))));
        phone01.setOnClickListener((v) -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getContext().getString(R.string.link_phone_01)))));
        phone02.setOnClickListener((v) -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getContext().getString(R.string.link_phone_02)))));
        web.setOnClickListener((v) -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getContext().getString(R.string.link_web)))));
        whatsapp.setOnClickListener((v) -> startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getContext().getString(R.string.link_whatsapp)))));
    }
}
