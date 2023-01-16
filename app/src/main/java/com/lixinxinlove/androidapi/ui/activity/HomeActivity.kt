package com.lixinxinlove.androidapi.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.lixinxinlove.androidapi.base.BaseActivity
import com.lixinxinlove.androidapi.databinding.ActivityHomeBinding
import com.lixinxinlove.androidapi.ui.adapter.HomeListAdapter
import com.lixinxinlove.baselibrary.event.EventReportManager

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    override fun getViewBinding(layoutInflater: LayoutInflater): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        initView()

        EventReportManager.reportEvent("home")
    }

    private fun initView() {
        val mList = listOf("chat", "BottomSheetsActivity")
        val mAdapter = HomeListAdapter(mList) {
            when (it) {
                "chat" -> {
                    startActivity(Intent(mActivity, ChatActivity::class.java))
                }
                "BottomSheetsActivity" -> {
                    startActivity(Intent(mActivity, BottomSheetsActivity::class.java))
                }
            }
        }
        binding.mRecyclerView.adapter = mAdapter

    }


}