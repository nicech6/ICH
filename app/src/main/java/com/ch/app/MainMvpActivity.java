package com.ch.app;

import com.ch.base.mvp.BaseMvpActivity;
import com.ch.base.mvp.BasePresenter;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;

import java.util.ArrayList;

public class MainMvpActivity extends BaseMvpActivity {
    private CommonTabLayout mTabLayout;
    private String[] mTitles = {"首页", "消息", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.icon_home_unselected,
            R.mipmap.icon_collect_unselected, R.mipmap.icon_mine_unselected};
    private int[] mIconSelectIds = {
            R.mipmap.icon_home_selected,
            R.mipmap.icon_collect_selected, R.mipmap.icon_mine_selected};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override

    protected void initView() {
        mTabLayout = findViewById(R.id.tab);
    }

    @Override
    protected void bindEvent() {

    }

    @Override
    protected void initData() {
        int size = mTitles.length;
        for (int i = 0; i < size; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mTabLayout.setTabData(mTabEntities);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected boolean needImmersion() {
        return true;
    }
}
