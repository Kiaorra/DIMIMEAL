package kr.hs.dimigo.meal;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ParseApi {

    private static final String BASE_URL = "https://api.dimigo.in/";

    public static final ApiService apiService = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);
}
