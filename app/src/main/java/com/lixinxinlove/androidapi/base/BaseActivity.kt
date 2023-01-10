package com.lixinxinlove.androidapi.base

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.WindowCompat
import androidx.viewbinding.ViewBinding
import com.lixinxinlove.androidapi.util.StatusBarUtil


//base
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    protected val TAG = javaClass.simpleName

    protected lateinit var binding: VB

    protected lateinit var mActivity: AppCompatActivity

    protected var statusBarHeight: Int = 70
    protected var navigationBarHeight: Int = 0


    protected abstract fun getViewBinding(layoutInflater: LayoutInflater): VB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
//        window.statusBarColor = Color.TRANSPARENT
//        window.decorView.systemUiVisibility =
//            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//

        // window.statusBarColor = Color.TRANSPARENT
        // window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        statusBarHeight = StatusBarUtil.getStatusBarHeight(this)
        navigationBarHeight = StatusBarUtil.getNavigationBarHeight(this)

        binding = getViewBinding(layoutInflater)
        setContentView(binding.root)
        mActivity = this


        //StatusBarUtil.immersiveStatusBar(mActivity)
        setTopMargin(binding.root)
    }


    private fun setTopMargin(rootView: View) {
//        try {
//          //  val topBarRoot: ConstraintLayout? = rootView.findViewById(R.id.top_bar_root)
//            if (topBarRoot != null) {
//                val lp: FrameLayout.LayoutParams =
//                    topBarRoot.layoutParams as FrameLayout.LayoutParams
//                lp.topMargin = statusBarHeight
//            }
//
//        } catch (e: Exception) {
//
//        }
    }

}