package de.yessoft.android.mohammad.ui.ArticleActivity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import de.yessoft.android.mohammad.R;
import de.yessoft.android.mohammad.consts.BUNDLE_KEYS;
import de.yessoft.android.mohammad.fragments.ArticleFragment.ArticleFragment;
import de.yessoft.android.mohammad.fragments.ErrorFragment.ErrorFragment;
import de.yessoft.android.mohammad.generators.BundleGenerator;

public class ArticleActivity extends AppCompatActivity {
    private static final String TAG = "ML_ArticleActivity";

    // variables
    BundleGenerator generator = new BundleGenerator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        // Don't Start anything if The Activity is Not Started with ID
        if (getIntent().getExtras() != null) {
            if (getIntent().getExtras().getString(BUNDLE_KEYS.KEY_ARTICLE_ID, null) != null) {
                inflateList(getIntent().getExtras().getString(BUNDLE_KEYS.KEY_ARTICLE_ID));
            }
        } else {
            // Inflate Error Fragment
            inflateErrorFragment("Error 403, Bad Request!");
        }
    }

    void inflateList(String articleId){

        ArticleFragment fragment = new ArticleFragment();
        fragment.setArguments(generator.generateBundle(BUNDLE_KEYS.KEY_ARTICLE_ID, articleId));

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.full_article_container, fragment)
                .commit();
    }

    void inflateErrorFragment(String msg){
        Log.d(TAG, "inflateErrorFragment: " + msg);
        // The Beauties of using fragments :)))))

        Fragment fragment = new ErrorFragment();
        fragment.setArguments(generator.generateBundle(BUNDLE_KEYS.KEY_ERR_MSG, msg));

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.full_article_container, fragment)
                .commit();
    }
}
