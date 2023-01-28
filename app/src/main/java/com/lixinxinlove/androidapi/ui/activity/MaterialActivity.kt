package com.lixinxinlove.androidapi.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import com.lixinxinlove.androidapi.R
import com.lixinxinlove.androidapi.base.BaseActivity
import com.lixinxinlove.androidapi.databinding.ActivityMaterialBinding

class MaterialActivity : BaseActivity<ActivityMaterialBinding>() {

    override fun getViewBinding(layoutInflater: LayoutInflater): ActivityMaterialBinding {
        return ActivityMaterialBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //createMaterialShapeDrawable(binding.bottomSheet)
    }


    private fun createMaterialShapeDrawable(bottomSheet: View): MaterialShapeDrawable {
        // Create a ShapeAppearanceModel with the same shapeAppearanceOverlay used in the style
        val shapeAppearanceModel =
            ShapeAppearanceModel.builder(this, 0, R.style.CustomShapeAppearanceBottomSheetDialog)
                .build()

        // Create a new MaterialShapeDrawable (you can't use the original MaterialShapeDrawable in the BottomSheet)
        val currentMaterialShapeDrawable = bottomSheet.background as MaterialShapeDrawable
        return MaterialShapeDrawable(shapeAppearanceModel).apply {
            // Copy the attributes in the new MaterialShapeDrawable
            initializeElevationOverlay(mActivity)
            fillColor = currentMaterialShapeDrawable.fillColor
            tintList = currentMaterialShapeDrawable.tintList
            elevation = currentMaterialShapeDrawable.elevation
            strokeWidth = currentMaterialShapeDrawable.strokeWidth
            strokeColor = currentMaterialShapeDrawable.strokeColor
        }
    }

}