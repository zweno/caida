package com.wanhesec.core.utils

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 下午2:32
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/27 下午2:32 1.00 初始版本
 * ****************************************************************
 */
object ClickUtil {
    private var clickTime: Long = 0

    private var frequency = 1

    /**
     *  双击事件
     *  @param duration 两次间隔时间
     */
    fun interval(count: Int = 2, duration: Int = 1000, block: () -> Unit) {
        val nowTime = System.currentTimeMillis()

        if (nowTime - clickTime > duration) {
            clickTime = nowTime
            frequency = 1
            return
        }

        frequency++

        if (frequency != count) return

        block()
        frequency = 1
    }
}