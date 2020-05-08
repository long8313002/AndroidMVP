package com.zhangzheng0601.androidmvp

import android.os.Bundle
import android.text.TextUtils
import com.zhangzheng0601.androidmvp.base.BasePresenter

class LoginPresenter :
    BasePresenter<LoginPresenter.ILoginView, LoginPresenter.ILoginModel>() {

    interface ILoginView : IView {

        fun getUserName(): String?

        fun getPassword(): String?

        fun checkedRemember(): Boolean

        fun setUserName(username: String?)

        fun setPassword(password: String?)

        fun setChecked(isChecked: Boolean)

    }

    interface ILoginModel : IModel {

        fun login(
            username: String?,
            password: String?,
            callback: (isSuccess: Boolean, message: String?) -> Unit
        )

        fun verification(username: String?, password: String?): String?

        fun save(username: String?, password: String?,isChecked: Boolean)

        fun getUserName(): String?

        fun getPassword(): String?

        fun isCheckedRemember(): Boolean
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (model.isCheckedRemember()) {
            view.setUserName(model.getUserName())
            view.setPassword(model.getPassword())
            view.setChecked(model.isCheckedRemember())
        }
    }


    fun onLoginClick() {

        val verifyResult = model.verification(view.getUserName(), view.getPassword())
        if (!TextUtils.isEmpty(verifyResult)) {
            view.showToast(verifyResult!!)
            return
        }

        model.login(view.getUserName(), view.getPassword()) { isSuccess, message ->
            if (isSuccess) {
                onLoginSuccess()
            } else {
                onLoginFail(message)
            }
        }
    }

    private fun onLoginSuccess() {
        view.showToast("登陆成功")

        if (view.checkedRemember()) {
            model.save(view.getUserName(), view.getPassword(),true)
        }else{
            model.save("", "",false)
        }
    }

    private fun onLoginFail(message: String?) {
        view.showToast(message ?: "登陆失败")
    }

    fun onClearClick() {
        view.setUserName("")
        view.setPassword("")
    }

}