package com.lixinxinlove.androidapi.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.FrameLayout.LayoutParams
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.lixinxinlove.androidapi.util.StatusBarUtil


abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    protected var TAG = javaClass.simpleName

    private var isLoaded = false //是否已经加载过数据


    protected lateinit var binding: VB

    protected lateinit var mContext: Context

    protected var statusBarHeight = 70


    protected abstract fun getViewBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): VB

    protected abstract fun _onCreateView()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        statusBarHeight = StatusBarUtil.getStatusBarHeight(mContext)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = getViewBinding(layoutInflater, container, savedInstanceState)
        setTopMargin(binding.root)
        _onCreateView()
        return binding.root
    }

    protected abstract fun loadData()


    private fun setTopMargin(rootView: View) {
//        try {
//            val topBarRoot: ConstraintLayout? = rootView.findViewById(R.id.top_bar_root)
//            if (topBarRoot != null) {
//                val lp: LayoutParams =
//                    topBarRoot.layoutParams as LayoutParams
//                lp.topMargin = statusBarHeight
//            }
//
//        } catch (e: Exception) {
//
//        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        isLoaded = false
    }

    override fun onResume() {
        super.onResume()
        if (!isLoaded) {
            loadData()
            Log.e(TAG, "loadData")
            isLoaded = true
        }

    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause")
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()

    }

    override fun onDestroy() {
        super.onDestroy()
    }


}