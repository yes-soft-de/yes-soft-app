package de.yessoft.android.entity;

import com.google.gson.annotations.SerializedName;

public class Skill {
    @SerializedName("skill")
    private String mSkill;

    public Skill() {
    }

    public Skill(String skill) {
        mSkill = skill;
    }

    public String getSkill() {
        return mSkill;
    }

    public void setSkill(String skill) {
        mSkill = skill;
    }
}
