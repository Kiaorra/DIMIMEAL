package kr.hs.dimigo.meal.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meal {

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
            return breakfast;
        }
    }

    public String getLunch() {
        if(lunch.equals("")) {
            return "급식 정보가 없습니다.";
        } else {
            return lunch;
        }
    }

    public String getDinner() {
        if(dinner.equals("")) {
            return "급식 정보가 없습니다.";
        } else {
            return dinner;
        }
    }

    public String getSnack() {
        if(snack.equals("")) {
            return "급식 정보가 없습니다.";
        } else {
            return snack;
        }
    }
}
