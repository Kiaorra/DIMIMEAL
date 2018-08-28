package kr.hs.dimigo.meal.communication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConnectAPI {

    private static final String BASE_URL = "https://api.dimigo.in";

    public static final Service apiService = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Service.class);
}
