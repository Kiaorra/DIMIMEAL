package kr.hs.dimigo.meal.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.hs.dimigo.meal.FragmentsController;
import kr.hs.dimigo.meal.MealContents;
import kr.hs.dimigo.meal.R;

public class ListViewFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.listview_fragment, container, false);
    }

    // It controlling Fragments UI
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
