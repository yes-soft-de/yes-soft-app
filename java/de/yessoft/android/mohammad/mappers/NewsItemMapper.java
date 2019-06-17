package de.yessoft.android.mohammad.mappers;

import android.util.Log;

import com.google.firebase.firestore.DocumentSnapshot;

import de.yessoft.android.mohammad.model.NewsItem;

import static de.yessoft.android.mohammad.consts.DB_KEYS.KEY_NEWS_FEED_FULL_NEWS_ID;
import static de.yessoft.android.mohammad.consts.DB_KEYS.KEY_NEWS_FEED_HEADING;
import static de.yessoft.android.mohammad.consts.DB_KEYS.KEY_NEWS_FEED_IMG;
import static de.yessoft.android.mohammad.consts.DB_KEYS.KEY_NEWS_FEED_SUMMERY;

public class NewsItemMapper {
    private static final String TAG = "ML_toNewsItem";

    // region News Item
    public NewsItem DocumentSnapToNewsItem(DocumentSnapshot documentSnapshot) {
        NewsItem item = new NewsItem();
        if (documentSnapshot.get(KEY_NEWS_FEED_HEADING) != null) {
            item.setHeading((String) documentSnapshot.get(KEY_NEWS_FEED_HEADING));
        } else {
            Log.d(TAG, "NewsItem: Error, No Heading!");
            return null;
        }
        item.setSummery((String) documentSnapshot.get(KEY_NEWS_FEED_SUMMERY));
        item.setImg((String) documentSnapshot.get(KEY_NEWS_FEED_IMG));
        item.setFullNewsId((String) documentSnapshot.get(KEY_NEWS_FEED_FULL_NEWS_ID));

        return item;
    }
    // endregion
}
