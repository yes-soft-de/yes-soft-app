package com.sixbits.yessoft.model;

import java.util.List;

public class NewsItem {
    private String Heading;
    private String Img;
    private List<NewsItemContent> NewsContent;

    public String getHeading() {
        return Heading;
    }

    public void setHeading(String heading) {
        Heading = heading;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    public List<NewsItemContent> getNewsContent() {
        return NewsContent;
    }

    public void setNewsContent(List<NewsItemContent> newsContent) {
        NewsContent = newsContent;
    }
}
