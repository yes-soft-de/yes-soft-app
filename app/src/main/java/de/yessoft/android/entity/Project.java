package de.yessoft.android.entity;

import com.google.gson.annotations.SerializedName;

public class Project {

    @SerializedName("startDate")
    private String mStartDate;

    @SerializedName("endDate")
    private String mEndDate;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("link")
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
