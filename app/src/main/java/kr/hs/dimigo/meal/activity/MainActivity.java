package kr.hs.dimigo.meal.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.tabs.TabLayout;

import kr.hs.dimigo.meal.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(mBinding.getRoot());

        setupFunctions();
    }

    private void setupFunctions() {
        //
        setupToolbar();

        // 탭 레이아웃을 초기화 시키는 과정을 포함한 함수이다.
        setupTabLayout();

        // 뷰페이저와 탭을 초기화하고, 상호작용하도록 하는 함수이다.
//        setupViewPager();
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
        mBinding.viewPagerActMain.setOffscreenPageLimit(2);

//        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), mBinding.tabLayoutActMain.getTabCount());
//        mBinding.viewPagerActMain.setAdapter(tabPagerAdapter);

        mBinding.viewPagerActMain.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mBinding.tabLayoutActMain));

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
}