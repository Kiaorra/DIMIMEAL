package kr.hs.dimigo.meal.tomorrorw;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.hs.dimigo.meal.R;
import kr.hs.dimigo.meal.data.ApiCommunicator;
import kr.hs.dimigo.meal.data.DateCalculator;

public class TomorrowFragment extends Fragment {

    private RecyclerView recyclerView;

    private RecyclerView.LayoutManager layoutManager;


    public static TomorrowFragment newInstance() {
        return new TomorrowFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tomorrow_meals_frag, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView = getActivity().findViewById(R.id.tomorrow_recycler_view);

        layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setHasFixedSize(true);

        fetchMeals();
    }

    private void fetchMeals() {
        ApiCommunicator apiCommunicator = new ApiCommunicator(recyclerView, false, DateCalculator.getDate(2));
        apiCommunicator.setupData();
    }

}
