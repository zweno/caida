package com.wanhesec.core.mvvm.actuator.impl

import com.wanhesec.core.constant.Const
import com.wanhesec.core.mvvm.IMvmView
import com.wanhesec.core.mvvm.actuator.IActivityActuator

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 下午1:29
 * 文件描述: ActivityActuator 中的默认方法
 * 注意事项:
 * 修改历史: 2021/4/27 下午1:29 1.00 初始版本
 * @see com.wanhesec.core.mvvm.actuator.ActivityActuator
 * ****************************************************************
 *
 */
open class DefaultActivityActuator : IActivityActuator {

    /**
     *  quickObserveSuccess -> onSuccess默认实现:  空
     */
    override fun <R> success(mvmView: IMvmView, data: R?) {}

    /**
     * quickObserveSuccess -> onFailure默认实现:  toast message (viewModel 传递过来的 message)
     */
    override fun failure(mvmView: IMvmView, message: String?) {
        mvmView.showToast(message ?: Const.UNKNOWN_ERROR)
    }

    /**
     * quickObserveSuccess -> onException默认实现: toast "未知异常"(固定), 打印 log
     */
    override fun exception(mvmView: IMvmView, throwable: Throwable?) {
        mvmView.showError(throwable?.message ?: "")
    }
}