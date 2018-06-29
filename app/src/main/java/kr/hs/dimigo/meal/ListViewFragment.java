package kr.hs.dimigo.meal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.hs.dimigo.meal.parsing.MealPojo;
import kr.hs.dimigo.meal.parsing.ParseApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListViewFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    TextView dayTime;
    TextView mealContent;
    TextView lunchContent;
    TextView dinnerContent;
    TextView snackContent;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        dayTime = getActivity().findViewById(R.id.dayTime);
        mealContent = getActivity().findViewById(R.id.mealContent);
        lunchContent = getActivity().findViewById(R.id.lunchContent);
        dinnerContent = getActivity().findViewById(R.id.dinnerContent);
        snackContent = getActivity().findViewById(R.id.snackContent);

        final CalDate calDate = new CalDate();
        final NumberToWord ntw = new NumberToWord();

        ParseApi.apiService.getMealInfo(calDate.getToday()).enqueue(new Callback<MealPojo>() {
            @Override
            public void onResponse(Call<MealPojo> call, Response<MealPojo> response) {
                if(response.body() != null) {
                    dayTime.setText(ntw.startChange(calDate.getToday()));

                    mealContent.setText(response.body().getBreakfast());
                    lunchContent.setText(response.body().getLunch());
                    dinnerContent.setText(response.body().getDinner());
                    snackContent.setText(response.body().getSnack());
                }
            }

            @Override
            public void onFailure(Call<MealPojo> call, Throwable t) {

            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.listview_fragment, container, false);
    }

    @Override
    public void onRefresh() {

    }
}
