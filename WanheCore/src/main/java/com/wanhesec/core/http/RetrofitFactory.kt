package com.wanhesec.core.http

import com.wanhesec.core.Core
import com.wanhesec.core.annotation.BaseUrl
import com.wanhesec.core.annotation.BindUrls
import okhttp3.HttpUrl

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/26 下午2:13
 * 文件描述: retrofit工厂类，用于组装 retrofit
 * 注意事项:
 * 修改历史: 2021/4/26 下午2:13 1.00 初始版本
 * ****************************************************************
 */

object RetrofitFactory {

    val urlMap = hashMapOf<String, HttpUrl?>()

    fun <T> create(clz: Class<T>, retrofitConfig: BaseRetrofitConfig? = null): T {
        val baseUrl = prepareBaseUrl(clz)
        prepareOtherUrls(clz)

        // 判断是否, 单独设置了 retrofitConfig, 否则默认按照全局 RetrofitConfig 配置
        val retrofit = retrofitConfig?.initRetrofit(baseUrl)
            ?: Core.retrofitConfig.initRetrofit(baseUrl)

        return retrofit.create(clz)
    }

    private fun <T> prepareOtherUrls(clz: Class<T>) {
        clz.getAnnotation(BindUrls::class.java)?.values
            ?.filter { it.isNotEmpty() }
            ?.forEach { url -> urlMap[url] = HttpUrl.parse(url) }
    }

    private fun <T> prepareBaseUrl(clz: Class<T>): String {
        val baseUrlAnnotation = clz.getAnnotation(BaseUrl::class.java)
        return baseUrlAnnotation?.value ?: throw IllegalArgumentException("base url is null")
    }
}