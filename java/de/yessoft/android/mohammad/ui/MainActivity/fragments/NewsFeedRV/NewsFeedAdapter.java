package de.yessoft.android.mohammad.ui.MainActivity.fragments.NewsFeedRV;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.yessoft.android.mohammad.R;
import de.yessoft.android.mohammad.model.NewsItem;

/*

    So, Gotta say something about this,
    I Used <RecyclerView.ViewHolder> for Future Proof Issues,
    If you have one ViewHolder just use it here OK?!!

 */

public class NewsFeedAdapter extends RecyclerView.Adapter<NewsCardVH>
        implements InteractiveInterface {
    private static final String TAG = "ML_NewsFeedRV";

    private List<NewsItem> NewsFeedList;

    public NewsFeedAdapter() {
        // for Toast Purposes
        // TODO: Structure This To Inform Center, Which shall Deliver Error in Good Manner :)

        NewsFeedList = new ArrayList<>();
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

        // holder.btnMore.setOnClickListener((v) -> Log.d(TAG, "onBindViewHolder: Error"));

        Picasso.get().load(newsItem.getImg()).into(holder.ivImg);
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
