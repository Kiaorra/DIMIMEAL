package kr.hs.dimigo.meal.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import kr.hs.dimigo.meal.model.GetMealInfoResponse;
import kr.hs.dimigo.meal.repository.GetMealInfoRepository;

public class MealListFragmentViewModel extends ViewModel {

    private GetMealInfoRepository mGetMealInfoRepository;

    private MutableLiveData<GetMealInfoResponse> mutableMealInfoData;

    public void loadMealInfoData(String date) {
        if (mGetMealInfoRepository == null)
            mGetMealInfoRepository = new GetMealInfoRepository();

        mutableMealInfoData = mGetMealInfoRepository.getMutableMealInfoData(date);
    }
}