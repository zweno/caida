package com.wanhesec.core.ext

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 上午9:41
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/27 上午9:41 1.00 初始版本
 * ****************************************************************
 */
fun CoroutineScope.launchUI(
    block: suspend CoroutineScope.() -> Unit,
    error: ((Throwable) -> Unit)? = null
): Job {

    return this.launch(Dispatchers.Main) {
        tryCatch({
            block()
        }, {
            error?.invoke(it)
        })
    }
}