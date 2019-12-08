package de.yessoft.android.entity;

import com.google.gson.annotations.SerializedName;

public class EmployeeInfo {

    @SerializedName("name")
    private String mName;

    @SerializedName("age")
    private String mAge;

    @SerializedName("link")
    private String mImageLink;

    @SerializedName("position")
    private String mPosition;

    @SerializedName("id")
    private String mId;

    private String mQuote;

    public EmployeeInfo() {
    }

    public EmployeeInfo(String name, String position, String age, String quote, String imageLink) {
        mName = name;
        mPosition = position;
        mAge = age;
        mQuote = quote;
        mImageLink = imageLink;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setAge(String age) {
        mAge = age;
    }

    public String getAge() {
        return mAge;
    }

    public void setImageLinks(String imageLink) {
        mImageLink = imageLink;
    }

    public String getImageLink() {
        return mImageLink;
    }

    public void setPosition(String position) {
        mPosition = position;
    }

    public String getPosition() {
        return mPosition;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }
}
