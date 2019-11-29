package com.ch.base.mvp;

import android.content.Context;

public class BasePresenter<V, M> {
    private V mView;
    private M mModel;

    public BasePresenter(V view, Context context) {
        mView = view;
    }
}
