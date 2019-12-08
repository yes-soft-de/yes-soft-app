package de.yessoft.android.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import de.yessoft.android.R;
import de.yessoft.android.fragments.EmployeeListFragment.EmployeeListFragment;
import de.yessoft.android.fragments.SplashFragment;

public class EmployeesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_employees, new EmployeeListFragment())
                .commit();

        setupDrawer();
    }

    void setupDrawer() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_drawer, new SplashFragment())
                .commit();
    }
}
