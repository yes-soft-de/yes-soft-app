package de.yessoft.android.network;

import de.yessoft.android.entity.EmployeeInfo;
<<<<<<< Updated upstream
=======
import de.yessoft.android.entity.PitchInfo;
import de.yessoft.android.entity.Project;
import de.yessoft.android.entity.Skill;
import retrofit2.Call;
>>>>>>> Stashed changes
import retrofit2.http.GET;

public interface EmployeeGetterInterface {
    @GET("")
    EmployeeInfo info();

<<<<<<< Updated upstream
=======
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
>>>>>>> Stashed changes
}
