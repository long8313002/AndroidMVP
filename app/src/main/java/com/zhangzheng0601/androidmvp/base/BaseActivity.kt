package com.zhangzheng0601.androidmvp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<V: BasePresenter.IView,M: BasePresenter.IModel,T: BasePresenter<V, M>>: AppCompatActivity() {

    protected lateinit var presenter:T
    protected lateinit var view:V
    protected lateinit var model:M


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = createPresenter()
        view = createView()
        model = createModel()
        presenter.attach(view,model)

        presenter.onCreate(savedInstanceState)
    }

    abstract  fun createPresenter():T

    abstract fun createModel():M

    abstract fun createView():V


    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }


}