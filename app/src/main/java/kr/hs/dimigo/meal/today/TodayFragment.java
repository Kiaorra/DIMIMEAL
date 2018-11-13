package kr.hs.dimigo.meal.today;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kr.hs.dimigo.meal.MealListAdapter;
import kr.hs.dimigo.meal.data.ApiClient;
import kr.hs.dimigo.meal.data.ApiInterface;
import kr.hs.dimigo.meal.data.DateCalculator;
import kr.hs.dimigo.meal.data.Meal;
import kr.hs.dimigo.meal.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodayFragment extends Fragment {

    private List<String> listMeals = new ArrayList<>();

    private RecyclerView recyclerView;

    private RecyclerView.LayoutManager layoutManager;

    private ApiInterface mApiInterface;

    private MealListAdapter mMealListAdapter;

    public static TodayFragment newInstance() {
        return new TodayFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.today_frag, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = getActivity().findViewById(R.id.today_recycler_view);

        layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

        // 교내 REST API와의 통신을 통해 급식 정보를 받은 후, 각각의 텍스트 뷰에 정보를 설정하는 메소드이다.
        fetchMeals();
    }

    // TODO: 통신을 프래그먼트 내부에서 하는 것이 옳은 방법인지 고민해보자.
    public void fetchMeals() {
        mApiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<Meal> call = mApiInterface.getMealContent(DateCalculator.getDate(1));
        call.enqueue(new Callback<Meal>() {
            @Override
            public void onResponse(Call<Meal> call, Response<Meal> response) {
                addList(response);

                mMealListAdapter = new MealListAdapter(listMeals, true);

                recyclerView.setAdapter(mMealListAdapter);

                mMealListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Meal> call, Throwable t) {
                if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                    Snackbar.make(getView(), "네트워크 통신이 원활하지 않습니다.", Snackbar.LENGTH_INDEFINITE)
                            .setAction("새로고침", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    fetchMeals();
                                }
                            }).show();
                } else {
                    Toast.makeText(getContext(), "네트워크 통신이 원활하지 않습니다.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // 각각의 급식 정보를 리스트에 추가시키는 메소드이다.
    private void addList(Response<Meal> response) {
        listMeals.add(response.body().getBreakfast());
        listMeals.add(response.body().getLunch());
        listMeals.add(response.body().getDinner());
        listMeals.add(response.body().getSnack());
    }


}
