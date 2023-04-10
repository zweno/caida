package com.wanhesec.core.ext

import android.util.Log
import com.wanhesec.core.Core
import com.wanhesec.core.constant.Const

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/26 下午2:28
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/26 下午2:28 1.00 初始版本
 * ****************************************************************
 */

fun logv(message: String, tag: String = Const.Log_Tag) = run {
    if(Core.printLog) {
        Log.v(tag, message)
    }
}

fun logd(message: String, tag: String = Const.Log_Tag) = run {
    if(Core.printLog) {
        Log.d(tag, message)
    }
}

fun logi(message: String, tag: String = Const.Log_Tag) = run {
    if(Core.printLog) {
        Log.i(tag, message)
    }
}
fun logw(message: String, tag: String = Const.Log_Tag) = run {
    if(Core.printLog) {
        Log.w(tag, message)
    }
}
fun loge(message: String, tag: String = Const.Log_Tag) = run {
    if(Core.printLog) {
        Log.e(tag, message)
    }
}


fun String.showLog() {
    logd("<<<<<<--------------------------")
    logd("[content]:  $this")
    logd("-------------------------->>>>>>")
}


