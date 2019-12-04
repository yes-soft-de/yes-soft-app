package de.yessoft.android.entity;

public class Blog {
    private String mTitle;
    private String mLink;
    private String mPublishDate;

    public Blog() {
    }

    public Blog(String title, String link, String publishDate) {
        mTitle = title;
        mLink = link;
        mPublishDate = publishDate;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setLink(String link) {
        mLink = link;
    }

    public void setPublishDate(String publishDate) {
        mPublishDate = publishDate;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getLink() {
        return mLink;
    }

    public String getPublishDate() {
        return mPublishDate;
    }
}
