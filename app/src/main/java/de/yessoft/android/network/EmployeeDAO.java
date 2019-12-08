package de.yessoft.android.network;

import de.yessoft.android.config.YesSoftNetworkConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmployeeDAO {
    private Retrofit mClient;

    public EmployeeDAO() {
        mClient = new Retrofit.Builder()
                .baseUrl(YesSoftNetworkConfig.BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getNetworkClient() {
        return mClient;
    }
}
