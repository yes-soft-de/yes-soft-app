package de.yessoft.android.fragments.EmployeeListFragment.childs;

import android.content.Context;
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
import de.yessoft.android.adapter.projects.ProjectListAdapter;
import de.yessoft.android.fragments.EmployeeListFragment.IEmployeeList;

public class EmployeeProjectsFragment extends Fragment {
    IEmployeeList mParent;

    @BindView(R.id.rv_employee_projects)
    RecyclerView rvEmployeeProjects;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mParent = (IEmployeeList) getParentFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee_projects, container, false);
        ButterKnife.bind(this, view);

        initList();
        return view;
    }

    private void initList() {
        ProjectListAdapter adapter = new ProjectListAdapter(getContext(), mParent.getProjectList());
        rvEmployeeProjects.setLayoutManager(new LinearLayoutManager(getContext()));
        rvEmployeeProjects.setAdapter(adapter);

    }
}
