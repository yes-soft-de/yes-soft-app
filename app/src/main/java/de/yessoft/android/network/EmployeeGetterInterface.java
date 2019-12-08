package de.yessoft.android.network;

import java.util.List;

import de.yessoft.android.entity.Blog;
import de.yessoft.android.entity.EmployeeInfo;
import de.yessoft.android.entity.PitchInfo;
import de.yessoft.android.entity.Project;
import de.yessoft.android.entity.Skill;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EmployeeGetterInterface {
    @GET("")
    EmployeeInfo info();

    @GET("employee")
    Call<List<EmployeeInfo>> getClientList();

    @GET("skill/employee/{employee_id}")
    Call<List<Skill>> getEmployeeSkills(@Path("employee_id") String employeeId);

    @GET("project/employee/{employee_id}")
    Call<List<Project>> getEmployeeProjects(@Path("employee_id") String employeeId);

    @GET("blog/employee/{employee_id}")
    Call<List<Blog>> getEmployeeBlogs(@Path("employee_id") String employeeId);

    @GET("services")
    Call<List<PitchInfo>> getServices();
}
