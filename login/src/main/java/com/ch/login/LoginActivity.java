package com.ch.login;


import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ch.base.mvp.BaseActivity;

@Route(path = "/login/main")
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContact.View {


    @Override
    protected void initView() {
        findViewById(R.id.view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TAG", "view");
            }
        });
        findViewById(R.id.container).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TAG", "container");
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter = new LoginPresenter(this, this);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected boolean needImmersion() {
        return true;
    }

    @Override
    public void onShowLogin() {

    }
}
