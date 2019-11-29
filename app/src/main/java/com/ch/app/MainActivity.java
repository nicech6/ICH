package com.ch.app;

import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ch.base.mvp.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void initView() {
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/login/main").navigation();
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
    protected boolean needImmersion() {
        return true;
    }
}
