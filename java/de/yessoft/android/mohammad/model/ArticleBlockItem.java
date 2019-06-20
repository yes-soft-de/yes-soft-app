package de.yessoft.android.mohammad.model;

import com.google.firebase.firestore.DocumentSnapshot;

import static de.yessoft.android.mohammad.consts.DB_KEYS.KEY_ARTICLE_BLOCK_CONTENT;
import static de.yessoft.android.mohammad.consts.DB_KEYS.KEY_ARTICLE_BLOCK_TYPE;

public class ArticleBlockItem {

    // For Mapping Purposes
    private static final String TYPE_IMAGE = "image";
    private static final String TYPE_TEXT = "text";
    private static final String TYPE_HEADER = "header";
    private static final String TYPE_URL = "url";

    // Enums
    public enum BlockType {
        IMAGE,
        TEXT,
        HEADER,
        URL
    }

    // Variables
    private String Content;
    private BlockType Type;

    // Constructors
    public ArticleBlockItem(){}
    public ArticleBlockItem(DocumentSnapshot document){
        setType((String) document.get(KEY_ARTICLE_BLOCK_TYPE));
        setContent((String) document.get(KEY_ARTICLE_BLOCK_CONTENT));
    }
    public ArticleBlockItem(BlockType blockType, String content){
        Type = blockType;
        Content = content;
    }
    // region Get and Set
    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public BlockType getType() {
        return Type;
    }

    public void setType(BlockType type) {
        Type = type;
    }

    public void setType(String type) {
        switch (type) {
            case TYPE_HEADER:
                Type = BlockType.HEADER;
                break;
            case TYPE_TEXT:
                Type = BlockType.TEXT;
                break;
            case TYPE_IMAGE:
                Type = BlockType.IMAGE;
                break;
            case TYPE_URL:
                Type = BlockType.URL;
                break;
            default:
                Type = BlockType.TEXT;
                break;
        }
    }
    // endregion
}
