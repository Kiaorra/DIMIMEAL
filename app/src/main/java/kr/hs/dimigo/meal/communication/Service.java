package kr.hs.dimigo.meal.communication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {

    @GET("/dimibobs/{date}")
    Call<Pojo> getMealInfo(@Path("date") String dates);
}
