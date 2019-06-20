package de.yessoft.android.mohammad.fragments.NewsFeedFragment;

import android.content.Intent;
import android.os.Bundle;
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
import de.yessoft.android.mohammad.db.NewsFeedConnector;
import de.yessoft.android.mohammad.fragments.NewsFeedFragment.NewsFeedRV.NewsFeedAdapter;
import de.yessoft.android.mohammad.ui.ArticleActivity.ArticleActivity;

/*
    * This class is used to show News Feed in a recycler view,
    * The main idea is to create the Recycler view and add the blocks as
    * soon as it arrives, this gives future opportunities for more reactive
    * patterns, and gives the code some flex
 */
public class NewsFeedFragment extends Fragment implements iNewsFeed {
    // private static final String TAG = "ML_NewsFeedFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_news_feed, container, false);

        // bind Views
        RecyclerView rvNewsFeed = v.findViewById(R.id.rv_news_feed);

        // Show the List
        rvNewsFeed.setLayoutManager(new LinearLayoutManager(getContext()));
        NewsFeedAdapter adapter = new NewsFeedAdapter(getContext(), this);
        rvNewsFeed.setAdapter(adapter);

        // Attach the Observer
        NewsFeedConnector myORM = new NewsFeedConnector();
        myORM.attachObserverToNewsFeed(adapter);

        return v;
    }

    @Override
    public void requestArticleWithId(String id) {
        Intent intent = new Intent(getActivity(), ArticleActivity.class);
        intent.putExtra(BUNDLE_KEYS.KEY_ARTICLE_ID, id);
        startActivity(intent);
    }
}
