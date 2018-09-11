package kr.hs.dimigo.meal.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kr.hs.dimigo.meal.utils.ApiCommunicator;
import kr.hs.dimigo.meal.R;
import kr.hs.dimigo.meal.utils.DateGenerator;

public class TodayMealViewFragment extends Fragment{

    private static TodayMealViewFragment todayMealViewFragment;

    public static TodayMealViewFragment getInstance() {
        if(todayMealViewFragment == null) {
            todayMealViewFragment = new TodayMealViewFragment();
            return todayMealViewFragment;
        } else {
            return todayMealViewFragment;
        }
    }

    static final String BLACK = "#000000";

    SwipeRefreshLayout todayRefreshLayout;
    TextView todayDateTitle;
    ImageView breakfastLamp, lunchLamp, dinnerLamp, snackLamp;
    TextView todayBreakfastMenuContent, todayLunchMenuContent, todayDinnerMenuContent, todaySnackMenuContent;
    TextView titleBreakfast, titleLunch, titleDinner, titleSnack;

    DateGenerator dateGenerator = new DateGenerator();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.today_meal_view_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //현재 날짜를 표시함
        todayDateTitle = getActivity().findViewById(R.id.todayDateTitle);
        todayDateTitle.setText(dateGenerator.dateTitleProvider(dateGenerator.getToday()));

        breakfastLamp = getActivity().findViewById(R.id.breakfastLamp);
        lunchLamp = getActivity().findViewById(R.id.lunchLamp);
        dinnerLamp = getActivity().findViewById(R.id.dinnerLamp);
        snackLamp = getActivity().findViewById(R.id.snackLamp);

        titleBreakfast = getActivity().findViewById(R.id.titleBreakfast);
        titleLunch = getActivity().findViewById(R.id.titleLunch);
        titleDinner = getActivity().findViewById(R.id.titleDinner);
        titleSnack = getActivity().findViewById(R.id.titleSnack);

        todayBreakfastMenuContent = getActivity().findViewById(R.id.todayBreakfastMenuContent);
        todayLunchMenuContent = getActivity().findViewById(R.id.todayLunchMenuContent);
        todayDinnerMenuContent = getActivity().findViewById(R.id.todayDinnerMenuContent);
        todaySnackMenuContent = getActivity().findViewById(R.id.todaySnackMenuContent);

        // 시간에 따라 급식 정보글과 램프의 색상을 변경함
        lampColorChanger();

        ApiCommunicator apiCommunicator = new ApiCommunicator(1, todayBreakfastMenuContent, todayLunchMenuContent, todayDinnerMenuContent, todaySnackMenuContent, getView(), getContext());
        apiCommunicator.initCommunicate();

    }

    private void lampColorChanger() {
        // 시간에 따라 급식 정보글과 램프의 색상을 변경함
        switch (dateGenerator.lampSelector()) {
            case 0 :
                // 아침시간
                breakfastLamp.setImageResource(R.drawable.ic_lamp_on);
                titleBreakfast.setTextColor(Color.parseColor(BLACK));
                todayBreakfastMenuContent.setTextColor(Color.parseColor(BLACK));
                break;
            case 1:
                // 점심시간
                lunchLamp.setImageResource(R.drawable.ic_lamp_on);
                titleLunch.setTextColor(Color.parseColor(BLACK));
                todayLunchMenuContent.setTextColor(Color.parseColor(BLACK));
                break;
            case 2:
                // 저녁시간
                dinnerLamp.setImageResource(R.drawable.ic_lamp_on);
                titleDinner.setTextColor(Color.parseColor(BLACK));
                todayDinnerMenuContent.setTextColor(Color.parseColor(BLACK));
                break;
            case 3:
                // 간식시간
                snackLamp.setImageResource(R.drawable.ic_lamp_on);
                titleSnack.setTextColor(Color.parseColor(BLACK));
                todaySnackMenuContent.setTextColor(Color.parseColor(BLACK));
                break;
            default:
                break;
        }
    }
}
