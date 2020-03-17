package kr.hs.dimigo.meal.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kr.hs.dimigo.meal.databinding.FragmentMealListBinding;
import kr.hs.dimigo.meal.databinding.ItemMealBinding;
import kr.hs.dimigo.meal.model.GetMealInfoResponse;
import kr.hs.dimigo.meal.viewmodel.MealListFragmentViewModel;

public class MealListFragment extends Fragment {

    private FragmentMealListBinding mBinding;

    private MealListFragmentViewModel mViewModel;

    private Context mContext;

    public MealListFragment(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new ViewModelProvider(requireActivity()).get(MealListFragmentViewModel.class);
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

        mViewModel.loadMealInfoData("20190413");
        mViewModel.getMealInfoData().observe(getViewLifecycleOwner(), new Observer<GetMealInfoResponse>() {
            @Override
            public void onChanged(GetMealInfoResponse getMealInfoResponse) {
            }
        });

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        mBinding.recyclerViewFragMeals.setLayoutManager(new LinearLayoutManager(mContext));

        mBinding.recyclerViewFragMeals.setHasFixedSize(true);

        mBinding.recyclerViewFragMeals.setAdapter(new RecyclerViewAdapter());
    }

    private static class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemMealViewHolder> {

        @NonNull
        @Override
        public ItemMealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ItemMealViewHolder(ItemMealBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ItemMealViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 4;
        }

        static class ItemMealViewHolder extends RecyclerView.ViewHolder {

            ItemMealBinding mItemMealBinding;

            public ItemMealViewHolder(@NonNull ItemMealBinding itemMealBinding) {
                super(itemMealBinding.getRoot());
                mItemMealBinding = itemMealBinding;
            }
        }
    }
}
