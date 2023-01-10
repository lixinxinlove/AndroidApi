package com.lixinxinlove.androidapi.util

import android.R
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.View.OnAttachStateChangeListener
import android.view.Window
import androidx.annotation.ColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat


object StatusBarUtil {

    fun getStatusBarHeight(context: Context): Int {
        try {
            var statusBarHeight = 0
            val resId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
            if (resId > 0) {
                statusBarHeight = context.resources.getDimensionPixelSize(resId)
            }
            return statusBarHeight
        } catch (e: Exception) {
        }
        return 70
    }


    /**
     *  沉浸式状态栏
     */
    fun immersiveStatusBar(activity: Activity) {
        val window = activity.window.apply {
            statusBarColor = Color.TRANSPARENT
        }

        // 把内容放到系统窗口里面 可以去了解一下Window和decorView的关系
        WindowCompat.setDecorFitsSystemWindows(window, false)
        // 隐藏导航栏
        WindowInsetsControllerCompat(activity.window, activity.window.decorView).let {
            it.hide(WindowInsetsCompat.Type.navigationBars())
            //交互效果
            it.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }


  /**
     *  沉浸式状态栏
     */
    fun immersiveStatusBar(activity: Activity,@ColorInt mStatusBarColor:Int) {
        val window = activity.window.apply {
            statusBarColor = mStatusBarColor
        }

        // 把内容放到系统窗口里面 可以去了解一下Window和decorView的关系
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // 隐藏导航栏
      //  insetsController.hide(WindowInsetsCompat.Type.navigationBars());
// 显示导航栏
        //insetsController.show(WindowInsetsCompat.Type.navigationBars());

        WindowInsetsControllerCompat(activity.window, activity.window.decorView).let {
            it.hide(WindowInsetsCompat.Type.navigationBars())
        }
    }

    /**
     *  设置状态栏字体颜色
     *  此api只能控制字体颜色为 黑/白
     *  @param color 这里的颜色是指背景颜色
     */
    fun setStatusBarTextColor(activity: Activity, isDay: Boolean) {
        // 计算颜色亮度

        WindowInsetsControllerCompat(activity.window, activity.window.decorView)
            .isAppearanceLightStatusBars = isDay
    }

    /**
     *  设置状态栏颜色
     *  这里还是直接操作window的statusBarColor
     */
    fun setStatusBarColor(activity: Activity, @ColorInt color: Int) {
        activity.window.statusBarColor = color
    }


    /**
     *
     * 显示隐藏底部导航栏（注意不是沉浸式效果）  */
    fun showHideNavigationBar(activity: Activity, isShow: Boolean) {
        val decorView: View = activity.findViewById(R.id.content)
        val controller = ViewCompat.getWindowInsetsController(decorView)
        if (controller != null) {
            if (isShow) {
                controller.show(WindowInsetsCompat.Type.navigationBars())
                controller.systemBarsBehavior =
                    WindowInsetsControllerCompat.BEHAVIOR_SHOW_BARS_BY_TOUCH
            } else {
                controller.hide(WindowInsetsCompat.Type.navigationBars())
                controller.systemBarsBehavior =
                    WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        }
    }


    /**
     *
     * 5.0以上-设置NavigationBar底部导航栏的沉浸式  */
    fun immersiveNavigationBar(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window: Window = activity.window
            val decorView: View = window.getDecorView()
            decorView.systemUiVisibility =
                decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.navigationBarColor = Color.TRANSPARENT
        }
    }



    /** * 老的方法获取导航栏的高度  */
     fun getNavigationBarHeight(context: Context): Int {
        var result = 0
        val resourceId =
            context.resources.getIdentifier("navigation_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = context.resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

}