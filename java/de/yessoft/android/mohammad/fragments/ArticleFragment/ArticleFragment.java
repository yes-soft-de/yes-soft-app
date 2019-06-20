package de.yessoft.android.mohammad.fragments.ArticleFragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import de.yessoft.android.mohammad.R;
import de.yessoft.android.mohammad.consts.BUNDLE_KEYS;
import de.yessoft.android.mohammad.db.ArticleConnector;
import de.yessoft.android.mohammad.fragments.ArticleFragment.ArticleAdapter.ArticleAdapter;

public class ArticleFragment extends Fragment implements iArticleFragment {
    private static final String TAG = "ML_ArticleFragment";
    // This Shows The List of Article Blocks in an Activity

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_full_service, container, false);

        if (getArguments() != null){
            String id = getArguments().getString(BUNDLE_KEYS.KEY_ARTICLE_ID, null);
            if (id != null){

                // Bind Views
                RecyclerView rv = view.findViewById(R.id.rv_service_activity);
                rv.setLayoutManager(new LinearLayoutManager(getContext()));

                // Create Adapters and Attach it
                ArticleAdapter adapter = new ArticleAdapter(this);
                rv.setAdapter(adapter);

                // Attach Observer to the Adapter
                ArticleConnector connector = new ArticleConnector();
                connector.attachArticleBlocks(id ,adapter);
            } else {
                Log.d(TAG, "onCreateView: Null ID!");
            }
        } else {
            Log.d(TAG, "onCreateView: Null Arguments!");
        }

        return view;
    }

    @Override
    public void requestWebRedirect(String link) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(intent);
    }
}
