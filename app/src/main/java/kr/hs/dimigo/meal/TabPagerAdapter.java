package kr.hs.dimigo.meal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import kr.hs.dimigo.meal.today.TodayFragment;
import kr.hs.dimigo.meal.tomorrorw.TomorrowFragment;
import kr.hs.dimigo.meal.yesterday.YesterdayFragment;

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
                return YesterdayFragment.newInstance();
            case 1:
                return TodayFragment.newInstance();
            case 2:
                return TomorrowFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}