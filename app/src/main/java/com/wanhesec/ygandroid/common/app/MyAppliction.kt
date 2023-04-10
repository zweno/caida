package com.wanhesec.ygandroid.common.app

import android.app.Application
import com.wanhesec.core.Core

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/5/18 上午11:20
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/5/18 上午11:20 1.00 初始版本
 * ****************************************************************
 */
class MyAppliction : Application() {
    override fun onCreate() {
        super.onCreate()
        Core.init(this);
    }
}