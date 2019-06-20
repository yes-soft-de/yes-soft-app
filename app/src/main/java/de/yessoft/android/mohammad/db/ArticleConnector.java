package de.yessoft.android.mohammad.db;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

import de.yessoft.android.mohammad.consts.DB_KEYS;
import de.yessoft.android.mohammad.fragments.ArticleFragment.ArticleAdapter.iArticleAdapter;
import de.yessoft.android.mohammad.model.ArticleBlockItem;

public class ArticleConnector {
    // private static final String TAG = "ML_ArticleConnector";

    // region Data Sample
    /*
     This should handle the fallowing struct:
{
  "10": {
    "timestamp": 123456,
    "content": [{
      "type": "HEADER",
      "content": "My Great Header"
    },{
      "type": "IMAGE",
      "content": "https://<Site Here>/my_image.jpg"
    }, {
      "type": "TEXT",
      "content": "Some Body Text"
    }, {
      "type": "TEXT",
      "content": "Another Body Text"
    }, {
      "type": "IMAGE",
      "content": "https://<Site Here>/my_image.jpg"
    }, {
      "type": "TEXT",
      "content": "More Body Text"
    }, {
      "type": "URL",
      "content": "https://www.google.com"
    }]
  }
}

*/

    // endregion

    public void attachArticleBlocks(String id, iArticleAdapter targetAdapter) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        CollectionReference newsItems = db.collection(DB_KEYS.TABLE_FULL_ARTICLE).document(id).collection("content");

        newsItems.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                QuerySnapshot query = task.getResult();
                if (query != null && !query.isEmpty()) {

                    List<DocumentSnapshot> documentReferenceList = query.getDocuments();

                    for (DocumentSnapshot s : documentReferenceList) {
                        targetAdapter.addArticleBlock(new ArticleBlockItem(s));
                    }
                } else targetAdapter.setError("Null Query Result or Empty Table.");
            } else {
                if (task.getException() != null)
                    targetAdapter.setError(task.getException().getMessage());
                else targetAdapter.setError("Unknown Error!");
            }
        });
    }
}
