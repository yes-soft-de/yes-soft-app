package de.yessoft.android.mohammad.db;

import android.util.Log;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import de.yessoft.android.mohammad.fragments.NewsFeedFragment.NewsFeedRV.iNewsItemInterface;
import de.yessoft.android.mohammad.model.NewsItem;

import static de.yessoft.android.mohammad.consts.DB_KEYS.TABLE_NEWS_FEED;

/*
 * This is used to get the news feed from the DB,
 * that said, i will implement 2 methods,
 * 1. get the list BEFORE the Showing
 * 2. get the list AS IT COMES and add it using Interface
 * the current implementation of the fragment uses the second
 * option, cuz ... Why Not -_-
 */
public class NewsFeedConnector {
    private static final String TAG = "ML_NewsFeedDAO";
    /*
     * @param: targetAdapter: this is used to get an instance
     * of the current viewed Recycler View
     */

    // Observer Get
    public void attachObserverToNewsFeed(iNewsItemInterface targetAdapter) {
        FirebaseFirestore DB = FirebaseFirestore.getInstance();

        // Read Data Once,
        CollectionReference newsItems = DB.collection(TABLE_NEWS_FEED);

        newsItems.get().addOnCompleteListener(task -> {
            QuerySnapshot snapshot = task.getResult();
            if (task.isSuccessful()) {
                if (snapshot != null) {
                    for (DocumentSnapshot s : snapshot.getDocuments()) {
                        targetAdapter.addNewsItem(new NewsItem(s));
                    }
                }
            }
        });
    }

    // Normal Get
    public List<NewsItem> getNewsFeed() {
        List<NewsItem> newsItemList = new ArrayList<>();

        FirebaseFirestore DB = FirebaseFirestore.getInstance();

        CollectionReference newsItems = DB.collection(TABLE_NEWS_FEED);
        newsItems
                .get()
                .addOnCompleteListener(task -> {
                    QuerySnapshot snapshot = task.getResult();
                    if (task.isSuccessful()) {
                        if (snapshot != null && !snapshot.isEmpty()) {
                            for (DocumentSnapshot s : snapshot.getDocuments()) {
                                newsItemList.add(new NewsItem(s));
                            }
                        }
                    } else {
                        Log.d(TAG, "getNewsFeed: ");
                    }
                });

        return newsItemList;
    }
}
