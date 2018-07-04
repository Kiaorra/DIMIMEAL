package kr.hs.dimigo.meal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import kr.hs.dimigo.meal.fragment.TodayMealViewFragment;
import kr.hs.dimigo.meal.fragment.TomorrowMealViewFragment;
import kr.hs.dimigo.meal.fragment.YesterdayMealViewFragment;

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
                YesterdayMealViewFragment yesterdayFragment = new YesterdayMealViewFragment();
                return yesterdayFragment;
            case 1:
                TodayMealViewFragment listViewFragment = new TodayMealViewFragment();
                return  listViewFragment;
            case 2:
                TomorrowMealViewFragment tomorrowFragment = new TomorrowMealViewFragment();
                return tomorrowFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
