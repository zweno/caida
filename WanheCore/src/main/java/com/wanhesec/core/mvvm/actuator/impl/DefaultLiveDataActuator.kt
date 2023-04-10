package com.wanhesec.core.mvvm.actuator.impl

import com.wanhesec.core.livedata.CommonLiveData
import com.wanhesec.core.mvvm.actuator.ILiveDataActuator

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 下午1:59
 * 文件描述: 默认实现
 * 注意事项:
 * 修改历史: 2021/4/27 下午1:59 1.00 初始版本
 * ****************************************************************
 *  @see com.wanhesec.core.mvvm.actuator.LiveDataActuator
 */
open class DefaultLiveDataActuator : ILiveDataActuator {

    /**
     * superLaunch -> onSuccess默认实现:  直接传递给 Activity的 quickObserve-> onSuccess
     */
    override fun <R> success(liveData: CommonLiveData<R>, data: R?) {
        liveData.postValue(data)
    }

    /**
     * superLaunch -> onFailure默认实现:  直接传递给 Activity的 quickObserve-> onFailure
     */
    override fun <R> failure(liveData: CommonLiveData<R>, message: String?) {
        liveData.postFailureMessage(message)
    }

    /**
     * superLaunch -> onException默认实现:  直接传递给 Activity的 quickObserve-> onException
     */
    override fun <R> exception(liveData: CommonLiveData<R>, throwable: Throwable?) {
        liveData.postException(throwable)
    }
}