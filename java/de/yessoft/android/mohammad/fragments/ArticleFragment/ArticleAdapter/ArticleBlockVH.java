package de.yessoft.android.mohammad.fragments.ArticleFragment.ArticleAdapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import de.yessoft.android.mohammad.R;

class ArticleBlockVH extends RecyclerView.ViewHolder {

    TextView tv;
    AppCompatImageView iv;
    TextView header;
    Button btn;

    ArticleBlockVH(@NonNull View itemView) {
        super(itemView);

        tv = itemView.findViewById(R.id.tv_block_text);
        iv = itemView.findViewById(R.id.tv_block_image);
        header = itemView.findViewById(R.id.tv_block_header);
        btn = itemView.findViewById(R.id.btn_block_link);
    }
}
