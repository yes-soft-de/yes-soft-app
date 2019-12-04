package de.yessoft.android.fragments.EmployeeListFragment.childs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import de.yessoft.android.R;
import de.yessoft.android.fragments.EmployeeListFragment.IEmployeeList;

public class EmployeeSkillsFragment extends Fragment {
    IEmployeeList mParent;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mParent = (IEmployeeList) getParentFragment();
    }
}
