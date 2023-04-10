package com.wanhesec.core.ext

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import com.wanhesec.core.utils.ClickUtil

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 下午2:31
 * 文件描述: view拓展，单击防抖动、双击 键盘关闭打开等等
 * 注意事项:
 * 修改历史: 2021/4/27 下午2:31 1.00 初始版本
 * ****************************************************************
 */

// 关闭软键盘
fun View.hideKeyboard() {
    val imm: InputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}

// 显示软键盘
fun View.showKeyboard() {
    val imm: InputMethodManager =
        context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    this.requestFocus()
    imm.showSoftInput(this, 0)
}

// 关闭软键盘
fun Activity.hideKeyboard() {
    // 当前焦点的 View
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
}

// 获取text内容
fun TextView.str(): String {
    return this.text.toString()
}



// 设置双击事件
fun View.setDoubleClickListener(block: () -> Unit) {
    this.setOnClickListener {
        ClickUtil.interval { block() }
    }
}


// 设置 三击事件
fun View.setTripleClickListener(block: () -> Unit) {
    this.setOnClickListener {
        ClickUtil.interval(3) { block() }
    }
}

fun  View.setTiggerClickListener( time:Long = 800, block:() -> Unit){
    triggerDelay = time
    setOnClickListener {
        if (clickEnable()) {
            block()
        }
    }
}

private var <T : View> T.triggerLastTime: Long
    get() = if (getTag(1123460103) != null) getTag(1123460103) as Long else 0
    set(value) {
        setTag(1123460103, value)
    }

private var <T : View> T.triggerDelay: Long
    get() = if (getTag(1123461123) != null) getTag(1123461123) as Long else -1
    set(value) {
        setTag(1123461123, value)
    }

private fun <T : View> T.clickEnable(): Boolean {
    var flag = false
    val currentClickTime = System.currentTimeMillis()
    if (currentClickTime - triggerLastTime >= triggerDelay) {
        flag = true
    }
    triggerLastTime = currentClickTime
    return flag
}


fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.isVisible(): Boolean = this.visibility == View.VISIBLE

fun View.isInvisible(): Boolean = this.visibility == View.INVISIBLE

fun View.isGone(): Boolean = this.visibility == View.GONE