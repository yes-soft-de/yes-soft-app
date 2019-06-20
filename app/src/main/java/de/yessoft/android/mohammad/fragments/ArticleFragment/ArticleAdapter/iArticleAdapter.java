package de.yessoft.android.mohammad.fragments.ArticleFragment.ArticleAdapter;

import de.yessoft.android.mohammad.model.ArticleBlockItem;

public interface iArticleAdapter {

    // Reactive, Sort of :|
    void addArticleBlock(ArticleBlockItem item);

    void setError(String str);
}
