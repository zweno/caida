package com.wanhesec.core.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/26 下午2:16
 * 文件描述: 在factory中串联 retrofit和okhttp的配置
 * 注意事项:
 * 修改历史: 2021/4/26 下午2:16 1.00 初始版本
 * ****************************************************************
 */
interface RetrofitConfig {
    fun initRetrofit(baseUrl: String): Retrofit

    fun initOkHttpClient(): OkHttpClient
}