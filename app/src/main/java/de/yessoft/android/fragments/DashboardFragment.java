package de.yessoft.android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.yessoft.android.R;
import de.yessoft.android.activity.mainActivity.IMainActivity;
import de.yessoft.android.adapter.dashboard.DashboardAdapter;

public class DashboardFragment extends Fragment {

    @BindView(R.id.rv_dashboard)
    RecyclerView rvDashboard;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, view);

        rvDashboard.setAdapter(new DashboardAdapter(getContext(), (IMainActivity) getActivity()));
        rvDashboard.setLayoutManager(new LinearLayoutManager(getContext()));
        initViews();

        return view;
    }

    private void initViews() {
    }
}
