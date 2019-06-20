package de.yessoft.android.mohammad.db;

import android.util.Log;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import de.yessoft.android.mohammad.fragments.ServicesFragment.ServicesAdapter.iServiceAdapter;
import de.yessoft.android.mohammad.model.NewsItem;
import de.yessoft.android.mohammad.model.ServiceItem;

import static de.yessoft.android.mohammad.consts.DB_KEYS.TABLE_NEWS_FEED;
import static de.yessoft.android.mohammad.consts.DB_KEYS.TABLE_SERVICES;

public class ServiceConnector {
    private static final String TAG = "ML_ServiceConnector";

    // Observer Get
    public void attachObserverToServiceList(iServiceAdapter targetAdapter) {
        FirebaseFirestore DB = FirebaseFirestore.getInstance();

        // Read Data Once,
        CollectionReference newsItems = DB.collection(TABLE_SERVICES);

        newsItems.get().addOnCompleteListener(task -> {
            QuerySnapshot snapshot = task.getResult();
            if (task.isSuccessful()) {
                if (snapshot != null) {
                    for (DocumentSnapshot s : snapshot.getDocuments()) {
                        targetAdapter.addService(new ServiceItem(s));
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
