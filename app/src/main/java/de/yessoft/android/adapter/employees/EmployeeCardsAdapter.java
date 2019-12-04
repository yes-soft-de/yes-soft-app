package de.yessoft.android.adapter.employees;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import de.yessoft.android.R;
import de.yessoft.android.entity.EmployeeDetails;
import de.yessoft.android.entity.EmployeeInfo;

public class EmployeeCardsAdapter extends RecyclerView.Adapter<EmployeeCardsViewHolder> {

    private Context mContext;

    private List<EmployeeDetails> mEmployeeList;

    public EmployeeCardsAdapter(Context context, List<EmployeeDetails> employeeList) {
        mContext = context;
        mEmployeeList = employeeList;
    }

    public EmployeeCardsAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public EmployeeCardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_employee_card, parent, false);

        return new EmployeeCardsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeCardsViewHolder holder, int position) {
        Glide.with(mContext)
                .load(mEmployeeList.get(position).getInfo().getImageLink())
                .centerCrop()
                .placeholder(R.drawable.gradient_map)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(holder.ivEmployeeImage);
    }

    @Override
    public int getItemCount() {
        if (mEmployeeList == null) {
            return 0;
        }
        return mEmployeeList.size();
    }

    public void setEmployeeList(List<EmployeeDetails> employeeList) {
        this.mEmployeeList = employeeList;
    }
}
