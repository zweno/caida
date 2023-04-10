package com.wanhesec.core.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/26 下午2:15
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/26 下午2:15 1.00 初始版本
 * ****************************************************************
 */

abstract class BaseRetrofitConfig : RetrofitConfig {

    override fun initRetrofit(baseUrl: String): Retrofit = BaseRetrofit.create(baseUrl, this)

    override fun initOkHttpClient(): OkHttpClient = BaseOkHttpClient.create()
}