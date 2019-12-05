package de.yessoft.android.fragments.SalesPitchFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import de.yessoft.android.R;
import de.yessoft.android.activity.MainActivity.MainActivity;

public class SalesPitchListFragment extends Fragment implements ISalesPitchList{

    private int currentPos = 0;
    private List<PitchInfo> pitchInfoList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sales_pitch_list, container, false);
        // Load Services List
        pitchInfoList = new ArrayList<>();
        pitchInfoList.add(new PitchInfo("Yes Soft?!!", "https://yes-soft.de/wp-content/themes/yes-soft/img/logo.svg", "#FFFFFF"));
        pitchInfoList.add(new PitchInfo("Yes Soft?!!", "https://yes-soft.de/wp-content/themes/yes-soft/img/logo.svg", "#FFFFFF"));
        pitchInfoList.add(new PitchInfo("Yes Soft?!!", "https://yes-soft.de/wp-content/themes/yes-soft/img/logo.svg", "#FFFFFF"));
        pitchInfoList.add(new PitchInfo("Yes Soft?!!", "https://yes-soft.de/wp-content/themes/yes-soft/img/logo.svg", "#FFFFFF"));

        startFragmentSequence();

        return view;
    }

    private void startFragmentSequence() {
        int[] animH = new int[]{R.anim.slide_in_right, R.anim.slide_out_left};
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fl_sales, new SalesPitchFragment())
                .setCustomAnimations(animH[0], animH[1])
                .commit();
    }

    @Override
    public void showNextPage() {
        if (currentPos + 1 > pitchInfoList.size()) {
            startActivity(new Intent(getContext(), MainActivity.class));
        }
        else {

            int[] animH = new int[]{R.anim.slide_in_right, R.anim.slide_out_left};
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.fl_sales, new SalesPitchFragment())
                    .setCustomAnimations(animH[0], animH[1])
                    .commit();
        }
    }

    @Override
    public PitchInfo getCurrentInfo() {
        return pitchInfoList.get(currentPos);
    }

    public class PitchInfo {
        public PitchInfo(String text, String image, String bg) {
            this.text = text;
            this.imageLink = image;
            this.bg = bg;
        }
        String text;
        String imageLink;
        String bg;
    }
}