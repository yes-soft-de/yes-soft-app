package de.yessoft.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import de.yessoft.android.R;
import de.yessoft.android.fragments.EmployeeListFragment.EmployeeListFragment;

public class EmployeesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_employees, new EmployeeListFragment())
                .commit();
    }
}
