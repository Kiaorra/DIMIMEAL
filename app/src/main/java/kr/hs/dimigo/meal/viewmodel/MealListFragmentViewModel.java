package kr.hs.dimigo.meal.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import kr.hs.dimigo.meal.model.GetMealInfoResponse;
import kr.hs.dimigo.meal.repository.GetMealInfoRepository;

public class MealListFragmentViewModel extends ViewModel {

    private GetMealInfoRepository mGetMealInfoRepository;

    private MutableLiveData<GetMealInfoResponse> mealInfoData;

    public LiveData<GetMealInfoResponse> getMealInfoData() {
        return mealInfoData;
    }

    public void loadMealInfoData(String date) {
        if (mGetMealInfoRepository == null)
            mGetMealInfoRepository = new GetMealInfoRepository();

        mealInfoData = mGetMealInfoRepository.getMutableMealInfoData(date);
    }
}