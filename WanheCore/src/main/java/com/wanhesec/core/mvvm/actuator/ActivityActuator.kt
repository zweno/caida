package com.wanhesec.core.mvvm.actuator

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.wanhesec.core.Core
import com.wanhesec.core.livedata.CommonLiveData
import com.wanhesec.core.mvvm.IMvmView
import com.wanhesec.core.mvvm.actuator.impl.DefaultActivityActuator

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 下午1:22
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/27 下午1:22 1.00 初始版本
 * ****************************************************************
 */
class ActivityActuator<R>(private val owner: LifecycleOwner,
                          private val liveData: CommonLiveData<R>
) {

    private val mvmActivity = owner as IMvmView

    private val activityActuator by lazy { Core.activityActuator ?: DefaultActivityActuator() }

    private var successBlock: ((R?) -> Unit) = { success(it) }

    /**
     *  失败 block
     */
    private var failureBlock: ((String?) -> Unit) = { failure(it) }

    /**
     *  异常 block,
     */
    private var exceptionBlock: ((Throwable?) -> Unit) = { exception(it) }

    init {
        liveData.observerError(owner, exceptionBlock, failureBlock)
        liveData.observe(owner, Observer { successBlock(it) })
    }

    fun onSuccess(block: (R?) -> Unit) {
        this.successBlock = block
    }

    fun onFailure(block: (String?) -> Unit) {
        this.failureBlock = block
    }

    fun onException(block: (Throwable?) -> Unit) {
        this.exceptionBlock = block
    }

    /**
     *  viewModel 成功回调 view
     */
    private fun success(data: R?) = activityActuator.success(mvmActivity, data)

    /**
     *  viewModel 失败回调 view, 默认 toast 显示 message
     */
    private fun failure(message: String?) = activityActuator.failure(mvmActivity, message)


    /**
     * viewModel 异常回调 view, 默认实现 调用 showError, 提示 未知异常, 打印 Log
     */
    private fun exception(throwable: Throwable?) = activityActuator.exception(mvmActivity, throwable)
}