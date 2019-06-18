package de.yessoft.android.mohammad.ui.MainActivity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

import de.yessoft.android.mohammad.R;
import de.yessoft.android.mohammad.ui.MainActivity.fragments.NewsFeedFragment;

public class MainActivity extends AppCompatActivity {

    // private static final String TAG = "ML_MainActivity";
    private static final int RC_SIGN_IN = 19;

    // region Life Cycle of an Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // region Check Login Status and Redirect If Not Logged In
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user == null) {
            signIn();
        }
        // endregion

        // region Load NewsFeed Fragment

        NewsFeedFragment fragment = new NewsFeedFragment();
        getSupportFragmentManager().
                beginTransaction()
                .add(R.id.fl_container, fragment)
                .commit();

        // endregion
    }

    // endregion

    // region Sign In Functions
    private void signIn() {

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
