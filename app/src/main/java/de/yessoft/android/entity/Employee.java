package de.yessoft.android.entity;

public class Employee {
    String mName;
    String mAge;
    String mImageLink;

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
