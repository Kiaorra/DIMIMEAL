package kr.hs.dimigo.meal.today;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kr.hs.dimigo.meal.data.ApiCommunicator;
import kr.hs.dimigo.meal.data.DateCalculator;
import kr.hs.dimigo.meal.R;

public class TodayFragment extends Fragment {

    private RecyclerView recyclerView;

    private RecyclerView.LayoutManager layoutManager;

    private TextView dateTitleView;

    public static TodayFragment newInstance() {
        return new TodayFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.today_meals_frag, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setupDateTitle();

        setupRecyclerView();

        // 교내 REST API와의 통신을 통해 급식 정보를 받은 후, 각각의 텍스트 뷰에 정보를 설정하는 메소드이다.
        fetchMeals();
    }

    private void setupDateTitle() {
        dateTitleView = getActivity().findViewById(R.id.todayDateTitle);
    }

    private void setupRecyclerView() {
        recyclerView = getActivity().findViewById(R.id.today_recycler_view);

        layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);
    }

    private void fetchMeals() {
        // 각각의 급식 정보를 리스트에 추가시키는 메소드이다.
        // TODO: 코드가 많이 더럽다고 느껴진다. 좀 더 깔끔하고 명확하게 짤 수 있는 방법을 생각해보자.
        ApiCommunicator apiCommunicator = new ApiCommunicator(recyclerView, true, DateCalculator.getDate(1));
        apiCommunicator.setupData();
    }
}
