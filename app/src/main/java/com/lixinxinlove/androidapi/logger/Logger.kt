package com.lixinxinlove.androidapi.logger

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Environment
import android.util.Log
import androidx.core.content.ContextCompat
import com.lixinxinlove.androidapi.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

object Logger {

    private val TAG = "Logger"
    private var LOGFILE: String = ""

    fun initLogger(context: Context) {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd_HH:mm:ss", Locale.getDefault())
        val time = simpleDateFormat.format(Date())
        var path = Environment.getExternalStorageDirectory().path + "/"
        //  var path = context.cacheDir.absolutePath + "/"
        path = "$path$time.log"
        LOGFILE = path

        Log.e(TAG, "log file path :$path")
        createLogFile()
    }


    private var hasCreateLogFile = false

    private fun createLogFile(): Boolean {
        if (hasCreateLogFile) {
            Log.e(TAG, "log file path :有文件")
            return true
        }


        val hasPermission = ContextCompat.checkSelfPermission(
            App.application,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )

        if (hasPermission != PackageManager.PERMISSION_GRANTED) {
            Log.e(TAG, "没有权限")
            return false
        }

        Log.e(TAG, "有权限")
        val file = File(LOGFILE)



        if (!file.exists()) {
            Log.e(TAG, "创建文件")
            try {
                hasCreateLogFile = file.createNewFile()
            }catch (e:Exception){

            }


        }


        return hasCreateLogFile
    }


    private fun writeFile(tag: String, msg: String) {
        MainScope().launch(Dispatchers.IO) {
            writeLog(tag, msg)
        }
    }


    private fun writeLog(tag: String, msg: String) {
        val result: Boolean = createLogFile()
        if (result) {
            val file = File(LOGFILE)
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            val time = simpleDateFormat.format(Date())
            file.appendText("$time: $tag $msg\n")
        } else {
            Log.e(TAG, "文件创建失败")
        }
    }

    //===========================


    fun e(tag: String, msg: String) {
        writeFile(tag, msg)
    }
}