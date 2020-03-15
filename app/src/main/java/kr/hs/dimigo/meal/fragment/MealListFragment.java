package kr.hs.dimigo.meal.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import kr.hs.dimigo.meal.data.ApiCommunicator;
import kr.hs.dimigo.meal.data.DateCalculator;
import kr.hs.dimigo.meal.databinding.FragmentMealListBinding;

public class MealListFragment extends Fragment {

    private FragmentMealListBinding mBinding;

    private Context mContext;

    public MealListFragment(Context context) {
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FragmentMealListBinding.inflate(inflater, container, false);

        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        mBinding.recyclerViewFragMeals.setLayoutManager(new LinearLayoutManager(mContext));

        mBinding.recyclerViewFragMeals.setHasFixedSize(true);

//        mBinding.recyclerViewFragMeals.setAdapter();
    }
}
