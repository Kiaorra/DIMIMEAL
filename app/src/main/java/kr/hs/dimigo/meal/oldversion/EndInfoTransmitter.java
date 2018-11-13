package kr.hs.dimigo.meal.oldversion;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EndInfoTransmitter {

    @GET("/dimibobs/{date}")
    Call<MealPojo> getMealInfo(@Path("date") String dates);
}
