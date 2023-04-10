package com.wanhesec.core.common

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 上午9:34
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/27 上午9:34 1.00 初始版本
 * ****************************************************************
 */
data class SharedData (val msg: String = "",
                       val strRes: Int = 0,
                       val type: SharedType = SharedType.RESOURCE)