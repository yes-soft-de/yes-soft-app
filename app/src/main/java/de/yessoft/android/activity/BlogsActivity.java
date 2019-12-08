package de.yessoft.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import de.yessoft.android.R;
import de.yessoft.android.fragments.UnderCostructionFragment.UnderConstructionFragment;

public class BlogsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogs);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_blogs, new UnderConstructionFragment())
                .commit();
    }
}
