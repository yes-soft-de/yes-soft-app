package de.yessoft.android.mohammad.consts;

public final class DB_KEYS {
    /*
     using the class method for security purposes,
     plus it's easier to get in the inner Classed without the need for Context
     Variables. :)
      */

    public static final String TABLE_NEWS_FEED = "newsfeed";
    public static final String TABLE_FULL_ARTICLE = "articles";
    public static final String TABLE_SERVICES = "services";

    // region News Feed Keys
    public static final String KEY_NEWS_FEED_HEADING = "heading";
    public static final String KEY_NEWS_FEED_IMG = "img";
    public static final String KEY_NEWS_FEED_SUMMERY = "summery";
    public static final String KEY_NEWS_FEED_FULL_NEWS_ID = "full_news_id";
    // endregion

    // region Full Article Keys
    public static final String KEY_ARTICLE_BLOCK_TYPE = "type";
    public static final String KEY_ARTICLE_BLOCK_CONTENT = "content";
    // endregion

    // region Services
    public static final String KEY_SERVICE_HEAD = "head";
    public static final String KEY_SERVICE_BODY = "body";
    public static final String KEY_SERVICE_IMAGE = "img";
    public static final String KEY_SERVICE_URL = "article_id";
    // endregion
}
