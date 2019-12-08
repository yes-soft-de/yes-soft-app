package de.yessoft.android.fragments.EmployeeListFragment;

import java.util.List;

import de.yessoft.android.entity.Blog;
import de.yessoft.android.entity.EmployeeInfo;
import de.yessoft.android.entity.Project;
import de.yessoft.android.entity.Skill;

public interface IEmployeeList {
    List<Blog> getBlogList();
    List<Skill> getSkillList();
    List<Project> getProjectList();
    EmployeeInfo getInfo();
}
