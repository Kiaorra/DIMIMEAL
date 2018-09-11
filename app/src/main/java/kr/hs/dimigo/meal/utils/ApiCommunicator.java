package kr.hs.dimigo.meal.utils;


import android.content.Context;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import kr.hs.dimigo.meal.adapters.TabPagerAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCommunicator {

    private int dateOrder;

    private TextView breakfast, lunch, dinner, snack;
    private View view;
    private Context context;

    public ApiCommunicator(int dateOrder, TextView breakfast, TextView lunch, TextView dinner, TextView snack, View view) {
        this.dateOrder = dateOrder;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.snack = snack;
        this.view = view;
    }

    public ApiCommunicator(int dateOrder, TextView breakfast, TextView lunch, TextView dinner, TextView snack, View view, Context context) {
        this.dateOrder = dateOrder;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.snack = snack;
        this.view = view;
        this.context = context;
    }

    public void initCommunicate() {
        DateGenerator dateGenerator = new DateGenerator();
        String date = null;

        switch (dateOrder) {
            case 0:
                date = dateGenerator.getYesterday();
                break;
            case 1:
                date = dateGenerator.getToday();
                break;
            case 2:
                date = dateGenerator.getTomorrow();
                break;
            default:
                break;
        }

        InformationDistributor.API_END_INFO_TRANSMITTER.getMealInfo(date).enqueue(new Callback<MealPojo>() {
            @Override
            public void onResponse(Call<MealPojo> call, Response<MealPojo> response) {
                if(response.body() != null) {
                    breakfast.setText(response.body().getBreakfast());
                    lunch.setText(response.body().getLunch());
                    dinner.setText(response.body().getDinner());
                    snack.setText(response.body().getSnack());
                } else if(response.body() == null) {
                    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                        Snackbar.make(view, "급식정보가 존재하지 않습니다", Snackbar.LENGTH_LONG).setAction("새로고침", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                initCommunicate();
                            }
                        }).show();
                    } else {
                        Toast.makeText(context, "급식정보가 존재하지 않습니다.", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MealPojo> call, Throwable t) {
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                    Snackbar.make(view, "네트워크 통신이 원활하지 않습니다.", Snackbar.LENGTH_LONG).setAction("새로고침", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            initCommunicate();
                        }
                    }).show();
                } else {
                    Toast.makeText(context, "네트워크 통신이 원활하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
