package de.yessoft.android.mohammad.ui.FullNewsActivity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import de.yessoft.android.mohammad.R;
import de.yessoft.android.mohammad.consts.BUNDLE_KEYS;
import de.yessoft.android.mohammad.generators.BundleGenerator;
import de.yessoft.android.mohammad.ui.FullNewsActivity.fragments.ErrorFragment.ErrorFragment;
import de.yessoft.android.mohammad.ui.FullNewsActivity.fragments.FullNewsCoordinatorFragment.FullNewsCoordinatorFragment;

public class FullNewsActivity extends AppCompatActivity {
    private static final String TAG = "ML_FullNewsActivity";

    BundleGenerator generator = new BundleGenerator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_news);

        // The Full News ID Should be passed to the activity in order to work
        if (getIntent().getExtras() != null) {
            String id = getIntent().getExtras().getString(BUNDLE_KEYS.KEY_FULL_NEWS_ID, null);
            if (id != null) {
                inflateFullNewsWithId(id);
            } else {
                inflateErrorFragment("Null Full News ID");
            }
        } else {
            inflateErrorFragment("Empty Extras!");
        }
    }

    // region Transaction Methods

    // This related by Blood to this Class, Moving it to another require more work and less security
    void inflateErrorFragment(String msg){
        Log.d(TAG, "inflateErrorFragment: " + msg);
        // The Beauties of using fragments :)))))

        Fragment fragment = new ErrorFragment();
        fragment.setArguments(generator.generateBundle(BUNDLE_KEYS.KEY_ERR_MSG, msg));

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.full_news_frag_container, fragment)
                .commit();
    }

    void inflateFullNewsWithId(String id){
        Fragment fragment = new FullNewsCoordinatorFragment();
        fragment.setArguments(generator.generateBundle(BUNDLE_KEYS.KEY_FULL_NEWS_ID, id));

        // Inflate Coordinator
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.full_news_frag_container, fragment)
                .commit();
    }
    // endregion
}
