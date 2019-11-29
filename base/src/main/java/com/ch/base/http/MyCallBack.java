package com.ch.base.http;


interface MyCallBack<T> {
    void onNext(T t);

    void onComplete();

    void onError(Throwable e);
}
