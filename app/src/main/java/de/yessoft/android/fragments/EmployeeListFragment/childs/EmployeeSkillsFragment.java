package de.yessoft.android.fragments.EmployeeListFragment.childs;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.chip.ChipGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.yessoft.android.R;
import de.yessoft.android.fragments.EmployeeListFragment.IEmployeeList;

public class EmployeeSkillsFragment extends Fragment {
    private IEmployeeList mParent;

    @BindView(R.id.skills_chip_group)
    ChipGroup skillsChips;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mParent = (IEmployeeList) getParentFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee_skills, container, false);
        ButterKnife.bind(this, view);

        initChips();

        return view;
    }

    private void initChips() {
        for (String skill : mParent.getSkillList()) {
            assert getContext() != null;
            Chip chip = new Chip(getContext());
            chip.setText(skill);
            skillsChips.addView(chip);
        }
    }
}
