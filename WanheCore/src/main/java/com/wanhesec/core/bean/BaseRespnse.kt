package com.wanhesec.core.bean

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/5/17 下午2:42
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/5/17 下午2:42 1.00 初始版本
 * ****************************************************************
 */
data class BaseResponse<T>(var data: T?,
                      var errorCode: Int = -1,
                      var errorMsg: String = "") : KResponse<T> {

    override fun isSuccess(): Boolean = errorCode == 0

    override fun getKData(): T? = data

    override fun getKMessage(): String? = errorMsg

}

