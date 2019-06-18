package de.yessoft.android.mohammad.model;

import android.util.ArrayMap;
import android.util.Log;

import com.google.firebase.firestore.DocumentSnapshot;

import java.util.List;
import java.util.Map;

public class NewsItem {
    private static final String TAG = "ML_NewsItem";

    private static final String KEY_HEADING = "heading";
    private static final String KEY_IMG = "img";
    private static final String KEY_SUMMERY = "summery";
    private static final String KEY_FULL_NEWS_ID = "full_news_id";

    private String Heading;
    private String Summery;
    private String Img;
    private String FullNewsId;

    // region Construct
    private NewsItem() {
    }

    public NewsItem(DocumentSnapshot documentSnapshot) {
        if ((String) documentSnapshot.get(NewsItem.KEY_HEADING) != null) {
            Heading = (String) documentSnapshot.get(NewsItem.KEY_HEADING);
        } else {
            Log.d(TAG, "NewsItem: Error, No Heading!");
            return;
        }
        Summery = (String) documentSnapshot.get(NewsItem.KEY_SUMMERY);
        Img = (String) documentSnapshot.get(NewsItem.KEY_IMG);
        FullNewsId = (String) documentSnapshot.get(NewsItem.KEY_FULL_NEWS_ID);
    }
    // endregion

    // region Factory Methods
    public Map<String, Object> toHashMap() {
        Map<String, Object> resultMap = new ArrayMap<>();
        resultMap.put(KEY_HEADING, Heading);
        resultMap.put(KEY_IMG, Img);
        resultMap.put(KEY_SUMMERY, Summery);
        resultMap.put(KEY_FULL_NEWS_ID, FullNewsId);

        return resultMap;
    }
    // endregion

    // region Getters and Setters
    public String getSummery() {
        return Summery;
    }

    public void setSummery(String summery) {
        Summery = summery;
    }

    public String getFullNewsId() {
        return FullNewsId;
    }

    public void setFullNewsId(String fullNewsId) {
        FullNewsId = fullNewsId;
    }

    public String getHeading() {
        return Heading;
    }

    public void setHeading(String heading) {
        Heading = heading;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    // endregion
}
