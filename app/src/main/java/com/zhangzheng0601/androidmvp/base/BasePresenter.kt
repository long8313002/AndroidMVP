package com.zhangzheng0601.androidmvp

import android.graphics.Bitmap
import android.os.Bundle

abstract class BasePresenter<V: BasePresenter.IView,M:BasePresenter.IModel>{

    interface IView {

        fun showToast(message: String)

        fun getString(resId: Int):String?

        fun getBitmap(resId:Int):Bitmap?

    }

    interface IModel

    protected lateinit var view:V
    protected lateinit var model:M

    fun attach( view: V,  model: M){
        this.view = view
        this.model = model
    }

    fun onCreate(savedInstanceState: Bundle?) {

    }

    fun onPause() {

    }

    fun onResume() {

    }

    fun onStop() {

    }

    fun onDestory() {

    }

}