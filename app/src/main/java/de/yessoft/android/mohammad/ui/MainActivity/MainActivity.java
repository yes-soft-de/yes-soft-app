package de.yessoft.android.mohammad.ui.MainActivity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.firebase.ui.auth.AuthUI;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

import de.yessoft.android.mohammad.R;
import de.yessoft.android.mohammad.fragments.NewsFeedFragment.NewsFeedFragment;
import de.yessoft.android.mohammad.fragments.ServicesFragment.ServicesFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ML_MainActivity";
    private static final int RC_SIGN_IN = 19;

    private DrawerLayout drawerLayout;

    // region Life Cycle of an Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // region Assign UI
        /*
         (This would be easier if ButterKnife recognized that
         There is a Goddamn AndroidX Version out there #Just_Saying :)
          */
        Toolbar mainToolbar = findViewById(R.id.tb_main);
        NavigationView mainNavigation = findViewById(R.id.nav_main);
        drawerLayout = findViewById(R.id.drawer_main);
        // endregion

        // region Check Login Status and Redirect If Not Logged In
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        // endregion

        inflateFeed();

        // region UI Actions

        mainToolbar.setNavigationOnClickListener ((v) -> {
            drawerLayout.openDrawer(GravityCompat.START);
        });

        mainNavigation.setNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
                case R.id.nav_news_feed:
                    inflateFeed();
                    break;
                case R.id.nav_services:
                    inflateServices();
                    break;
                case R.id.nav_sign_in:
                    signIn();
                    break;
                default:
                    inflateFeed();
                    return false;
            }

            return true;
        });

        // endregion

    }

    // endregion

    // region Fragment Inflation
    private void inflateFeed(){
        // region Load NewsFeedFragment

        drawerLayout.closeDrawers();

        // TODO: check if Connected to the Internet, If Not Inflate Error Fragment

        NewsFeedFragment fragment = new NewsFeedFragment();
        getSupportFragmentManager().
                beginTransaction()
                .replace(R.id.fl_container, fragment)
                .commit();

        // endregion
    }

    private void inflateServices(){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, new ServicesFragment())
                .commit();
        drawerLayout.closeDrawers();
    }

    // region Sign In Functions
    private void signIn() {

        drawerLayout.closeDrawers();

        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.PhoneBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build());

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setLogo(R.drawable.ic_logo)
                        .build(),
                RC_SIGN_IN);
    }

    private void handleSignInResult(int resultCode){
        if (resultCode == RESULT_OK) {
            // Successfully signed in
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                String userPhone = user.getPhoneNumber();
                Toast.makeText(this, userPhone , Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Error Logging In :(", Toast.LENGTH_SHORT).show();
        }
    }
    // endregion
}
