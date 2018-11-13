package kr.hs.dimigo.meal.oldversion;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MealPojo {

    @SerializedName("breakfast")
    @Expose
    private String breakfast;

    @SerializedName("lunch")
    @Expose
    private String lunch;

    @SerializedName("dinner")
    @Expose
    private String dinner;

    @SerializedName("snack")
    @Expose
    private String snack;

    public String getBreakfast() {
        if(breakfast.equals("")) {
            return "급식 정보가 없습니다.";
        } else {
            Log.d("MealPojo - Breakfast", breakfast);
            return breakfast;
        }
    }

    public String getLunch() {
        if(lunch.equals("")) {
            return "급식 정보가 없습니다.";
        } else {
            Log.d("MealPojo - Lunch", lunch);
            return lunch;
        }
    }

    public String getDinner() {
        if(dinner.equals("")) {
            return "급식 정보가 없습니다.";
        } else {
            Log.d("MealPojo - Dinner", dinner);
            return dinner;
        }
    }

    public String getSnack() {
        if(snack.equals("")) {
            return "급식 정보가 없습니다.";
        } else {
            Log.d("MealPojo - Snack", snack);
            return snack;
        }
    }

}
