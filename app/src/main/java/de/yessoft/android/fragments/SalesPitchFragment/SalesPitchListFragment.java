package de.yessoft.android.fragments.SalesPitchFragment;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.yessoft.android.R;
import de.yessoft.android.adapter.services_body.ServiceBodyAdapter;
import de.yessoft.android.adapter.services_header.ServicesViewPagerAdapter;
import de.yessoft.android.entity.PitchInfo;
import de.yessoft.android.service.ServicesService;

public class SalesPitchListFragment extends Fragment implements ISalesPitchList {
    private static final String TAG = "ML__";
    @BindView(R.id.vp_services)
    ViewPager2 mServicesViewPager;
    @BindView(R.id.btnNext)
    FloatingActionButton btnNext;
    @BindView(R.id.rv_services_body)
    RecyclerView rvServicesBody;
    @BindView(R.id.tb_sales)
    MaterialToolbar tbServices;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sales_pitch_list, container, false);
        // Load Services List
        ButterKnife.bind(this, view);
        btnNext.setEnabled(false);
        startFragmentSequence();
        return view;
    }

    private void startFragmentSequence() {
        new servicesGetter().execute();
    }

    public class servicesGetter extends AsyncTask<Void, Void, List<PitchInfo>> {
        @Override
        protected List<PitchInfo> doInBackground(Void... voids) {
            try {
                List<PitchInfo> infoList = new ServicesService().getServiceList();
                for (PitchInfo info : infoList)
                    Log.d(TAG, "doInBackground: " + info);
                return infoList;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<PitchInfo> pitchInfos) {
            super.onPostExecute(pitchInfos);

            if (pitchInfos == null) {
                return;
            }

            ServicesViewPagerAdapter headerAdapter = new ServicesViewPagerAdapter(getContext(), pitchInfos);
            ServiceBodyAdapter bodyAdapter = new ServiceBodyAdapter(getContext(), pitchInfos.get(0).body);
            mServicesViewPager.setAdapter(headerAdapter);


            btnNext.setEnabled(true);
            btnNext.setOnClickListener((v) -> {
                Integer currPos = mServicesViewPager.getCurrentItem();
                if (currPos + 1 <= pitchInfos.size())
                    mServicesViewPager.setCurrentItem(currPos + 1);
            });
            tbServices.setTitle(pitchInfos.get(mServicesViewPager.getCurrentItem()).text);
            tbServices.setTitleTextColor(Color.parseColor(pitchInfos.get(mServicesViewPager.getCurrentItem()).textColor));
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
            rvServicesBody.setLayoutManager(layoutManager);
            rvServicesBody.setAdapter(bodyAdapter);

            mServicesViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                    bodyAdapter.setList(pitchInfos.get(position).body);
                }
            });
        }
    }
}