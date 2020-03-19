package kr.hs.dimigo.meal.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.google.android.material.tabs.TabLayout;

import kr.hs.dimigo.meal.databinding.ActivityMainBinding;
import kr.hs.dimigo.meal.fragment.MealListFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    private Fragment[] mFragments = new Fragment[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(mBinding.getRoot());

        setupFunctions();
    }

    private void setupFunctions() {
        setupToolbar();

        // 탭 레이아웃을 초기화 시키는 과정을 포함한 함수이다.
        setupTabLayout();

        // 뷰페이저와 탭을 초기화하고, 상호작용하도록 하는 함수이다.
        setupViewPager();
    }

    private void setupToolbar() {
        setSupportActionBar(mBinding.toolbarActMain);
    }

    private void setupTabLayout() {
        mBinding.tabLayoutActMain.addTab(mBinding.tabLayoutActMain.newTab().setText("어제"));
        mBinding.tabLayoutActMain.addTab(mBinding.tabLayoutActMain.newTab().setText("오늘"));
        mBinding.tabLayoutActMain.addTab(mBinding.tabLayoutActMain.newTab().setText("내일"));
    }

    private void setupViewPager() {

        for (int i = 0; i < 3; i++) {
            mFragments[i] = new MealListFragment(this, i);
        }

        mBinding.viewPagerActMain.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, mFragments));

        mBinding.viewPagerActMain.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mBinding.tabLayoutActMain));

        mBinding.viewPagerActMain.setOffscreenPageLimit(2);

        mBinding.viewPagerActMain.setCurrentItem(1);

        // 뷰페이저와 탭이 상호작용 하도록 하는 리스너이다. 특정 탭을 클릭 하였을 시에 같은 포지션에 위치한 뷰를 불러오게 된다.
        mBinding.tabLayoutActMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mBinding.viewPagerActMain.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    static class ViewPagerAdapter extends FragmentPagerAdapter {

        private Fragment[] fragments;

        private ViewPagerAdapter(@NonNull FragmentManager fm, int behavior, Fragment[] fragments) {
            super(fm, behavior);

            this.fragments = fragments;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }
    }
}