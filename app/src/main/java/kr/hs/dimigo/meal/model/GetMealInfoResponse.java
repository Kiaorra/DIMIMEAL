package kr.hs.dimigo.meal.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetMealInfoResponse {

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
        return breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public String getSnack() {
        return snack;
    }
}