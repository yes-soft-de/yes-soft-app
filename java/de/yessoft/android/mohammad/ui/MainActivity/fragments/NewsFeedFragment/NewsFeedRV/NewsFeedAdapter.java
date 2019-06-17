package de.yessoft.android.mohammad.ui.MainActivity.fragments.NewsFeedFragment.NewsFeedRV;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.stfalcon.imageviewer.StfalconImageViewer;

import java.util.ArrayList;
import java.util.List;

import de.yessoft.android.mohammad.R;
import de.yessoft.android.mohammad.model.NewsItem;
import de.yessoft.android.mohammad.ui.MainActivity.fragments.NewsFeedFragment.iNewsFeed;

/*

    So, Gotta say something about this,
    I Used <RecyclerView.ViewHolder> for Future Proof Issues,
    If you have one ViewHolder just use it here OK?!!

 */

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsCardVH>
        implements InteractiveInterface {
    private static final String TAG = "ML_NewsFeedRV";

    private List<NewsItem> NewsFeedList;
    private Context myContext;
    private iNewsFeed newsFeedInterface;

    public NewsFeedAdapter(Context context, iNewsFeed baseContainer) {
        // for Toast Purposes
        // TODO: Structure This To Inform Center, Which shall Deliver Error in Good Manner :)

        myContext = context;
        newsFeedInterface = baseContainer;
        NewsFeedList = new ArrayList<>();

        Toast.makeText(myContext, "Loading Images :)", Toast.LENGTH_SHORT).show();
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
        NewsItem newsItem = NewsFeedList.get(position);

        holder.tvSource.setText("Website");
        holder.tvHeader.setText(newsItem.getHeading());
        holder.tvSummery.setText(newsItem.getSummery());

        holder.btnMore.setOnClickListener((v) -> Toast.makeText(myContext, "Building That, Please Be Patient :)", Toast.LENGTH_SHORT).show());

        List<String> images = new ArrayList<>();
        images.add(NewsFeedList.get(position).getImg());


        Picasso.get().load(newsItem.getImg()).into(holder.ivImg);
        Log.d(TAG, "onBindViewHolder: " + newsItem.getImg());
        holder.ivImg.setOnClickListener(v -> new StfalconImageViewer.Builder<>(myContext, images, (imageView, image) -> Picasso.get().load(newsItem.getImg()).into(imageView)).show());
        holder.btnMore.setOnClickListener((v) -> {
            newsFeedInterface.requestFullNewsWithId(newsItem.getFullNewsId());
        });
    }

    @Override
    public int getItemCount() {

        return NewsFeedList.size();
    }

    @Override
    public void addNewsItem(NewsItem newsItem) {
        Log.d(TAG, "addNewsItem: Row Added");
        NewsFeedList.add(newsItem);
        notifyDataSetChanged();
    }
}
