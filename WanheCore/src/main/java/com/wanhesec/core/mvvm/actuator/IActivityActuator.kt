package com.wanhesec.core.mvvm.actuator

import com.wanhesec.core.mvvm.IMvmView

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 下午1:26
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/27 下午1:26 1.00 初始版本
 * ****************************************************************
 */
interface IActivityActuator {

    fun <R> success(mvmView: IMvmView, data: R?)

    fun failure(mvmView: IMvmView, message: String?)

    fun exception(mvmView: IMvmView, throwable: Throwable?)
}