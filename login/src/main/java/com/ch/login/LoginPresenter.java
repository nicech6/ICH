package com.ch.login;

import android.content.Context;

import com.ch.base.mvp.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginContact.View,LoginModel> {


    public LoginPresenter(LoginContact.View view, Context context) {
        super(view, context);
    }
}