package kr.hs.dimigo.meal.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kr.hs.dimigo.meal.R;
import kr.hs.dimigo.meal.communication.ConnectAPI;
import kr.hs.dimigo.meal.communication.Pojo;
import kr.hs.dimigo.meal.util.DateGenerator;
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

        // 시간에 따라 급식 정보글과 램프의 색상이 변경
        switch (dateGenerator.lampSelector()) {
            case 0 :
                // 아침시간
                breakfastLamp.setImageResource(R.drawable.ic_lamp_on);

                titleLunch.setTextColor(getResources().getColor(R.color.colorDisabled));
                titleDinner.setTextColor(getResources().getColor(R.color.colorDisabled));
                titleSnack.setTextColor(getResources().getColor(R.color.colorDisabled));

                todayLunchMenuContent.setTextColor(getResources().getColor(R.color.colorDisabled));
                todayDinnerMenuContent.setTextColor(getResources().getColor(R.color.colorDisabled));
                todaySnackMenuContent.setTextColor(getResources().getColor(R.color.colorDisabled));
                break;
            case 1:
                // 점심시간
                lunchLamp.setImageResource(R.drawable.ic_lamp_on);

                titleBreakfast.setTextColor(getResources().getColor(R.color.colorDisabled));
                titleDinner.setTextColor(getResources().getColor(R.color.colorDisabled));
                titleSnack.setTextColor(getResources().getColor(R.color.colorDisabled));

                todayBreakfastMenuContent.setTextColor(getResources().getColor(R.color.colorDisabled));
                todayDinnerMenuContent.setTextColor(getResources().getColor(R.color.colorDisabled));
                todaySnackMenuContent.setTextColor(getResources().getColor(R.color.colorDisabled));
                break;
            case 2:
                // 저녁시간
                dinnerLamp.setImageResource(R.drawable.ic_lamp_on);

                titleBreakfast.setTextColor(getResources().getColor(R.color.colorDisabled));
                titleLunch.setTextColor(getResources().getColor(R.color.colorDisabled));
                titleSnack.setTextColor(getResources().getColor(R.color.colorDisabled));

                todayBreakfastMenuContent.setTextColor(getResources().getColor(R.color.colorDisabled));
                todayLunchMenuContent.setTextColor(getResources().getColor(R.color.colorDisabled));
                todaySnackMenuContent.setTextColor(getResources().getColor(R.color.colorDisabled));
                break;
            case 3:
                // 간식시간
                snackLamp.setImageResource(R.drawable.ic_lamp_on);

                titleBreakfast.setTextColor(getResources().getColor(R.color.colorDisabled));
                titleLunch.setTextColor(getResources().getColor(R.color.colorDisabled));
                titleDinner.setTextColor(getResources().getColor(R.color.colorDisabled));

                todayBreakfastMenuContent.setTextColor(getResources().getColor(R.color.colorDisabled));
                todayLunchMenuContent.setTextColor(getResources().getColor(R.color.colorDisabled));
                todayDinnerMenuContent.setTextColor(getResources().getColor(R.color.colorDisabled));
                break;
            default:
                break;
        }

        // 디미고인 API 사용을 통한 급식 정보 할당
        // 추후 사용 데이터네트워크 절감을 위한 코드 최적화 예정
        ConnectAPI.apiService.getMealInfo(dateGenerator.getToday()).enqueue(new Callback<Pojo>() {
            @Override
            public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                if(response.body() != null) {
                    todayBreakfastMenuContent.setText(response.body().getBreakfast());
                    todayLunchMenuContent.setText(response.body().getLunch());
                    todayDinnerMenuContent.setText(response.body().getDinner());
                    todaySnackMenuContent.setText(response.body().getSnack());

                }
            }

            @Override
            public void onFailure(Call<Pojo> call, Throwable t) {

            }
        });
    }

}
