package com.zhangzheng0601.androidmvp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.zhangzheng0601.androidmvp.base.BaseView
import kotlinx.android.synthetic.main.activity_main.view.*

class LoginView(context: Context, var callback: IEventCallBack) : BaseView(context), LoginPresenter.ILoginView {

    interface IEventCallBack {

        fun onClearClick(view: View)

        fun onLoginClick(view: View)
    }


    init {
        LayoutInflater.from(context).inflate(R.layout.activity_main, this)

        btClear.setOnClickListener {
            callback.onClearClick(it)
        }

        btLogin.setOnClickListener {
            callback.onLoginClick(it)
        }
    }

    override fun getUserName(): String? {
        return etUserName.text.toString()
    }

    override fun getPassword(): String? {
        return etPassword.text.toString()
    }

    override fun checkedRemember(): Boolean {
        return cbRemember.isChecked
    }

    override fun setUserName(username: String?) {
        etUserName.setText(username)
    }

    override fun setPassword(password: String?) {
        etPassword.setText(password)
    }

    override fun setChecked(isChecked: Boolean) {
        cbRemember.isChecked = isChecked
    }


}
