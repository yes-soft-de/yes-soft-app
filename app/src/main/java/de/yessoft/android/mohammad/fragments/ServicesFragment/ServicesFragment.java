package de.yessoft.android.mohammad.fragments.ServicesFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import de.yessoft.android.mohammad.R;
import de.yessoft.android.mohammad.consts.BUNDLE_KEYS;
import de.yessoft.android.mohammad.db.ServiceConnector;
import de.yessoft.android.mohammad.fragments.ServicesFragment.ServicesAdapter.ServicesAdapter;
import de.yessoft.android.mohammad.ui.ArticleActivity.ArticleActivity;

public class ServicesFragment extends Fragment implements iServiceFragment{
    private static final String TAG = "ML_ServicesFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_services, container, false);

        RecyclerView rv = v.findViewById(R.id.rv_services);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));


        ServicesAdapter adapter = new ServicesAdapter(this);
        rv.setAdapter(adapter);

        ServiceConnector connector = new ServiceConnector();
        connector.attachObserverToServiceList(adapter);

        return v;
    }

    @Override
    public void requestArticleById(String id) {
        Intent intent = new Intent(getActivity(), ArticleActivity.class);
        intent.putExtra(BUNDLE_KEYS.KEY_ARTICLE_ID, id);
        startActivity(intent);
    }
}
