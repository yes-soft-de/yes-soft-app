package de.yessoft.android.mohammad.ui.FullNewsActivity.fragments.ErrorFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import de.yessoft.android.mohammad.R;
import de.yessoft.android.mohammad.consts.BUNDLE_KEYS;

public class ErrorFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_full_news_error, container, false);

        TextView tv = v.findViewById(R.id.tv_full_news_error);

        if (getArguments() != null)
            tv.setText(getArguments().getString(BUNDLE_KEYS.KEY_ERR_MSG, "Unknown Error!"));
        else {
            assert getContext() != null : "Null Context!!!";
            tv.setText(getContext().getString(R.string.unknown_error_msg));
        }
        return v;
    }
}
