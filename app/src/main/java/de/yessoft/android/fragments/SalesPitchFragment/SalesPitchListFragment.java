package de.yessoft.android.fragments.SalesPitchFragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.yessoft.android.R;
import de.yessoft.android.adapter.services.ServicesViewPagerAdapter;
import de.yessoft.android.entity.PitchInfo;
import de.yessoft.android.service.ServicesService;
import me.relex.circleindicator.CircleIndicator3;

public class SalesPitchListFragment extends Fragment implements ISalesPitchList {
    private static final String TAG = "ML__";
    @BindView(R.id.vp_services)
    ViewPager2 mServicesViewPager;

    @BindView(R.id.vp_services_indicator)
    CircleIndicator3 indicator;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sales_pitch_list, container, false);
        // Load Services List
        ButterKnife.bind(this, view);
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

            ServicesViewPagerAdapter adapter = new ServicesViewPagerAdapter(getContext(), pitchInfos);
            mServicesViewPager.setAdapter(adapter);

            indicator.setViewPager(mServicesViewPager);
        }
    }
}