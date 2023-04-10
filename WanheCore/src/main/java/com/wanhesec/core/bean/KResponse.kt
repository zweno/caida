package com.wanhesec.core.bean

import com.wanhesec.core.config.Setting
import com.wanhesec.core.ext.Toasts

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 下午1:28
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/27 下午1:28 1.00 初始版本
 * ****************************************************************
 */
interface KResponse<T> {

    fun isSuccess(): Boolean

    fun getKMessage(): String?

    fun getKData(): T?

    /**
     *  全局默认实现, 可根据自身业务 重写execute方法
     *  @param error            若有错误的回调, 默认getKMessage(), 否则返回 Setting.MESSAGE_EMPTY
     *  @param successResponse  成功的回调, 默认是返回 KResponse<T>
     */
    fun executeRsp(successResponse: ((KResponse<T>) -> Unit)?, error: ((String) -> Unit)? = null) {

        if (this.isSuccess()) {
            successResponse?.invoke(this)
            return
        }

        (this.getKMessage() ?: Setting.MESSAGE_EMPTY).let { error?.invoke(it) ?: Toasts.show(it) }
    }

    /**
     *  全局默认实现, 可根据自身业务 重写execute方法
     *  @param success          成功的回调, 默认是返回 getKData()
     *  @param error            若有错误的回调, 默认getKMessage(), 否则返回 Setting.MESSAGE_EMPTY
     */
    fun execute(success: ((T?) -> Unit)?, error: ((String) -> Unit)? = null) {

        if (this.isSuccess()) {
            success?.invoke(this.getKData())
            return
        }

        (this.getKMessage() ?: Setting.MESSAGE_EMPTY).let { error?.invoke(it) ?: Toasts.show(it) }
    }
}