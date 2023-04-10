package com.wanhesec.core.annotation

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/26 下午2:22
 * 文件描述: 注解用于解析 retrofit的baseurl
 * 注意事项:
 * 修改历史: 2021/4/26 下午2:22 1.00 初始版本
 * ****************************************************************
 */

@Target(AnnotationTarget.FIELD,AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class BaseUrl(val value: String){

}