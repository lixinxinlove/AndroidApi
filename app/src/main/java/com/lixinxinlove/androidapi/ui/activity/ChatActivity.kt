package com.lixinxinlove.androidapi.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.lixinxinlove.androidapi.base.BaseActivity
import com.lixinxinlove.androidapi.databinding.ActivityChatBinding

class ChatActivity : BaseActivity<ActivityChatBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getViewBinding(layoutInflater: LayoutInflater): ActivityChatBinding {
     return ActivityChatBinding.inflate(layoutInflater)
    }
}