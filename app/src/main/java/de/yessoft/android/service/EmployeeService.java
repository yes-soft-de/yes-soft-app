package de.yessoft.android.service;

import java.io.IOException;
import java.util.List;

import de.yessoft.android.entity.Blog;
import de.yessoft.android.entity.EmployeeInfo;
import de.yessoft.android.entity.Project;
import de.yessoft.android.entity.Skill;
import de.yessoft.android.network.EmployeeDAO;
import de.yessoft.android.network.EmployeeGetterInterface;
import retrofit2.Call;
import retrofit2.Retrofit;

public class EmployeeService {

    private Retrofit mClient;

    public EmployeeService() {
        mClient = new EmployeeDAO().getNetworkClient();
    }

    public List<EmployeeInfo> getEmployeeList() throws IOException {
        EmployeeGetterInterface employeeGetterInterface = mClient.create(EmployeeGetterInterface.class);
        Call<List<EmployeeInfo>> employeeList = employeeGetterInterface.getClientList();
        return employeeList.execute().body();
    }

    public List<Skill> getEmployeeSkillList(String employeeId) throws IOException {
        EmployeeGetterInterface employeeGetterInterface = mClient.create(EmployeeGetterInterface.class);
        Call<List<Skill>> employeeSkillsList = employeeGetterInterface.getEmployeeSkills(employeeId);
        return employeeSkillsList.execute().body();
    }

    public List<Project> getEmployeeProjectList(String employeeId) throws IOException {
        EmployeeGetterInterface employeeGetterInterface = mClient.create(EmployeeGetterInterface.class);
        Call<List<Project>> employeeSkillsList = employeeGetterInterface.getEmployeeProjects(employeeId);
        return employeeSkillsList.execute().body();
    }

    public List<Blog> getEmployeeBlogList(String employeeId) throws IOException {
        EmployeeGetterInterface employeeGetterInterface = mClient.create(EmployeeGetterInterface.class);
        Call<List<Blog>> employeeSkillsList = employeeGetterInterface.getEmployeeBlogs(employeeId);
        return employeeSkillsList.execute().body();
    }
}
