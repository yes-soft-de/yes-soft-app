package de.yessoft.android.fragments.EmployeeListFragment;

import java.util.List;

import de.yessoft.android.entity.Blog;
import de.yessoft.android.entity.EmployeeInfo;
import de.yessoft.android.entity.Project;

public interface IEmployeeList {
    List<Blog> getBlogList();
    List<String> getSkillList();
    List<Project> getProjectList();
    EmployeeInfo getInfo();
}
