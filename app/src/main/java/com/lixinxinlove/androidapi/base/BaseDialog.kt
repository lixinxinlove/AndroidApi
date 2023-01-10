package com.lixinxinlove.androidapi.base

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

abstract class BaseDialog<VB : ViewBinding> : Dialog{

    protected lateinit var binding: VB

    protected val TAG = javaClass.simpleName

    protected var activity:Context = context

    constructor(context: Context):super(context)
    constructor(context: Context,themeResId: Int):super(context,themeResId)
    constructor(context: Context, cancelable: Boolean, cancelListener: DialogInterface.OnCancelListener?) :super(context,cancelable,cancelListener)

    protected abstract fun getViewBinding(layoutInflater: LayoutInflater): VB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=getViewBinding(layoutInflater)
        setContentView(binding.root)

    }



}