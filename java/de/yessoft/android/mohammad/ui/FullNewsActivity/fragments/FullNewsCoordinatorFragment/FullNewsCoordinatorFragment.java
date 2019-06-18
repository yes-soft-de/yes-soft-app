package de.yessoft.android.mohammad.ui.FullNewsActivity.fragments.FullNewsCoordinatorFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import de.yessoft.android.mohammad.R;
import de.yessoft.android.mohammad.generators.BundleGenerator;
import de.yessoft.android.mohammad.model.FullNewsItem;
import de.yessoft.android.mohammad.ui.FullNewsActivity.fragments.ErrorFragment.ErrorFragment;
import de.yessoft.android.mohammad.ui.FullNewsActivity.fragments.FullNewsFragment.FullNewsFragment;
import de.yessoft.android.mohammad.ui.FullNewsActivity.fragments.LoadingFragment.LoadingFragment;

import static de.yessoft.android.mohammad.consts.BUNDLE_KEYS.KEY_ERR_MSG;
import static de.yessoft.android.mohammad.consts.BUNDLE_KEYS.KEY_FULL_NEWS_ID;

public class FullNewsCoordinatorFragment extends Fragment implements FullNewsCoordinator {

    private static final String TAG = "ML_CoordinatorFrag";

    private BundleGenerator generator = new BundleGenerator();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_full_news_coordinator, container, false);
        if (getArguments() != null && getArguments().getString(KEY_FULL_NEWS_ID, null) != null) {
            inflateLoadingWithId(getArguments().getString(KEY_FULL_NEWS_ID));
        } else {
            inflateErrorFragmentWithMsg("Null Arguments");
            Log.d(TAG, "onCreateView: Null Arguments or Null ID");
        }
        return v;
    }

    private void inflateLoadingWithId(String id) {
        // Send The Request For The Full News
        Fragment fragment = new LoadingFragment();

        fragment.setArguments(generator.generateBundle(KEY_FULL_NEWS_ID, id));

        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.full_news_container, fragment)
                .commit();
    }

    private void inflateErrorFragmentWithMsg(String errMsg){
        // Send The Request For The Full News
        Fragment fragment = new ErrorFragment();

        fragment.setArguments(generator.generateBundle(KEY_ERR_MSG, errMsg));

        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.full_news_container, fragment)
                .commit();
    }

    @Override
    public void errGettingFullNews(String errMsg) {
        // after getting the request the Coordinator should Inflate Error Fragment,
        // After inflating Error Fragment will use @param errMsg to set the Error Msg

        Log.d(TAG, "errGettingFullNews: Error! " + errMsg);
        // Create the Fragment
        Fragment fragment = new ErrorFragment();

        // Set the Argument to it, namely errMsg
        fragment.setArguments(generator.generateBundle(KEY_ERR_MSG, errMsg));

        // Request
        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.full_news_container, fragment)
                .commit();
    }

    @Override
    public void setFullNews(FullNewsItem fullNewsItem) {
        Log.d(TAG, "setFullNews: Moving To Full News");
        Fragment fragment = new FullNewsFragment();

        fragment.setArguments(fullNewsItem.toBundle());

        getChildFragmentManager().beginTransaction()
                .replace(R.id.full_news_container, fragment)
                .commit();
    }
}
