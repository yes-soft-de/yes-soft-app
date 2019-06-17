package de.yessoft.android.mohammad.ui.FullNewsActivity.fragments.FullNewsCoordinatorFragment;

import de.yessoft.android.mohammad.model.FullNewsItem;

public interface FullNewsCoordinator {

    void errGettingFullNews(String errMsg);
    void setFullNews(FullNewsItem fullNewsItem);
}
