package de.yessoft.android.entity;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDetails {

    private EmployeeInfo mEmployee;
    private List<Skill> mSkills;
    private List<Blog> mBlogs;
    private List<Project> mProjects;

    public EmployeeDetails() {
        mEmployee = new EmployeeInfo();
        mSkills = new ArrayList<>();
        mBlogs = new ArrayList<>();
        mProjects = new ArrayList<>();
    }

    public EmployeeDetails(EmployeeInfo info, List<Skill> skills, List<Blog> blogList, List<Project> projectList) {
        mEmployee = info;
        mSkills = skills;
        mBlogs = blogList;
        mProjects = projectList;
    }

    public void setInfo(EmployeeInfo info) {
        mEmployee = info;
    }

    public void setSkills(List<Skill> skills) {
        mSkills = skills;
    }

    public void setBlogs(List<Blog> blogList) {
        mBlogs = blogList;
    }

    public List<Blog> getBlogs() {
        return mBlogs;
    }

    public void setProjects(List<Project> projectList) {
        mProjects = projectList;
    }

    public EmployeeInfo getInfo() {
        return mEmployee;
    }

    public List<Skill> getSkills() {
        return mSkills;
    }

    public List<Project> getProjects() {
        return mProjects;
    }
}
