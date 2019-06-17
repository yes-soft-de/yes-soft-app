package de.yessoft.android.mohammad.ui.MainActivity.fragments.NewsFeedFragment;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import de.yessoft.android.mohammad.mappers.NewsItemMapper;
import de.yessoft.android.mohammad.ui.MainActivity.fragments.NewsFeedFragment.NewsFeedRV.NewsFeedAdapter;

import static de.yessoft.android.mohammad.consts.DB_KEYS.TABLE_NEWS_FEED;

class MySpecialORM {
    private static final String TAG = "ML_MySpecialORM";

    private NewsFeedAdapter RecyclerViewAdapter;

    MySpecialORM(NewsFeedAdapter adapter){
        RecyclerViewAdapter = adapter;
    }

    void getNewsFeed(){
        FirebaseFirestore DB = FirebaseFirestore.getInstance();

        // Read Data Once,
        CollectionReference newsItems = DB.collection(TABLE_NEWS_FEED);

        newsItems.get().addOnCompleteListener(task -> {
            QuerySnapshot snapshot = task.getResult();
            if (task.isSuccessful()) {
                if (snapshot != null) {
                    for (DocumentSnapshot s : snapshot.getDocuments()) {
                        NewsItemMapper newsItemMapper = new NewsItemMapper();
                        RecyclerViewAdapter.addNewsItem(newsItemMapper.DocumentSnapToNewsItem(s));
                    }
                }
            }
        });
    }
}
