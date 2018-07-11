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

    TextView todayBreakfastMenuContent;
    TextView todayLunchMenuContent;
    TextView todayDinnerMenuContent;
    TextView todaySnackMenuContent;

    ImageView breakfastLamp;
    ImageView lunchLamp;
    ImageView dinnerLamp;
    ImageView snackLamp;

    DateGenerator dateGenerator = new DateGenerator();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.today_meal_view_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        todayDateTitle = getActivity().findViewById(R.id.todayDateTitle);
        todayDateTitle.setText(dateGenerator.dateTitleProvider(dateGenerator.getToday()));

        breakfastLamp = getActivity().findViewById(R.id.breakfastLamp);
        lunchLamp = getActivity().findViewById(R.id.lunchLamp);
        dinnerLamp = getActivity().findViewById(R.id.dinnerLamp);
        snackLamp = getActivity().findViewById(R.id.snackLamp);

        // 시간에 따라 램프에 색이 바뀌도록 함
        switch (dateGenerator.lampSelector()) {
            case 0 :
                breakfastLamp.setImageResource(R.drawable.ic_lamp_on);
                break;
            case 1:
                lunchLamp.setImageResource(R.drawable.ic_lamp_on);
                break;
            case 2:
                dinnerLamp.setImageResource(R.drawable.ic_lamp_on);
                break;
            case 3:
                snackLamp.setImageResource(R.drawable.ic_lamp_on);
                break;
            case 4:
                break;
                default:
                    break;
        }

        todayBreakfastMenuContent = getActivity().findViewById(R.id.todayBreakfastMenuContent);
        todayLunchMenuContent = getActivity().findViewById(R.id.todayLunchMenuContent);
        todayDinnerMenuContent = getActivity().findViewById(R.id.todayDinnerMenuContent);
        todaySnackMenuContent = getActivity().findViewById(R.id.todaySnackMenuContent);

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
