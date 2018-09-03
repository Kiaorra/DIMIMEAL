package kr.hs.dimigo.meal;

import android.widget.TextView;

import kr.hs.dimigo.meal.utils.DateGenerator;
import kr.hs.dimigo.meal.utils.InformationDistributor;
import kr.hs.dimigo.meal.utils.MealPojo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCommunicator {
    
    public static void communicateStart(int dateOrder, final TextView breakfast, final  TextView lunch, final TextView dinner, final TextView snack) {

        DateGenerator dateGenerator = new DateGenerator();

        String date = null;
        
        switch (dateOrder) {
            case 0:
                date = dateGenerator.getYesterday();
                break;
            case 1:
                date = dateGenerator.getToday();
                break;
            case 2:
                date = dateGenerator.getTomorrow();
                break;
            default:
                break;
        }

        InformationDistributor.API_END_INFO_TRANSMITTER.getMealInfo(date).enqueue(new Callback<MealPojo>() {
            @Override
            public void onResponse(Call<MealPojo> call, Response<MealPojo> response) {
                if(response.body() != null) {
                    breakfast.setText(response.body().getBreakfast());
                    lunch.setText(response.body().getLunch());
                    dinner.setText(response.body().getDinner());
                    snack.setText(response.body().getSnack());
                }
            }

            @Override
            public void onFailure(Call<MealPojo> call, Throwable t) {
            }
        });

    }
}
