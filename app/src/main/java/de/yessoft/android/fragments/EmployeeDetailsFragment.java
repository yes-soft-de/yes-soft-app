package de.yessoft.android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.ramotion.cardslider.CardSliderLayoutManager;
import com.ramotion.cardslider.CardSnapHelper;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.yessoft.android.R;
import de.yessoft.android.adapter.employees.EmployeeCardsAdapter;
import de.yessoft.android.entity.Employee;

public class EmployeeDetailsFragment extends Fragment {

    private CardSliderLayoutManager employeesLayoutManager;

    private int currentPosition;

    @BindView(R.id.rv_employee_cards)
    RecyclerView rvEmployeesCards;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee_list, container, false);
        ButterKnife.bind(this, view);

        initEmployeeList();

        return view;
    }

    private void initEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setImageLinks("http://placekitten.com/200/300");
        employees.add(employee);
        employees.add(employee);
        employees.add(employee);
        employees.add(employee);
        employees.add(employee);
        rvEmployeesCards.setAdapter(new EmployeeCardsAdapter(getContext(), employees));
        rvEmployeesCards.setLayoutManager(new CardSliderLayoutManager(getContext()));
        new CardSnapHelper().attachToRecyclerView(rvEmployeesCards);

        rvEmployeesCards.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    onActiveCardChange();
                }
            }
        });

        employeesLayoutManager = (CardSliderLayoutManager) rvEmployeesCards.getLayoutManager();
    }

    private void onActiveCardChange() {
        final int pos = employeesLayoutManager.getActiveCardPosition();
        if (pos == RecyclerView.NO_POSITION || pos == currentPosition) {
            return;
        }

        onActiveCardChange(pos);
    }

    private void onActiveCardChange(int pos) {
        int animH[] = new int[] {R.anim.slide_in_right, R.anim.slide_out_left};
        int animV[] = new int[] {R.anim.slide_in_top, R.anim.slide_out_bottom};

        final boolean left2right = pos < currentPosition;
        if (left2right) {
            animH[0] = R.anim.slide_in_left;
            animH[1] = R.anim.slide_out_right;

            animV[0] = R.anim.slide_in_bottom;
            animV[1] = R.anim.slide_out_top;
        }
    }
}
