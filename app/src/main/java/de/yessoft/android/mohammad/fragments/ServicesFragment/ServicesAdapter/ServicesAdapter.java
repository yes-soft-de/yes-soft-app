package de.yessoft.android.mohammad.fragments.ServicesFragment.ServicesAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.yessoft.android.mohammad.R;
import de.yessoft.android.mohammad.fragments.ServicesFragment.iServiceFragment;
import de.yessoft.android.mohammad.model.ServiceItem;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesVH>
        implements iServiceAdapter {

    private List<ServiceItem> ServiceItemList;
    private iServiceFragment Base;

    public ServicesAdapter(iServiceFragment baseFragment) {
        ServiceItemList = new ArrayList<>();
        Base = baseFragment;
    }

    @NonNull
    @Override
    public ServicesVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Here we put the Views and specify which Layout to use.
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_service, parent, false);
        return new ServicesVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicesVH holder, int position) {
        ServiceItem item = ServiceItemList.get(position);

        holder.tvServiceName.setText(item.getHeader());
        holder.tvServiceSummery.setText(item.getBody());
        Picasso.get().load(item.getImg()).into(holder.ivServiceImage);
        holder.btnMore.setOnClickListener((v) -> {
            Base.requestArticleById(item.getFullArticleId());
        });

    }

    @Override
    public int getItemCount() {
        return ServiceItemList.size();
    }

    @Override
    public void addService(ServiceItem serviceItem) {
        ServiceItemList.add(serviceItem);
        notifyDataSetChanged();
    }
}
