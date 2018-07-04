package kr.hs.dimigo.meal;

import kr.hs.dimigo.meal.util.DateGenerator;

public class MenuParser {

    DateGenerator dateGenerator = new DateGenerator();

    public void startParsing() {
        todayMenuParsing();
    }

    public void todayMenuParsing() {

//        final MealContents mealContents = MealContents.getInstance();
//
//        ConnectAPI.apiService.getMealInfo(dateGenerator.getToday()).enqueue(new Callback<Pojo>() {
//            @Override
//            public void onResponse(Call<Pojo> call, Response<Pojo> response) {
//                mealContents.setBreakfastContent(response.body().getBreakfast());
//                Log.d("MenuParser", mealContents.getBreakfastContent());
//            }
//            @Override
//            public void onFailure(Call<Pojo> call, Throwable t) {
//
//            }
//        });
    }
}
