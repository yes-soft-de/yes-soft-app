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

    @GET("employee")
    Call<List<EmployeeInfo>> getClientList();

    @GET("skill/{employee_id}")
    Call<List<Skill>> getEmployeeSkills(@Path("employee_id") String employeeId);

    @GET("project/{employee_id}")
    Call<List<Project>> getEmployeeProjects(@Path("employee_id") String employeeId);

    @GET("blog/{employee_id}")
    Call<List<Blog>> getEmployeeBlogs(@Path("employee_id") String employeeId);

    @GET("service")
    Call<List<PitchInfo>> getServices();
}
