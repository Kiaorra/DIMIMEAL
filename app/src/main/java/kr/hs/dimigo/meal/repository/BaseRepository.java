package kr.hs.dimigo.meal.repository;

import kr.hs.dimigo.meal.utility.ApiService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseRepository {

    public ApiService apiService;

    public BaseRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiService.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }
}
