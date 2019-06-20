package de.yessoft.android.mohammad.model;

import android.os.Bundle;

import com.google.firebase.firestore.DocumentSnapshot;

import static de.yessoft.android.mohammad.consts.DB_KEYS.KEY_NEWS_FEED_FULL_NEWS_ID;
import static de.yessoft.android.mohammad.consts.DB_KEYS.KEY_NEWS_FEED_HEADING;
import static de.yessoft.android.mohammad.consts.DB_KEYS.KEY_NEWS_FEED_IMG;
import static de.yessoft.android.mohammad.consts.DB_KEYS.KEY_NEWS_FEED_SUMMERY;

public class NewsItem {
    private static final String TAG = "ML_NewsItem";

    private String Heading;
    private String Summery;
    private String Img;
    private String FullNewsId;

    // region Construct
    public NewsItem() {
    }

    public NewsItem(DocumentSnapshot documentSnapshot){
        setHeading((String) documentSnapshot.get(KEY_NEWS_FEED_HEADING));
        setSummery((String) documentSnapshot.get(KEY_NEWS_FEED_SUMMERY));
        setImg((String) documentSnapshot.get(KEY_NEWS_FEED_IMG));
        setFullNewsId((String) documentSnapshot.get(KEY_NEWS_FEED_FULL_NEWS_ID));
    }
    // endregion

    // Checker, Only Heading is Required
    boolean isNodeOK(){
        return !Heading.isEmpty();
    }

    Bundle toBundle(){
        Bundle resultMap = new Bundle();
        resultMap.putString(KEY_NEWS_FEED_HEADING, getHeading());
        resultMap.putString(KEY_NEWS_FEED_IMG, getImg());
        resultMap.putString(KEY_NEWS_FEED_SUMMERY, getSummery());
        resultMap.putString(KEY_NEWS_FEED_FULL_NEWS_ID, getFullNewsId());
        return resultMap;
    }


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
