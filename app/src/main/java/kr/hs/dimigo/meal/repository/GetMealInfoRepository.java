package kr.hs.dimigo.meal.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import kr.hs.dimigo.meal.model.GetMealInfoResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetMealInfoRepository extends BaseRepository {

    private static final String TAG = "GetMealInfoRepository";

    private MutableLiveData<GetMealInfoResponse> mutableMealInfoData = new MutableLiveData<>();

    public MutableLiveData<GetMealInfoResponse> getMutableMealInfoData(String date) {
        apiService.getMealContent(date).enqueue(new Callback<GetMealInfoResponse>() {
            @Override
            public void onResponse(Call<GetMealInfoResponse> call, Response<GetMealInfoResponse> response) {
                Log.d(TAG, "HTTP status: " + response.code());
                mutableMealInfoData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<GetMealInfoResponse> call, Throwable t) {
                Log.e(TAG, "onFailure" + t.getMessage());
            }
        });

        return mutableMealInfoData;
    }
}