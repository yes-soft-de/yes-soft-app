package de.yessoft.android.mohammad.fragments.ArticleFragment.ArticleAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.yessoft.android.mohammad.R;
import de.yessoft.android.mohammad.fragments.ArticleFragment.iArticleFragment;
import de.yessoft.android.mohammad.model.ArticleBlockItem;

public class ArticleAdapter
        extends RecyclerView.Adapter<ArticleBlockVH>
        implements iArticleAdapter {

    // This should Load Fully Before Showing, However since I implemented and
    // Observer before in this project I'll use it here

    private List<ArticleBlockItem> articleBlocks;
    private iArticleFragment Base;

    public ArticleAdapter(iArticleFragment baseFragment) {
        articleBlocks = new ArrayList<>();
        Base = baseFragment;
    }

    @NonNull
    @Override
    public ArticleBlockVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Here we put the Views and specify which Layout to use.
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_block, parent, false);
        return new ArticleBlockVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleBlockVH holder, int position) {

        // The Idea Here is to make the appropriate view visible,
        // in theory this should not affect performance very much,
        // the better option is to use optional ViewHolder, But
        // That REQUIRES TIME, which i don't have right now!!

        ArticleBlockItem item = articleBlocks.get(position);
        switch (item.getType()) {
            case TEXT:
                showText(holder, position);
                break;
            case IMAGE:
                showImage(holder, position);
                break;
            case HEADER:
                showHeader(holder, position);
                break;
            case URL:
                showButton(holder, position);
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return articleBlocks.size();
    }

    @Override
    public void addArticleBlock(ArticleBlockItem item) {
        articleBlocks.add(item);
        notifyDataSetChanged();
    }

    @Override
    public void setError(String errMsg) {
        // Empty the List first
        articleBlocks = new ArrayList<>();

        // This is used To Indicate Error, By The same Blocks ;)
        articleBlocks.add(new ArticleBlockItem(ArticleBlockItem.BlockType.HEADER, "Error!"));
        articleBlocks.add(new ArticleBlockItem(ArticleBlockItem.BlockType.TEXT, errMsg));

        notifyDataSetChanged();
    }

    // region Show Views
    private void showText(ArticleBlockVH holder, int position) {
        holder.tv.setVisibility(View.VISIBLE);
        holder.tv.setText(articleBlocks.get(position).getContent());
    }

    private void showHeader(ArticleBlockVH holder, int position) {
        holder.header.setVisibility(View.VISIBLE);
        holder.header.setText(articleBlocks.get(position).getContent());
    }

    private void showImage(ArticleBlockVH holder, int position) {
        holder.iv.setVisibility(View.VISIBLE);
        Picasso.get().load(articleBlocks.get(position).getContent()).into(holder.iv);
    }

    private void showButton(ArticleBlockVH holder, int position) {
        holder.btn.setVisibility(View.VISIBLE);
        holder.btn.setOnClickListener((v) -> {
            Base.requestWebRedirect(articleBlocks.get(position).getContent());
        });
    }
    // endregion
}
