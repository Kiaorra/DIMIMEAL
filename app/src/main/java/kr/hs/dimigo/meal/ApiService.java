package kr.hs.dimigo.meal;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/dimibobs/{date}")
    Call<MealPojo> getMealInfo(@Path("date") String dates);
}
