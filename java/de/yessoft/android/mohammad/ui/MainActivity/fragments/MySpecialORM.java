package de.yessoft.android.mohammad.ui.MainActivity.fragments;

import android.util.Log;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

import de.yessoft.android.mohammad.model.NewsItem;
import de.yessoft.android.mohammad.ui.MainActivity.fragments.NewsFeedRV.NewsFeedAdapter;

class MySpecialORM {
    private static final String TAG = "ML_MySpecialORM";

    private NewsFeedAdapter RecyclerViewAdapter;

    MySpecialORM(NewsFeedAdapter adapter){
        RecyclerViewAdapter = adapter;
    }

    // TODO: Make this Live Observable Pattern -_-
    void getNewsFeed(){
        FirebaseFirestore DB = FirebaseFirestore.getInstance();

        // Read Data Once,
        CollectionReference newsItems = DB.collection("newsfeed");

        newsItems.get().addOnCompleteListener(task -> {
            QuerySnapshot snapshot = task.getResult();
            if (task.isSuccessful()) {
                if (snapshot != null) {
                    for (DocumentSnapshot s : snapshot.getDocuments()) {
                        RecyclerViewAdapter.addNewsItem(new NewsItem(s));
                    }
                }
            }
        });
    }
}
