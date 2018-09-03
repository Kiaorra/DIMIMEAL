package kr.hs.dimigo.meal.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.hs.dimigo.meal.ApiCommunicator;
import kr.hs.dimigo.meal.R;
import kr.hs.dimigo.meal.utils.DateGenerator;

public class TomorrowMealViewFragment extends Fragment {

    TextView tomorrowDateTitle;

    TextView tomorrowBreakfastMenuContent;
    TextView tomorrowLunchMenuContent;
    TextView tomorrowDinnerMenuContent;
    TextView tomorrowSnackMenuContent;

    DateGenerator dateGenerator = new DateGenerator();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tomorrow_meal_view_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tomorrowDateTitle = getActivity().findViewById(R.id.tomorrowDateTitle);
        tomorrowDateTitle.setText(dateGenerator.dateTitleProvider(dateGenerator.getTomorrow()));

        tomorrowBreakfastMenuContent = getActivity().findViewById(R.id.tomorrowBreakfastMenuContent);
        tomorrowLunchMenuContent = getActivity().findViewById(R.id.tomorrowLunchMenuContent);
        tomorrowDinnerMenuContent = getActivity().findViewById(R.id.tomorrowDinnerMenuContent);
        tomorrowSnackMenuContent = getActivity().findViewById(R.id.tomorrowSnackMenuContent);

        ApiCommunicator.communicateStart(2, tomorrowBreakfastMenuContent, tomorrowLunchMenuContent, tomorrowDinnerMenuContent, tomorrowSnackMenuContent);
    }
}