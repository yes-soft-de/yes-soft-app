package de.yessoft.android.mohammad.ui.FullNewsActivity.fragments.LoadingFragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import de.yessoft.android.mohammad.R;
import de.yessoft.android.mohammad.mappers.FullNewsMapper;
import de.yessoft.android.mohammad.ui.FullNewsActivity.fragments.FullNewsCoordinatorFragment.FullNewsCoordinator;
import de.yessoft.android.mohammad.consts.*;

public class LoadingFragment extends Fragment {
    private static final String TAG = "ML_LoadingFragment";
    private FullNewsCoordinator coordinator;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (getParentFragment() instanceof FullNewsCoordinator) {
            coordinator = (FullNewsCoordinator) getParentFragment();
        } else {
            throw new IllegalArgumentException("Coordinator is Not Implemented");
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_loading, container, false);

        if (getArguments() != null) {
            String id = getArguments().getString(BUNDLE_KEYS.KEY_FULL_NEWS_ID, null);
            if (id != null) {
                Log.d(TAG, "onCreateView: Requesting News ID: " + id);
                // start the request
                requestFullNews(id);
            } else {
                coordinator.errGettingFullNews("Error Getting Full News ID, Application Problem");
            }
        } else {
            // Either the Application didn't send the full news id, or the it is null in the database
            coordinator.errGettingFullNews("Error Getting Full News ID, Application Problem");
        }

        return v;
    }

    private void requestFullNews(String id) {
        Log.d(TAG, "requestFullNews: Requesting News");
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        DocumentReference newsItems = db.collection(DB_KEYS.TABLE_FULL_NEWS).document(id);

        newsItems.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();

                // Check if Document Exists
                if (document != null && document.exists()) {

                    // Collect the Document and Export it For Further Processing
                    FullNewsMapper mapper = new FullNewsMapper();
                    coordinator.setFullNews(mapper.toFullNews(document));
                    Log.d(TAG, "requestFullNews: ");
                } else {

                    // There we get an error
                    coordinator.errGettingFullNews("Error finding the News Node!");
                }
            } else {

                // another error
                coordinator.errGettingFullNews("Unsuccessful Task! " + task.getException());
            }
        });
    }
}
