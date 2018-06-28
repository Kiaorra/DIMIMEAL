package kr.hs.dimigo.meal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.hs.dimigo.meal.DateCal;
import kr.hs.dimigo.meal.parsing.MealPojo;
import kr.hs.dimigo.meal.parsing.ParseApi;
import kr.hs.dimigo.meal.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListViewFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        DateCal dateCal = new DateCal();

        ParseApi.apiService.getMealInfo(dateCal.getToday()).enqueue(new Callback<MealPojo>() {
            @Override
            public void onResponse(Call<MealPojo> call, Response<MealPojo> response) {
                if(response.body() != null) {

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
}
