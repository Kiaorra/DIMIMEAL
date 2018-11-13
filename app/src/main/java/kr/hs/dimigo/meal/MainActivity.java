package kr.hs.dimigo.meal;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity{

    private TabLayout mTabLayout;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 탭 레이아웃을 초기화 시키는 과정을 포함한 메소드이다.
        setupTabLayout();

        // 뷰페이저와 탭을 초기화하고, 상호작용하도록 하는 메소드이다.
        setupViewPager();
    }

    private void setupTabLayout() {
        mTabLayout = findViewById(R.id.tabLayout);

        // TODO: 같은 일을 반복 시키는 코드이다. 다른 효율적인 코딩 방법을 찾아보자.
        mTabLayout.addTab(mTabLayout.newTab().setText("어제"));
        mTabLayout.addTab(mTabLayout.newTab().setText("오늘"));
        mTabLayout.addTab(mTabLayout.newTab().setText("내일"));

        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    private void setupViewPager() {
        mViewPager = findViewById(R.id.pager);

        mViewPager.setOffscreenPageLimit(2);

        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());

        mViewPager.setAdapter(tabPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mViewPager.setCurrentItem(1);

        // 뷰페이저와 탭이 상호작용 하도록 하는 리스너이다. 특정 탭을 클릭 하였을 시에 같은 포지션에 위치한 뷰를 불러오게 된다.
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
    }

    // TODO: 텝페이저 어뎁터를 이너클래스로 바꾸는 것도 괜찮은 방법일 것 같다.
}
