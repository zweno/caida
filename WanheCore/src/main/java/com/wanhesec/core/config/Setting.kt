package com.wanhesec.core.config

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/26 下午2:02
 * 文件描述: 框架的一些设置
 * 注意事项:
 * 修改历史: 2021/4/26 下午2:02 1.00 初始版本
 * ****************************************************************
 */
object Setting {

    // 读超时
    const val READ_TIME_OUT = 20L
    // 写超时
    const val WRITE_TIME_OUT = 30L
    // 连接超时
    const val CONNECT_TIME_OUT = 5L

    // 请求成功状态码
    const val SUCCESS = 0

    const val UNKNOWN_ERROR = "未知异常"

    const val MESSAGE_EMPTY = "message is null"

    const val DATA_EMPTY = "data is null"

    const val FRAGMENT_CACHE_SIZE = 100

    const val ACTIVITY_CACHE_SIZE = 100
}