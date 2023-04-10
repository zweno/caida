package com.wanhesec.core.mvvm.actuator

import com.wanhesec.core.Core
import com.wanhesec.core.livedata.CommonLiveData
import com.wanhesec.core.mvvm.actuator.impl.DefaultLiveDataActuator
import kotlinx.coroutines.CoroutineScope

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 下午1:27
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/27 下午1:27 1.00 初始版本
 * ****************************************************************
 */
open class LiveDataActuator<R>(
    viewModelScope: CoroutineScope,
    private val liveData: CommonLiveData<R>
) : RequestActuator<R>(viewModelScope) {

    private val liveDataActuator by lazy { Core.liveDataActuator ?: DefaultLiveDataActuator() }

    override fun success(data: R?) {
        liveDataActuator.success(liveData, data)
    }

    override fun failure(message: String?) {
        liveDataActuator.failure(liveData, message)
    }

    override fun exception(throwable: Throwable?) {
        liveDataActuator.exception(liveData, throwable)
    }
}