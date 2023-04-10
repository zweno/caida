package com.wanhesec.core.mvvm

import androidx.appcompat.app.AppCompatActivity
import com.wanhesec.core.base.IActivity
import com.wanhesec.core.livedata.CommonLiveData
import com.wanhesec.core.mvvm.actuator.ActivityActuator

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 上午9:12
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/27 上午9:12 1.00 初始版本
 * ****************************************************************
 */
interface IMvmActivity : IActivity,IMvmView{
    fun dataObserver() {}

    fun <R> quickObserve(liveData: CommonLiveData<R>, block: ActivityActuator<R>.() -> Unit) {
        ActivityActuator(this as AppCompatActivity, liveData).apply(block)
    }

    fun <R> quickObserveSuccess(liveData: CommonLiveData<R>, successBlock: (R?) -> Unit) {
        ActivityActuator(this as AppCompatActivity, liveData).onSuccess(successBlock)
    }

}