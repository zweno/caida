package com.wanhesec.ygandroid.common.api

import com.wanhesec.core.http.RetrofitFactory

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/5/18 上午9:45
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/5/18 上午9:45 1.00 初始版本
 * ****************************************************************
 */
object ServiceFactory {
    val apiService by lazy { RetrofitFactory.create(ApiService::class.java) }
}