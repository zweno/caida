package com.wanhesec.core.annotation

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/26 下午2:24
 * 文件描述: 个别不是用baseurl但是使用同一个retrofit的请求，用这个注解
 * 注意事项:
 * 修改历史: 2021/4/26 下午2:24 1.00 初始版本
 * ****************************************************************
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class BindUrls(vararg val values: String = [])
