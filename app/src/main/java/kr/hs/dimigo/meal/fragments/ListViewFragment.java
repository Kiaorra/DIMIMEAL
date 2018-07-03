package kr.hs.dimigo.meal.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.hs.dimigo.meal.FragmentsController;
import kr.hs.dimigo.meal.R;

public class ListViewFragment extends Fragment{

    String breakfastContent;
    String lunchContent;
    String dinnerContent;
    String snackContent;

    TextView breakfastMenu;

    public String getBreakfastContent() {
        return breakfastContent;
    }

    public void setBreakfastContent(String breakfastContent) {
        this.breakfastContent = breakfastContent;
    }

    public String getLunchContent() {
        return lunchContent;
    }

    public void setLunchContent(String lunchContent) {
        this.lunchContent = lunchContent;
    }

    public String getDinnerContent() {
        return dinnerContent;
    }

    public void setDinnerContent(String dinnerContent) {
        this.dinnerContent = dinnerContent;
    }

    public String getSnackContent() {
        return snackContent;
    }

    public void setSnackContent(String snackContent) {
        this.snackContent = snackContent;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.listview_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FragmentsController fragmentsController = new FragmentsController();
        fragmentsController.startParsing();

        breakfastMenu = getActivity().findViewById(R.id.breakfastMenu);
    }

    @Override
    public void onStart() {
        super.onStart();
        breakfastMenu.setText(getBreakfastContent());
    }
}
