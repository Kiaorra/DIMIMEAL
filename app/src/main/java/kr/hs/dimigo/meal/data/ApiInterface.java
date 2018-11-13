package kr.hs.dimigo.meal.data;

import kr.hs.dimigo.meal.data.Meal;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("/dimibobs/{date}")
    Call<Meal> getMealContent(@Path("date") String dates);
}
