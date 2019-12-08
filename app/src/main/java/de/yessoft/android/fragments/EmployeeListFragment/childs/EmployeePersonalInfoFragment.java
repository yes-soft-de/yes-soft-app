package de.yessoft.android.fragments.EmployeeListFragment.childs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.yessoft.android.R;
import de.yessoft.android.fragments.EmployeeListFragment.IEmployeeList;

public class EmployeePersonalInfoFragment extends Fragment {
    private IEmployeeList mParent;

    @BindView(R.id.tv_employee_name)
    TextView tvName;

    @BindView(R.id.tv_employee_age)
    TextView tvAge;

    @BindView(R.id.tv_employee_quote)
    TextView tvQuote;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mParent = (IEmployeeList) getParentFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee_info, container, false);
        ButterKnife.bind(this, view);

        initViews();

        return view;
    }

    private void initViews() {
        tvName.setText(mParent.getInfo().getName());
        tvAge.setText(mParent.getInfo().getAge());
        // TODO Change This To Quote
        tvQuote.setText(mParent.getInfo().getPosition());
    }
}
