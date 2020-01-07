package de.yessoft.android.activity.mainActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.mxn.soul.flowingdrawer_core.FlowingDrawer;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.yessoft.android.R;
import de.yessoft.android.fragments.DashboardFragment;
import de.yessoft.android.fragments.SheetsFragment;
import de.yessoft.android.fragments.SplashFragment;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    // get the bottom sheet view
    @BindView(R.id.bottom_sheet)
    LinearLayout llBottomSheet;
    BottomSheetBehavior bottomSheetBehavior;

    @BindView(R.id.drawerlayout)
    FlowingDrawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Dexter.withActivity(this)
                .withPermission(Manifest.permission.INTERNET)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {/* ... */}

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {/* ... */}

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {/* ... */}
                });

        ButterKnife.bind(this);

        setupSheets();

        setupDrawer();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_main, new DashboardFragment())
                .commit();

        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }

    void setupDrawer() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_drawer, new SplashFragment())
                .commit();
    }

    void setupSheets() {
        // init the bottom sheet behavior
        bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet);


        // change the state of the bottom sheet
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_contacts, new SheetsFragment())
                .commit();

        // set the peek height
        bottomSheetBehavior.setPeekHeight(340);
    }

    @Override
    public void openSheets() {
        // change the state of the bottom sheet
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    public void openDrawer(View view) {
        drawer.openMenu();
    }
}
