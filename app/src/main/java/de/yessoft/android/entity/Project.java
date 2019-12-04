package de.yessoft.android.entity;

public class Project {
    private String mStartDate;
    private String mEndDate;
    private String mTitle;
    private String mLink;

    public Project() {
    }

    public Project(String title, String link, String startDate, String endDate) {
        mTitle = title;
        mLink = link;
        mStartDate = startDate;
        mEndDate = endDate;
    }

    public void setEndDate(String endDate) {
        mEndDate = endDate;
    }

    public void setStartDate(String startDate) {
        mStartDate = startDate;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setLink(String link) {
        mLink = link;
    }

    public String getEndDate() {
        return mEndDate;
    }

    public String getStartDate() {
        return mStartDate;
    }

    public String getLink() {
        return mLink;
    }

    public String getTitle() {
        return mTitle;
    }
}
