package com.lixinxinlove.androidapi.ui.activity

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.view.LayoutInflater
import android.widget.Toast
import com.lixinxinlove.androidapi.base.BaseActivity
import com.lixinxinlove.androidapi.databinding.ActivityBiometricPromptBinding
import com.lixinxinlove.androidapi.logger.Logger
import com.lixinxinlove.androidapi.util.biometric.BiometricPromptManager
import com.permissionx.guolindev.PermissionX
import com.permissionx.guolindev.callback.ExplainReasonCallback
import com.permissionx.guolindev.request.ExplainScope


class BiometricPromptActivity : BaseActivity<ActivityBiometricPromptBinding>() {

    private lateinit var mManager: BiometricPromptManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.loginBtn.setOnClickListener {
            onBiometricPrompt()
        }

        permission()


    }

    override fun getViewBinding(layoutInflater: LayoutInflater): ActivityBiometricPromptBinding {
        return ActivityBiometricPromptBinding.inflate(layoutInflater)
    }


    private fun permission() {


        PermissionX.init(mActivity)
            .permissions(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.MANAGE_EXTERNAL_STORAGE
            ).onExplainRequestReason { scope, deniedList ->
                scope.showRequestReasonDialog(
                    deniedList,
                    "write external storage",
                    "ok",
                    "cancel"
                )
            }
            .request { allGranted, grantedList, deniedList ->
                if (allGranted) {
                    //Toast.makeText(this, "All permissions are granted", Toast.LENGTH_LONG).show()
                } else {
                    //  ToastUtil.showShortToastCenter(mActivity, "请开启相机权限")
                }
            }


//        if (!Environment.isExternalStorageManager()) {
//            val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
//            startActivity(intent)
//            return
//        }else{
//            Logger.initLogger(this)
//        }

    }

    private fun onBiometricPrompt() {
        if (mManager.isBiometricPromptEnable) {
            mManager.authenticate(object : BiometricPromptManager.OnBiometricIdentifyCallback {


                override fun onUsePassword() {
                    Toast.makeText(mActivity, "onUsePassword", Toast.LENGTH_SHORT).show()

                }

                override fun onSucceeded() {
                    Toast.makeText(mActivity, "onSucceeded", Toast.LENGTH_SHORT).show()
                    Logger.e("BiometricPromptActivity", "指纹识别成功")
                }

                override fun onFailed() {
                    Toast.makeText(mActivity, "onFailed", Toast.LENGTH_SHORT).show()

                }

                override fun onError(code: Int, reason: String?) {
                    Toast.makeText(mActivity, "onError", Toast.LENGTH_SHORT).show()

                }

                override fun onCancel() {
                    Toast.makeText(mActivity, "onCancel", Toast.LENGTH_SHORT).show()

                }
            });
        }

    }


}