package kr.hs.dimigo.meal.communication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.nio.file.Path;

public class Pojo {

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
            return "아침이 제공되지 않습니다.";
        } else {
            return breakfast;
        }
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        if(lunch.equals("")) {
            return "점심이 제공되지 않습니다.";
        } else {
            return lunch;
        }
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        if(dinner.equals("")) {
            return "저녁이 제공되지 않습니다.";
        } else {
            return dinner;
        }
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getSnack() {
        if(snack.equals("")) {
            return "간식이 제공되지 않습니다.";
        } else {
            return snack;
        }
    }

    public void setSnack(String snack) {
        this.snack = snack;
    }

}
