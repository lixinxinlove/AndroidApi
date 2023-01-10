package com.lixinxinlove.androidapi.util.biometric;

import android.os.CancellationSignal;


/**
 * Created by gaoyang on 2018/06/19.
 */
interface IBiometricPromptImpl {

    void authenticate( CancellationSignal cancel, BiometricPromptManager.OnBiometricIdentifyCallback callback);

}
