package com.ch.login;


import com.alibaba.android.arouter.facade.annotation.Route;

import com.ch.common.base.BaseActivity;

@Route(path = "/login/main")
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {


    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
        mPresenter = new LoginPresenter(this);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected boolean needImmersion() {
        return true;
    }
}
