package com.wanhesec.core.delegate

import android.content.Context
import android.os.Bundle
import android.view.View

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 下午2:08
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/27 下午2:08 1.00 初始版本
 * ****************************************************************
 */
interface FragmentDelegate {
    fun onAttached(context: Context)

    fun onCreated(savedInstanceState: Bundle?)

    fun onViewCreated(v: View, savedInstanceState: Bundle?)

    fun onActivityCreate(savedInstanceState: Bundle?)

    fun onStarted()

    fun onResumed()

    fun onPaused()

    fun onStopped()

    fun onSaveInstanceState(outState: Bundle)

    fun onViewDestroyed()

    fun onDestroyed()

    fun onDetached()

    fun isAdd(): Boolean
}