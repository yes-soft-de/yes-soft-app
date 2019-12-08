package de.yessoft.android.service;

import java.io.IOException;
import java.util.List;

import de.yessoft.android.entity.PitchInfo;
import de.yessoft.android.network.EmployeeDAO;
import de.yessoft.android.network.EmployeeGetterInterface;
import retrofit2.Call;
import retrofit2.Retrofit;

public class ServicesService {

    Retrofit mClient;

    public ServicesService() {
        mClient = new EmployeeDAO().getNetworkClient();
    }

    public List<PitchInfo> getServiceList() throws IOException {
        EmployeeGetterInterface employeeGetterInterface = mClient.create(EmployeeGetterInterface.class);
        Call<List<PitchInfo>> employeeList = employeeGetterInterface.getServices();
        return employeeList.execute().body();
    }
}
