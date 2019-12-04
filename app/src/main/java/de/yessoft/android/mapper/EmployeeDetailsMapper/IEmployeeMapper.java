package de.yessoft.android.mapper.EmployeeDetailsMapper;

import org.json.JSONException;
import org.json.JSONObject;

import de.yessoft.android.entity.EmployeeDetails;

public interface IEmployeeMapper {

    EmployeeDetails toEmployeeDetails(JSONObject employeeJson) throws JSONException;
}
