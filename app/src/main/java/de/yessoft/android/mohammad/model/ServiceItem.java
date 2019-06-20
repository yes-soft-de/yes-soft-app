package de.yessoft.android.mohammad.model;

import com.google.firebase.firestore.DocumentSnapshot;

import de.yessoft.android.mohammad.consts.DB_KEYS;

public class ServiceItem {
    private String Img;
    private String Header;
    private String Body;
    private String FullArticleId;

    public ServiceItem(){}
    public ServiceItem(DocumentSnapshot documentSnapshot){
        Img = (String) documentSnapshot.get(DB_KEYS.KEY_SERVICE_IMAGE);
        Header = (String) documentSnapshot.get(DB_KEYS.KEY_SERVICE_HEAD);
        Body = (String) documentSnapshot.get(DB_KEYS.KEY_SERVICE_BODY);
        FullArticleId = (String) documentSnapshot.get(DB_KEYS.KEY_SERVICE_URL);
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    public String getHeader() {
        return Header;
    }

    public void setHeader(String header) {
        Header = header;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String getFullArticleId() {
        return FullArticleId;
    }

    public void setFullArticleId(String fullArticleId) {
        FullArticleId = fullArticleId;
    }
}
