package de.yessoft.android.fragments.EmployeeListFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextSwitcher;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ramotion.cardslider.CardSliderLayoutManager;
import com.ramotion.cardslider.CardSnapHelper;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.yessoft.android.R;
import de.yessoft.android.adapter.employees.EmployeeCardsAdapter;
import de.yessoft.android.entity.Blog;
import de.yessoft.android.entity.EmployeeDetails;
import de.yessoft.android.entity.EmployeeInfo;
import de.yessoft.android.entity.Project;
import de.yessoft.android.fragments.EmployeeListFragment.childs.EmployeeBlogsFragment;
import de.yessoft.android.fragments.EmployeeListFragment.childs.EmployeePersonalInfoFragment;
import de.yessoft.android.fragments.EmployeeListFragment.childs.EmployeeProjectsFragment;
import de.yessoft.android.fragments.EmployeeListFragment.childs.EmployeeSkillsFragment;

public class EmployeeListFragment extends Fragment implements IEmployeeList {

    private CardSliderLayoutManager employeesLayoutManager;
    private int currentPosition;
    private List<EmployeeDetails> mEmployeeList;

    // region Views
    @BindView(R.id.rv_employee_cards)
    RecyclerView rvEmployeesCards;

    @BindView(R.id.nv_employee_sections)
    BottomNavigationView nvEmployeeSections;

    @BindView(R.id.ts_position_name)
    TextView tvPositionName;

    // endregion

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee_list, container, false);
        ButterKnife.bind(this, view);
        initEmployeeList();

        nvEmployeeSections.setOnNavigationItemSelectedListener((v) -> {
            switch (v.getItemId()) {
                case R.id.menu_general_info:
                    displayGeneralInfo();
                    return true;
                case R.id.menu_projects:
                    displayProjects();
                    return true;
                case R.id.menu_skills:
                    displaySkills();
                    return true;
                case R.id.menu_blogs:
                    displayBlogs();
                    return true;
            }
            return false;
        });

        return view;
    }

    private void initEmployeeList() {
        // TODO Replace With DB Query
        mEmployeeList = new ArrayList<>();

        EmployeeInfo info = new EmployeeInfo("Mohammad", "Developer", "24", "Work Hard and Aim High", "https://picsum.photos/200/300");
        EmployeeInfo info2 = new EmployeeInfo("Mohammad", "Designer", "24", "Work Hard and Aim High", "https://picsum.photos/300/300");
        List<Project> projectList = new ArrayList<>();
        projectList.add(new Project("ishtar art", "https://www.google.com","Jun 19", "Aug 19"));
        projectList.add(new Project("ishtar art", "http://www.google.com","Jun 19", "Aug 19"));
        projectList.add(new Project("ishtar art", "http://www.google.com","Jun 19", "Aug 19"));

        List<Blog> blogList = new ArrayList<>();
        blogList.add(new Blog("Android Blog", "http://www.google.com", "Jun 2019"));
        blogList.add(new Blog("Angular Blog", "http://www.google.com", "Jun 2019"));
        blogList.add(new Blog("Web Blog", "http://www.google.com", "Jun 2019"));
        blogList.add(new Blog("PHP Blog", "http://www.google.com", "Jun 2019"));
        blogList.add(new Blog("Security Blog", "http://www.google.com", "Jun 2019"));
        blogList.add(new Blog("Another Blog", "http://www.google.com", "Jun 2019"));
        blogList.add(new Blog("And a Blog", "http://www.google.com", "Jun 2019"));


        List<String> skillList = new ArrayList<>();
        skillList.add("Communication");
        skillList.add("Design Patterns");

        EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setInfo(info);
        employeeDetails.setProjects(projectList);
        employeeDetails.setSkills(skillList);
        employeeDetails.setBlogs(blogList);

        EmployeeDetails employeeDetails2 = new EmployeeDetails();
        employeeDetails2.setInfo(info2);
        employeeDetails2.setProjects(projectList);
        employeeDetails2.setSkills(skillList);
        employeeDetails2.setBlogs(blogList);

        // As Placeholders
        for (int i = 0; i < 10; i++)
            if (i % 2 == 0)
                mEmployeeList.add(employeeDetails);
            else
                mEmployeeList.add(employeeDetails2);

        rvEmployeesCards.setAdapter(new EmployeeCardsAdapter(getContext(), mEmployeeList));
        rvEmployeesCards.setLayoutManager(new CardSliderLayoutManager(getContext()));
        new CardSnapHelper().attachToRecyclerView(rvEmployeesCards);

        rvEmployeesCards.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    onActiveCardChange();
                }
            }
        });

        employeesLayoutManager = (CardSliderLayoutManager) rvEmployeesCards.getLayoutManager();

        int[] animH = new int[]{R.anim.slide_in_right, R.anim.slide_out_left};
        int[] animV = new int[]{R.anim.slide_in_top, R.anim.slide_out_bottom};
        updateActiveFragment(animH, animV);
    }

    // region View Updates
    private void displayGeneralInfo() {
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fl_employees, new EmployeePersonalInfoFragment())
                .commit();
    }

    private void displayGeneralInfo(int[] animH, int[] animV) {
        getChildFragmentManager().beginTransaction()
                .setCustomAnimations(animV[0], animV[1])
                .replace(R.id.fl_employees, new EmployeePersonalInfoFragment())
                .commit();
    }

    private void displayProjects() {
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fl_employees, new EmployeeProjectsFragment())
                .commit();
    }

    private void displayProjects(int[] animH, int[] animV) {
        getChildFragmentManager().beginTransaction()
                .setCustomAnimations(animV[0], animV[1])
                .replace(R.id.fl_employees, new EmployeeProjectsFragment())
                .commit();
    }

    private void displaySkills() {
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fl_employees, new EmployeeSkillsFragment())
                .commit();
    }

    private void displaySkills(int[] animH, int[] animV) {
        getChildFragmentManager().beginTransaction()
                .setCustomAnimations(animV[0], animV[1])
                .replace(R.id.fl_employees, new EmployeeSkillsFragment())
                .commit();
    }

    private void displayBlogs() {
        getChildFragmentManager().beginTransaction()
                .replace(R.id.fl_employees, new EmployeeBlogsFragment())
                .commit();
    }

    private void displayBlogs(int[] animH, int[] animV) {
        getChildFragmentManager().beginTransaction()
                .setCustomAnimations(animV[0], animV[1])
                .replace(R.id.fl_employees, new EmployeeBlogsFragment())
                .commit();
    }

    // endregion

    // region View Listeners
    private void onActiveCardChange() {
        final int pos = employeesLayoutManager.getActiveCardPosition();
        if (pos == RecyclerView.NO_POSITION || pos == currentPosition) {
            return;
        }

        // For Animation
        onActiveCardChange(pos);
    }

    private void onActiveCardChange(int pos) {
        int[] animH = new int[]{R.anim.slide_in_right, R.anim.slide_out_left};
        int[] animV = new int[]{R.anim.slide_in_top, R.anim.slide_out_bottom};

        final boolean left2right = pos < currentPosition;
        if (left2right) {
            animH[0] = R.anim.slide_in_left;
            animH[1] = R.anim.slide_out_right;

            animV[0] = R.anim.slide_in_bottom;
            animV[1] = R.anim.slide_out_top;
        }

        if (mEmployeeList.get(pos).getInfo().getPosition() != null)
            tvPositionName.setText(mEmployeeList.get(pos).getInfo().getPosition());

        updateActiveFragment(animH, animV);

        currentPosition = pos;
    }

    private void updateActiveFragment(int[] animH, int[] animV) {
        switch (nvEmployeeSections.getSelectedItemId()) {
            case R.id.menu_general_info:
                displayGeneralInfo(animH, animV);
                break;
            case R.id.menu_projects:
                displayProjects(animH, animV);
                break;
            case R.id.menu_skills:
                displaySkills(animH, animV);
                break;
            case R.id.menu_blogs:
                displayBlogs(animH, animV);
                break;
        }
    }
    // endregion

    // region Callbacks

    @Override
    public List<Blog> getBlogList() {
        return mEmployeeList.get(currentPosition).getBlogs();
    }

    @Override
    public List<String> getSkillList() {
        return mEmployeeList.get(currentPosition).getSkills();
    }

    @Override
    public List<Project> getProjectList() {
        return mEmployeeList.get(currentPosition).getProjects();
    }

    @Override
    public EmployeeInfo getInfo() {
        return mEmployeeList.get(currentPosition).getInfo();
    }
    // endregion
}
