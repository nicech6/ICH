package com.ch.app;

import android.view.MotionEvent;
import android.view.View;

import com.ch.base.mvp.BaseActivity;
import com.ch.base.util.ToastUtils;

public class MainActivity extends BaseActivity {


    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
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
