package de.yessoft.android.mohammad.model;

public class NewsItemContent {

    public enum Type {
        IMAGE,
        HEADING,
        BODY
    }

    private Type ContentType;
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Type getContentType() {
        return ContentType;
    }

    public void setContentType(Type contentType) {
        ContentType = contentType;
    }
}
