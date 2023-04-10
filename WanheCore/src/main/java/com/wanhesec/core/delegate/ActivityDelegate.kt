package com.wanhesec.core.delegate

import android.app.Activity
import android.os.Bundle

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/26 下午4:12
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/26 下午4:12 1.00 初始版本
 * ****************************************************************
 */
interface ActivityDelegate {

    fun onCreate(savedInstanceState: Bundle?)

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onSaveInstanceState(activity: Activity?, outState: Bundle?)

    fun onDestroy()
}