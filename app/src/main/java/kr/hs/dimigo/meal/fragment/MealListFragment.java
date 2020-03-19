package kr.hs.dimigo.meal.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import kr.hs.dimigo.meal.R;
import kr.hs.dimigo.meal.databinding.FragmentMealListBinding;
import kr.hs.dimigo.meal.databinding.ItemMealBinding;
import kr.hs.dimigo.meal.model.GetMealInfoResponse;
import kr.hs.dimigo.meal.utility.DimiMealUtils;
import kr.hs.dimigo.meal.viewmodel.MealListFragmentViewModel;

public class MealListFragment extends Fragment {

    private FragmentMealListBinding mBinding;

    private MealListFragmentViewModel mViewModel;

    private Context mContext;

    private int mDateType;

    private String mDate;

    private RecyclerViewAdapter mRecyclerViewAdapter;

    public MealListFragment(Context context, int dateType) {
        mContext = context;

        mDateType = dateType;
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

        mDate = DimiMealUtils.getDate(mDateType);

        setupRecyclerView();

        setupNetwork();
    }

    private void setupNetwork() {
        mViewModel.loadMealInfoData(mDate);
        mViewModel.getMealInfoData().observe(getViewLifecycleOwner(), new Observer<GetMealInfoResponse>() {
            @Override
            public void onChanged(GetMealInfoResponse getMealInfoResponse) {
                mRecyclerViewAdapter.setMealInfoResponse(getMealInfoResponse);
            }
        });
    }

    private void setupRecyclerView() {
        mBinding.recyclerViewFragMeals.setLayoutManager(new LinearLayoutManager(mContext));

        mBinding.recyclerViewFragMeals.setHasFixedSize(true);

        mRecyclerViewAdapter = new RecyclerViewAdapter(mDateType);

        mBinding.recyclerViewFragMeals.setAdapter(mRecyclerViewAdapter);
    }

    private static class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemMealViewHolder> {

        private int mDateType;

        private GetMealInfoResponse mealInfoResponse;

        public void setMealInfoResponse(GetMealInfoResponse getMealInfoResponse) {
            mealInfoResponse = getMealInfoResponse;
            notifyDataSetChanged();
        }

        public RecyclerViewAdapter(int dateType) {
            mDateType = dateType;
        }

        @NonNull
        @Override
        public ItemMealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ItemMealViewHolder(ItemMealBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ItemMealViewHolder holder, int position) {
            String content = null;

            if (mDateType == DimiMealUtils.DATE_TODAY && DimiMealUtils.getCurrentTime(position)) {
                holder.mItemMealBinding.textViewTitleItemMeal.setTextColor(Color.parseColor("#000000"));
                holder.mItemMealBinding.textViewContentItemMeal.setTextColor(Color.parseColor("#000000"));
                holder.mItemMealBinding.imageViewLampItemMeal.setImageResource(R.drawable.ic_lamp_on);
            } else {
                holder.mItemMealBinding.textViewTitleItemMeal.setTextColor(Color.parseColor("#929292"));
                holder.mItemMealBinding.textViewContentItemMeal.setTextColor(Color.parseColor("#929292"));
                holder.mItemMealBinding.imageViewLampItemMeal.setImageResource(R.drawable.ic_lamp_off);
            }

            try {
                switch (position) {
                    case 0:
                        holder.mItemMealBinding.textViewTitleItemMeal.setText(R.string.title_breakfast);
                        content = DimiMealUtils.isEmpty(mealInfoResponse.getBreakfast());
                        break;
                    case 1:
                        holder.mItemMealBinding.textViewTitleItemMeal.setText(R.string.title_lunch);
                        content = DimiMealUtils.isEmpty(mealInfoResponse.getLunch());
                        break;
                    case 2:
                        holder.mItemMealBinding.textViewTitleItemMeal.setText(R.string.title_dinner);
                        content = DimiMealUtils.isEmpty(mealInfoResponse.getDinner());
                        break;
                    case 3:
                        holder.mItemMealBinding.textViewTitleItemMeal.setText(R.string.title_snack);
                        content = DimiMealUtils.isEmpty(mealInfoResponse.getSnack());
                        break;
                    default:
                        break;
                }
            } catch (NullPointerException ex) {
                content = "급식정보가 없습니다.";
            } finally {
                holder.mItemMealBinding.textViewContentItemMeal.setText(content);
            }
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
