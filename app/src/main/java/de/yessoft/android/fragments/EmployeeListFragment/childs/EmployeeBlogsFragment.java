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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.yessoft.android.R;
import de.yessoft.android.adapter.blogs.BlogsListAdapter;
import de.yessoft.android.entity.Blog;
import de.yessoft.android.fragments.EmployeeListFragment.IEmployeeList;

public class EmployeeBlogsFragment extends Fragment {

    private IEmployeeList parent;

    @BindView(R.id.rv_employee_blogs)
    RecyclerView rvBlogs;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        parent = (IEmployeeList) getParentFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee_blogs, container, false);
        ButterKnife.bind(this, view);

        initList();

        return view;
    }

    private void initList() {
        List<Blog> mBlogList = parent.getBlogList();

        if (mBlogList != null && mBlogList.size() > 0) {
            BlogsListAdapter adapter = new BlogsListAdapter(getContext(), mBlogList);
            rvBlogs.setAdapter(adapter);
            rvBlogs.setLayoutManager(new LinearLayoutManager(getContext()));
        }
    }
}

