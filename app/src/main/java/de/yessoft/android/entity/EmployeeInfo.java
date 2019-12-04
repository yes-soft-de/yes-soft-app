package de.yessoft.android.entity;

public class EmployeeInfo {
    private String mName;
    private String mAge;
    private String mImageLink;
    private String mQuote;
    private String mPosition;

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
}
