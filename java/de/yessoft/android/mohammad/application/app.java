package de.yessoft.android.mohammad.application;

import android.app.Application;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

public class app extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // region Enable Offline Data
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings
                .Builder()
                .setPersistenceEnabled(true)
                .build();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.setFirestoreSettings(settings);
        // endregion
    }
}
