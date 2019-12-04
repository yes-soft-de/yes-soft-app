package de.yessoft.android.adapter.employees;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import de.yessoft.android.R;

public class EmployeeCardsViewHolder extends RecyclerView.ViewHolder {

    AppCompatImageView ivEmployeeImage;

    public EmployeeCardsViewHolder(@NonNull View itemView) {
        super(itemView);

        ivEmployeeImage = itemView.findViewById(R.id.iv_i_employee_card);
    }
}
