package de.yessoft.android.network;

import de.yessoft.android.entity.EmployeeInfo;
import retrofit2.http.GET;

public interface EmployeeGetterInterface {
    @GET("")
    EmployeeInfo info();

}
