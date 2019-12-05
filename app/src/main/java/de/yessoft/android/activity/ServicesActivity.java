package de.yessoft.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import de.yessoft.android.R;
import de.yessoft.android.fragments.SalesPitchFragment.SalesPitchFragment;
import de.yessoft.android.fragments.SalesPitchFragment.SalesPitchListFragment;

public class ServicesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_services, new SalesPitchListFragment())
                .commit();

    }



}
