package kr.hs.dimigo.meal.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.hs.dimigo.meal.utils.ApiCommunicator;
import kr.hs.dimigo.meal.R;
import kr.hs.dimigo.meal.utils.DateGenerator;

public class YesterdayMealViewFragment extends Fragment{
    SwipeRefreshLayout yesterdayRefreshLayout;

    TextView yesterdayDateTitle;

    TextView yesterdayBreakfastMenuContent, yesterdayLunchMenuContent, yesterdayDinnerMenuContent, yesterdaySnackMenuContent;

    DateGenerator dateGenerator = new DateGenerator();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.yesterday_meal_view_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        yesterdayRefreshLayout = getActivity().findViewById(R.id.yesterdayRefreshLayout);
        yesterdayRefreshLayout.setColorSchemeResources(R.color.colorAccent);

        yesterdayDateTitle = getActivity().findViewById(R.id.yesterdayDateTitle);
        yesterdayDateTitle.setText(dateGenerator.dateTitleProvider(dateGenerator.getYesterday()));

        yesterdayBreakfastMenuContent = getActivity().findViewById(R.id.yesterdayBreakfastMenuContent);
        yesterdayLunchMenuContent = getActivity().findViewById(R.id.yesterdayLunchMenuContent);
        yesterdayDinnerMenuContent = getActivity().findViewById(R.id.yesterdayDinnerMenuContent);
        yesterdaySnackMenuContent = getActivity().findViewById(R.id.yesterdaySnackMenuContent);

        ApiCommunicator apiCommunicator = new ApiCommunicator(1, yesterdayBreakfastMenuContent, yesterdayLunchMenuContent, yesterdayDinnerMenuContent, yesterdaySnackMenuContent, yesterdayRefreshLayout, getView(), getContext());
        apiCommunicator.initCommunicate();

        yesterdayRefreshLayout.setOnRefreshListener(()->{
            apiCommunicator.initCommunicate();
        });
    }
}
