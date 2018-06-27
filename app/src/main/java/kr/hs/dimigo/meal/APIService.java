package kr.hs.dimigo.meal;

import com.google.gson.JsonArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIService {

    final String BASE_URL = "https://api.dimigo.in";

    @GET("/dimibobs/{date}/")
    Call<JsonArray> getDate(@Path("date") String dates);

}
