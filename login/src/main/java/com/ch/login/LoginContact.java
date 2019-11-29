package com.ch.login;

import com.ch.base.mvp.BaseModel;
import com.ch.base.mvp.BaseView;

/**
 * @author: cuihai
 * @description: 类描述
 * @date: 2019/11/26
 * @email: nicech6@163.com
 */
public interface LoginContact {

    interface View extends BaseView {
        void onShowLogin();
    }

    interface Model extends BaseModel {

    }
}
