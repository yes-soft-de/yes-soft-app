package de.yessoft.android.entity;

import android.os.Bundle;

import com.google.gson.annotations.SerializedName;

public class PitchInfo {
    public PitchInfo(String text, String image, String bg) {
        this.text = text;
        this.imageLink = image;
        this.bg = bg;
    }

    public PitchInfo(String text, String image, String bg, String textColor) {
        this.text = text;
        this.imageLink = image;
        this.bg = bg;
        this.textColor = textColor;
    }

    @SerializedName("text")
    public String text;

    @SerializedName("link")
    public String imageLink;

    @SerializedName("bg")
    public String bg;

    @SerializedName("text_color")
    public String textColor;

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        bundle.putString("link", imageLink);
        bundle.putString("bg", bg);
        return bundle;
    }
}
