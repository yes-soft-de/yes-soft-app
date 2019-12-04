package de.yessoft.android.entity;

public class Employee {
    private String mName;
    private String mAge;
    private String mImageLink;

    public Employee() {
    }

    public void setName(String name) {
        mName = name;
    }

    public void setAge(String age) {
        mAge = age;
    }

    public void setImageLinks(String imageLink) {
        mImageLink = imageLink;
    }

    public String getName() {
        return mName;
    }

    public String getAge() {
        return mAge;
    }

    public String getImageLink() {
        return mImageLink;
    }
}
