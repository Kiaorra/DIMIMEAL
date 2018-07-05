package kr.hs.dimigo.meal.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.hs.dimigo.meal.R;
import kr.hs.dimigo.meal.communication.ConnectAPI;
import kr.hs.dimigo.meal.communication.Pojo;
import kr.hs.dimigo.meal.util.DateGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodayMealViewFragment extends Fragment{

    TextView todayBreakfastMenuContent;
    TextView todayLunchMenuContent;
    TextView todayDinnerMenuContent;
    TextView todaySnackMenuContent;

    DateGenerator dateGenerator = new DateGenerator();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.today_meal_view_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        todayBreakfastMenuContent = getActivity().findViewById(R.id.todayBreakfastMenuContent);
        todayLunchMenuContent = getActivity().findViewById(R.id.todayLunchMenuContent);
        todayDinnerMenuContent = getActivity().findViewById(R.id.todayDinnerMenuContent);
        todaySnackMenuContent = getActivity().findViewById(R.id.todaySnackMenuContent);

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
