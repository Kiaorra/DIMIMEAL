package kr.hs.dimigo.meal.data;

import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kr.hs.dimigo.meal.MealListAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCommunicator {

    private List<String> meals = new ArrayList<>();
    private MealListAdapter adapter;
    private ApiInterface mApiInterface;
    private RecyclerView recyclerView;
    private boolean isToday;
    private String date;

    public ApiCommunicator(RecyclerView recyclerView, boolean isToday, String date) {
        this.recyclerView = recyclerView;
        this.isToday = isToday;
        this.date = date;
    }

    public void setupData() {
        mApiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<Meal> call = mApiInterface.getMealContent(date);
        call.enqueue(new Callback<Meal>() {
            @Override
            public void onResponse(Call<Meal> call, Response<Meal> response) {

                Log.d("ApiCommunication", "HTTP CODE: " + response.code());

                if (response.isSuccessful()) {

                    listAdd(response);

                    adapter = new MealListAdapter(meals, isToday);

                    recyclerView.setAdapter(adapter);

                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Meal> call, Throwable t) {
                // TODO: 통신에 실패하였을 때를 고려하는 코드를 추후에 추가시키자.
            }
        });
    }

    private void listAdd(Response<Meal> response) {
        meals.add(response.body().getBreakfast());
        meals.add(response.body().getLunch());
        meals.add(response.body().getDinner());
        meals.add(response.body().getSnack());
    }
}
