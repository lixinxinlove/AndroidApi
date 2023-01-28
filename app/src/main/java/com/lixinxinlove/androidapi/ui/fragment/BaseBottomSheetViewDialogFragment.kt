package com.lixinxinlove.androidapi.ui.fragment

import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheetViewDialogFragment<T : View> : BottomSheetDialogFragment() {


    private var _root: T? = null
    val root get() = _root!!

    abstract fun initRootView(): T
    abstract fun init()

    private val bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {
        override fun onStateChanged(bottomSheet: View, newState: Int) {
            when (newState) {
                BottomSheetBehavior.STATE_DRAGGING -> {

                }
                BottomSheetBehavior.STATE_COLLAPSED -> {

                }
                BottomSheetBehavior.STATE_EXPANDED -> {

                    // bottomSheet.background = createMaterialShapeDrawable(bottomSheet)
                }
                else -> {
                }
            }
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        object : BottomSheetDialog(requireContext(), theme) {
            override fun onAttachedToWindow() {
                super.onAttachedToWindow()

                window?.let {
                  //  it.attributes?.windowAnimations = R.style.DialogAnimation
                    WindowCompat.setDecorFitsSystemWindows(it, false)
                  //  UiUtils.setSystemBarStyle(it)
                    WindowInsetsControllerCompat(it, it.decorView)
                        .isAppearanceLightNavigationBars = false

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                        it.addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND)
                        it.attributes.blurBehindRadius = 64 //TODO 背景模糊
                        it.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    }
                }

                findViewById<View>(com.google.android.material.R.id.container)?.fitsSystemWindows = false
                findViewById<View>(com.google.android.material.R.id.coordinator)?.fitsSystemWindows = false
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _root = initRootView()
        init()
        return _root
    }


}