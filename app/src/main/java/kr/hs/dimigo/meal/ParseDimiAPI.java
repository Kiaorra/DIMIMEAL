package kr.hs.dimigo.meal;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ParseDimiAPI {

    String breakfast;
    String lunch;
    String dinner;
    String snack;

    public String getBreakfast() {
        return breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public String getSnack() {
        return snack;
    }

    public void parse() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dimigo.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<JsonArray> request = service.getDate("20180627");
        request.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {

            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });
    }
}
