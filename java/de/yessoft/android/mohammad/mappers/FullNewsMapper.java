package de.yessoft.android.mohammad.mappers;

import android.os.Bundle;

import com.google.firebase.firestore.DocumentSnapshot;

import de.yessoft.android.mohammad.model.FullNewsItem;

import static de.yessoft.android.mohammad.consts.DB_KEYS.KEY_FULL_NEWS_BODY;
import static de.yessoft.android.mohammad.consts.DB_KEYS.KEY_FULL_NEWS_HEADING;
import static de.yessoft.android.mohammad.consts.DB_KEYS.KEY_FULL_NEWS_IMAGE_URL;
import static de.yessoft.android.mohammad.consts.DB_KEYS.KEY_FULL_NEWS_WEB_URL;

public class FullNewsMapper {

    public FullNewsItem toFullNews(DocumentSnapshot document) {

        FullNewsItem theNews = new FullNewsItem();
        theNews.setHeading((String) document.get(KEY_FULL_NEWS_HEADING));
        theNews.setImgURL((String) document.get(KEY_FULL_NEWS_IMAGE_URL));
        theNews.setBody((String) document.get(KEY_FULL_NEWS_BODY));
        theNews.setWebURL((String) document.get(KEY_FULL_NEWS_WEB_URL));

        return theNews;
    }

    public FullNewsItem extractFullNewsFromBundle(Bundle bundle) {
        FullNewsItem item = new FullNewsItem();
        item.setBody(bundle.getString(KEY_FULL_NEWS_BODY));
        item.setHeading(bundle.getString(KEY_FULL_NEWS_HEADING));
        item.setImgURL(bundle.getString(KEY_FULL_NEWS_IMAGE_URL));
        item.setWebURL(bundle.getString(KEY_FULL_NEWS_WEB_URL));
        return item;
    }
}
