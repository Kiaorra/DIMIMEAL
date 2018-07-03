package kr.hs.dimigo.meal;

public class MealContents {

    String breakfastContent = "The variable which named breakfast Content is empty";

    private static final MealContents ourInstance = new MealContents();

    public static MealContents getInstance() {
        return ourInstance;
    }

    private MealContents() {
    }

    public String getBreakfastContent() {
        return breakfastContent;
    }

    public void setBreakfastContent(String breakfastContent) {
        this.breakfastContent = breakfastContent;
    }
}
