package com.lixinxinlove.androidapi.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.lixinxinlove.androidapi.base.BaseActivity
import com.lixinxinlove.androidapi.databinding.ActivityBottomSheetsBinding

class BottomSheetsActivity : BaseActivity<ActivityBottomSheetsBinding>() {


    override fun getViewBinding(layoutInflater: LayoutInflater): ActivityBottomSheetsBinding {
        return ActivityBottomSheetsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initEvent()
    }

    private fun initEvent() {

        var behavior = BottomSheetBehavior.from(binding.bottomSheet)
        behavior.addBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                //这里是bottomSheet状态的改变
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                //这里是拖拽中的回调，根据slideOffset可以做一些动画
            }
        })




        binding.showView.setOnClickListener {
            if (behavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                behavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
            } else {
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            }
        }


    }


}