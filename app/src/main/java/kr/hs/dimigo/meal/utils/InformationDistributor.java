package kr.hs.dimigo.meal.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InformationDistributor {

    private static final String BASE_URL = "https://api.dimigo.in";

    public static final EndInfoTransmitter API_END_INFO_TRANSMITTER = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EndInfoTransmitter.class);
}
