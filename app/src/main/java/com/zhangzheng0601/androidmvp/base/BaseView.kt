package com.zhangzheng0601.androidmvp.base

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Bitmap
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.zhangzheng0601.androidmvp.base.BasePresenter

abstract class BaseView : FrameLayout, BasePresenter.IView {

    constructor(context: Context) : super(context)

    constructor(activity: Activity) : super(activity)

    constructor(frament: Fragment) : super(frament.activity!!)

    constructor(dialog: Dialog) : super(dialog.context)

    constructor(view: View) : super(view.context)

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun getString(resId: Int): String? {
        return getString(resId)

    }

    override fun getBitmap(resId: Int): Bitmap? {
        return getBitmap(resId)
    }

    override fun getContentView():View {
        return this
    }
}