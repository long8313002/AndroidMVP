package com.zhangzheng0601.androidmvp.base

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View

abstract class BasePresenter<V: BasePresenter.IView,M: BasePresenter.IModel>{

    interface IView {

        fun showToast(message: String)

        fun getString(resId: Int):String?

        fun getBitmap(resId:Int):Bitmap?

        fun  getContentView():View

    }

    interface IModel

    protected lateinit var view:V
    protected lateinit var model:M

    fun attach( view: V,  model: M){
        this.view = view
        this.model = model
    }

   open fun onCreate(savedInstanceState: Bundle?) {

    }

    open fun onPause() {

    }

    open fun onResume() {

    }

    open fun onStop() {

    }

    open fun onDestroy() {

    }

}