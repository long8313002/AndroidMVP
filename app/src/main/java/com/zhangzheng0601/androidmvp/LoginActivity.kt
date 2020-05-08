package com.zhangzheng0601.androidmvp

import android.os.Bundle
import android.view.View
import com.zhangzheng0601.androidmvp.LoginView.IEventCallBack
import com.zhangzheng0601.androidmvp.base.BaseActivity
import com.zhangzheng0601.androidmvp.model.LoginModel
import com.zhangzheng0601.androidmvp.model.LoginRequest
import com.zhangzheng0601.androidmvp.model.LoginSave
import com.zhangzheng0601.androidmvp.model.LoginVerification

internal class LoginActivity : BaseActivity<LoginPresenter.ILoginView, LoginPresenter.ILoginModel, LoginPresenter>(),IEventCallBack{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.getContentView())
    }

    override fun createPresenter(): LoginPresenter {
        return LoginPresenter()
    }

    override fun createModel(): LoginPresenter.ILoginModel {
        val loginSave = LoginSave(this)
        val loginRequest = LoginRequest()
        val loginVerification = LoginVerification()
        return LoginModel(loginSave,loginVerification,loginRequest)
    }

    override fun createView(): LoginPresenter.ILoginView {
        return LoginView(this, this)
    }

    override fun onCleackClick(view: View) {
        presenter.onClearClick()
    }

    override fun onLoginClick(view: View) {
        presenter.onLoginClick()
    }
}
