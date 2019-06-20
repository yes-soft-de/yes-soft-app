package de.yessoft.android.mohammad.fragments.NewsFeedFragment.NewsFeedRV;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.stfalcon.imageviewer.StfalconImageViewer;

import java.util.ArrayList;
import java.util.List;

import de.yessoft.android.mohammad.R;
import de.yessoft.android.mohammad.fragments.NewsFeedFragment.iNewsFeed;
import de.yessoft.android.mohammad.model.NewsItem;

/*

    So, Gotta say something about this,
    I Used <RecyclerView.ViewHolder> for Future Proof Issues,
    If you have one ViewHolder just use it here OK?!!

 */

public class NewsFeedAdapter
        extends RecyclerView.Adapter<NewsCardVH>
        implements iNewsItemInterface {
    private static final String TAG = "ML_NewsFeedRV";

    private List<NewsItem> NewsFeedList;
    private Context myContext;
    private iNewsFeed newsFeedInterface;

    public NewsFeedAdapter(Context context, iNewsFeed baseFragment) {
        newsFeedInterface = baseFragment;
        NewsFeedList = new ArrayList<>();
        myContext = context;
    }

    @NonNull
    @Override
    public NewsCardVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Here we put the Views and specify which Layout to use.
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_news_feed, parent, false);
        return new NewsCardVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsCardVH holder, int position) {

        // Get the Item, For accessibility purposes only
        NewsItem newsItem = NewsFeedList.get(position);

        // region Bind data to views
        holder.tvSource.setText("Website");
        holder.tvHeader.setText(newsItem.getHeading());
        holder.tvSummery.setText(newsItem.getSummery());
        Picasso.get().load(newsItem.getImg()).into(holder.ivImg);
        // endregion

        // region Load the Zoom Functionality
        List<String> images = new ArrayList<>();
        images.add(NewsFeedList.get(position).getImg());
        holder.ivImg.setOnClickListener(v -> new StfalconImageViewer.Builder<>(myContext, images, (imageView, image) -> Picasso.get().load(newsItem.getImg()).into(imageView)).show());
        // endregion


        // EVENT: Request with Button Press the Full News ID
        // INFO: I don't know why im piping throw the Fragment Here BUT I don't have time today :|
        holder.btnMore.setOnClickListener((v) -> newsFeedInterface.requestArticleWithId(newsItem.getFullNewsId()));
    }

    @Override
    public int getItemCount() {
        return NewsFeedList.size();
    }

    @Override
    public void addNewsItem(NewsItem newsItem) {
        NewsFeedList.add(newsItem);
        notifyDataSetChanged();
    }
}
