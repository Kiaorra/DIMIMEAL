package kr.hs.dimigo.meal;

import android.util.Log;

import kr.hs.dimigo.meal.communication.MealPojo;
import kr.hs.dimigo.meal.communication.ParseApi;
import kr.hs.dimigo.meal.util.DateGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuParser {

    DateGenerator dateGenerator = new DateGenerator();

    public void startParsing() {
        todayMenuParsing();
    }

    public void todayMenuParsing() {

//        final MealContents mealContents = MealContents.getInstance();
//
//        ParseApi.apiService.getMealInfo(dateGenerator.getToday()).enqueue(new Callback<MealPojo>() {
//            @Override
//            public void onResponse(Call<MealPojo> call, Response<MealPojo> response) {
//                mealContents.setBreakfastContent(response.body().getBreakfast());
//                Log.d("MenuParser", mealContents.getBreakfastContent());
//            }
//            @Override
//            public void onFailure(Call<MealPojo> call, Throwable t) {
//
//            }
//        });
    }
}
