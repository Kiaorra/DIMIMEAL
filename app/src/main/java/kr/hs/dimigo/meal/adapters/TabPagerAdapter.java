package kr.hs.dimigo.meal.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import kr.hs.dimigo.meal.fragments.TodayMealViewFragment;
import kr.hs.dimigo.meal.fragments.TomorrowMealViewFragment;
import kr.hs.dimigo.meal.fragments.YesterdayMealViewFragment;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;


    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                YesterdayMealViewFragment yesterdayMealViewFragment = YesterdayMealViewFragment.getInstance();
                return yesterdayMealViewFragment;
            case 1:
                TodayMealViewFragment todayMealViewFragment = TodayMealViewFragment.getInstance();
                return  todayMealViewFragment;
            case 2:
                TomorrowMealViewFragment tomorrowMealViewFragment = new TomorrowMealViewFragment();
                return tomorrowMealViewFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
