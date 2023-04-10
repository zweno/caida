package com.wanhesec.core.http

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/26 下午2:15
 * 文件描述:  retrofit工厂类，用于创建 retrofit
 * 注意事项:
 * 修改历史: 2021/4/26 下午2:15 1.00 初始版本
 * ****************************************************************
 */
object BaseRetrofit {
    fun create(baseUrl: String, retrofitConfig: BaseRetrofitConfig): Retrofit {

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(retrofitConfig.initOkHttpClient())
            .build()
    }
}