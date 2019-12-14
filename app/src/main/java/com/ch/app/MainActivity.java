package com.ch.app;

import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ch.base.constant.Path;
import com.ch.base.mvp.BaseActivity;
import com.ch.base.mvp.BasePresenter;

public class MainActivity extends BaseActivity {


    @Override
    protected void initView() {
    }

    @Override
    protected void bindEvent() {
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(Path.LOGIN_MAI).navigation();
            }
        });
    }

    @Override
    protected void initData() {

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
