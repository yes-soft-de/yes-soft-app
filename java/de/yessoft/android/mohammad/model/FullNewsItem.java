package de.yessoft.android.mohammad.model;

import android.os.Bundle;

import de.yessoft.android.mohammad.consts.DB_KEYS;

public class FullNewsItem {

    private String Heading;
    private String Body;
    private String ImgURL;
    private String webURL;

    public FullNewsItem(){}

    public Bundle toBundle(){
        Bundle bundle = new Bundle();

        bundle.putString(DB_KEYS.KEY_FULL_NEWS_HEADING, Heading);
        bundle.putString(DB_KEYS.KEY_FULL_NEWS_IMAGE_URL, ImgURL);
        bundle.putString(DB_KEYS.KEY_FULL_NEWS_BODY , Body);

        return bundle;

    }

    // region Get and Set Methods
    public String getHeading() {
        return Heading;
    }

    public void setHeading(String heading) {
        Heading = heading;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getImgURL() {
        return ImgURL;
    }

    public void setImgURL(String imgURL) {
        ImgURL = imgURL;
    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }

    // endregion
}
