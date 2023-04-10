package com.wanhesec.core.ext

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 上午10:12
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/27 上午10:12 1.00 初始版本
 * ****************************************************************
 */

inline fun tryCatch(block: TryCatch.() -> Unit) {
    TryCatch().apply(block)
}

inline fun tryCatch(tryBlock: () -> Unit, catchBlock: (Throwable) -> Unit = {}) {
    try {
        tryBlock()
    } catch (t: Throwable) {
        t.printStackTrace()
        catchBlock(t)
    }
}

class TryCatch {

    private var tryBlock: (() -> Unit)? = null
    private var catchBlock: ((Throwable) -> Unit)? = null

    fun onTry(block: () -> Unit) {
        this.tryBlock = block
    }

    fun onCatch(block: (Throwable) -> Unit) {
        this.catchBlock = block
    }
}
