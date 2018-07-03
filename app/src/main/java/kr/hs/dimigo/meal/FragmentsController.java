package kr.hs.dimigo.meal;

import kr.hs.dimigo.meal.communication.MealPojo;
import kr.hs.dimigo.meal.communication.ParseApi;
import kr.hs.dimigo.meal.fragments.ListViewFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentsController {

    DateGenerator dateGenerator = new DateGenerator();

    String todayBreakfastMenu;
    String todayLunchMenu;
    String todayDinnerMenu;
    String todaySnackMenu;

    public void startParsing() {
        todayMenuParsing();
    }

    private void todayMenuParsing() {

        final ListViewFragment listViewFragment = new ListViewFragment();

        ParseApi.apiService.getMealInfo(dateGenerator.getToday()).enqueue(new Callback<MealPojo>() {
            @Override
            public void onResponse(Call<MealPojo> call, Response<MealPojo> response) {
                    listViewFragment.setBreakfastContent(response.body().getBreakfast());
            }
            @Override
            public void onFailure(Call<MealPojo> call, Throwable t) {

            }
        });
    }
}
