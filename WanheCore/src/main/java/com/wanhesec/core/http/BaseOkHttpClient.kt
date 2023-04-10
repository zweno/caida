package com.wanhesec.core.http

import com.wanhesec.core.config.Setting
import com.wanhesec.core.http.intercept.LoggingInterceptor
import com.wanhesec.core.http.intercept.UrlInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/26 下午1:58
 * 文件描述: okhttp设置基类，可重写
 * 注意事项:
 * 修改历史: 2021/4/26 下午1:58 1.00 初始版本
 * ****************************************************************
 */

object BaseOkHttpClient{

    // 初始化 okHttp
    fun create(vararg interceptors: Interceptor): OkHttpClient {

        val builder = OkHttpClient.Builder()

        interceptors.forEach {
            builder.addInterceptor(it)
        }

        builder.addInterceptor(LoggingInterceptor.init())
            .addInterceptor(UrlInterceptor())
            .readTimeout(Setting.READ_TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(Setting.WRITE_TIME_OUT, TimeUnit.SECONDS)
            .connectTimeout(Setting.CONNECT_TIME_OUT, TimeUnit.SECONDS)

        return builder.build()
    }
}