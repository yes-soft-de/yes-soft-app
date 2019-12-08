package de.yessoft.android.fragments.EmployeeListFragment;

<<<<<<< Updated upstream
public class EmployeeListPresenter {
=======
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.yessoft.android.entity.Blog;
import de.yessoft.android.entity.EmployeeDetails;
import de.yessoft.android.entity.EmployeeInfo;
import de.yessoft.android.entity.Project;
import de.yessoft.android.entity.Skill;
import de.yessoft.android.service.EmployeeService;

public class EmployeeListPresenter {
    private EmployeeService mEmployeeService;

    public EmployeeListPresenter() {
        mEmployeeService = new EmployeeService();
    }

    public List<EmployeeDetails> getEmployeesDetailsList() {
        try {
            List<EmployeeInfo> infoList = mEmployeeService.getEmployeeList();
            List<EmployeeDetails> employeeList = new ArrayList<>();
            for (EmployeeInfo i : infoList) {
                employeeList.add(getEmployeeDetails(i.getId()));
            }
            return employeeList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private EmployeeDetails getEmployeeDetails(String employeeId) {
        return new EmployeeDetails(
                getEmployeeInfo(employeeId),
                getEmployeeSkills(employeeId),
                getEmployeeBlogs(employeeId),
                getEmployeeProjects(employeeId)
        );
    }

    private EmployeeInfo getEmployeeInfo(String employeeId) {
        try {
            for (EmployeeInfo info : mEmployeeService.getEmployeeList())
                if (info.getId().equals(employeeId))
                    return info;
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Project> getEmployeeProjects(String employeeId) {
        try {
            return mEmployeeService.getEmployeeProjectList(employeeId);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Blog> getEmployeeBlogs(String employeeId) {
        try {
            return mEmployeeService.getEmployeeBlogList(employeeId);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Skill> getEmployeeSkills(String employeeId) {
        try {
            return mEmployeeService.getEmployeeSkillList(employeeId);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
>>>>>>> Stashed changes
}
