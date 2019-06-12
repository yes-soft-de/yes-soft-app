package de.yessoft.android.mohammad.ui.MainActivity.fragments;

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
import de.yessoft.android.mohammad.ui.MainActivity.fragments.NewsFeedRV.NewsFeedAdapter;

public class NewsFeedFragment extends Fragment {
    private static final String TAG = "ML_NewsFeedFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_news_feed, container, false);

        RecyclerView rvNewsFeed = v.findViewById(R.id.rv_news_feed);

        rvNewsFeed.setLayoutManager(new LinearLayoutManager(getContext()));
        NewsFeedAdapter adapter = new NewsFeedAdapter();
        rvNewsFeed.setAdapter(adapter);

        MySpecialORM myORM = new MySpecialORM(adapter);
        myORM.getNewsFeed();

        return v;
    }
}
