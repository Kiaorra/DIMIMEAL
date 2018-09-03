package kr.hs.dimigo.meal.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import kr.hs.dimigo.meal.ApiCommunicator;
import kr.hs.dimigo.meal.R;
import kr.hs.dimigo.meal.utils.DateGenerator;
import kr.hs.dimigo.meal.utils.InformationDistributor;
import kr.hs.dimigo.meal.utils.MealPojo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodayMealViewFragment extends Fragment{

    TextView todayDateTitle;

    ImageView breakfastLamp;
    ImageView lunchLamp;
    ImageView dinnerLamp;
    ImageView snackLamp;

    TextView todayBreakfastMenuContent;
    TextView todayLunchMenuContent;
    TextView todayDinnerMenuContent;
    TextView todaySnackMenuContent;

    TextView titleBreakfast;
    TextView titleLunch;
    TextView titleDinner;
    TextView titleSnack;

    DateGenerator dateGenerator = new DateGenerator();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.today_meal_view_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //현재 날짜 표시
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

        // 시간에 따른 램프의 색상 변화
        timeChangeListener();

        // 디미고인 API 사용을 통한 급식 정보 할당
        ApiCommunicator.communicateStart(1, todayBreakfastMenuContent, todayLunchMenuContent, todayDinnerMenuContent, todaySnackMenuContent);
    }

    private void timeChangeListener() {
        // 시간에 따라 급식 정보글과 램프의 색상이 변경
        switch (dateGenerator.lampSelector()) {
            case 0 :
                // 아침시간
                breakfastLamp.setImageResource(R.drawable.ic_lamp_on);

                // Android API 23이상
                // titleBreakfast.setTextColor(ContextCompat.getColor(getContext(), R.color.colorBlack));

                // Android API 23미만
                titleBreakfast.setTextColor(getResources().getColor(R.color.colorBlack));
                todayBreakfastMenuContent.setTextColor(getResources().getColor(R.color.colorBlack));
                break;
            case 1:
                // 점심시간
                lunchLamp.setImageResource(R.drawable.ic_lamp_on);
                titleLunch.setTextColor(getResources().getColor(R.color.colorBlack));
                todayLunchMenuContent.setTextColor(getResources().getColor(R.color.colorBlack));
                break;
            case 2:
                // 저녁시간
                dinnerLamp.setImageResource(R.drawable.ic_lamp_on);

                titleDinner.setTextColor(getResources().getColor(R.color.colorBlack));
                todayDinnerMenuContent.setTextColor(getResources().getColor(R.color.colorBlack));
                break;
            case 3:
                // 간식시간
                snackLamp.setImageResource(R.drawable.ic_lamp_on);

                titleSnack.setTextColor(getResources().getColor(R.color.colorBlack));
                todaySnackMenuContent.setTextColor(getResources().getColor(R.color.colorBlack));
                break;
            default:
                break;
        }
    }
}
