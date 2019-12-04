package com.ch.login;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.ch.base.mvp.BaseActivity;

@Route(path = "/login/main")
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContact.View {


    @Override
    protected void initView() {
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
