package kr.hs.dimigo.meal.utility;

import kr.hs.dimigo.meal.model.GetMealInfoResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    String API_URL = "https://dev-api.dimigo.in";

    @GET("/dimibobs/{date}")
    Call<GetMealInfoResponse> getMealContent(@Path("date") String dates);
}