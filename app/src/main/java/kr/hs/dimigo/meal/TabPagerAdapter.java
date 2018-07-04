package kr.hs.dimigo.meal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import kr.hs.dimigo.meal.fragments.ListViewFragment;
import kr.hs.dimigo.meal.fragments.TomorrowFragment;
import kr.hs.dimigo.meal.fragments.YesterdayFragment;

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
                YesterdayFragment yesterdayFragment = new YesterdayFragment();
                return yesterdayFragment;
            case 1:
                ListViewFragment listViewFragment = new ListViewFragment();
                return  listViewFragment;
            case 2:
                TomorrowFragment tomorrowFragment = new TomorrowFragment();
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
