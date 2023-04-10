package com.wanhesec.core.http.intercept

import com.wanhesec.core.constant.Const
import com.wanhesec.core.ext.logd
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/26 下午2:01
 * 文件描述: okhttp的日志拦截器
 * 注意事项:
 * 修改历史: 2021/4/26 下午2:01 1.00 初始版本
 * ****************************************************************
 */

object LoggingInterceptor {

    fun init(): Interceptor {
        val loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger{ logd(it,Const.net_Log_Tag)})
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }


}