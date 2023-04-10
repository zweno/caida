package com.wanhesec.core.mvvm

import android.app.Activity
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.wanhesec.core.R
import com.wanhesec.core.ext.Toasts.toast
import com.wanhesec.core.ext.logd

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 上午9:13
 * 文件描述: 主要规定了 加载数据常用的loading方法
 * 注意事项:
 * 修改历史: 2021/4/27 上午9:13 1.00 初始版本
 * ****************************************************************
 */
interface IMvmView {
    fun showError(msg: String) {
        realToast(msg)
        logd(msg)
    }

    fun showToast(@StringRes strRes: Int) {
        realToast(strRes)
    }

    fun showToast(msg: String) {
        realToast(msg)
    }

    fun realToast(msg: String) {
        if (this is Fragment) {
            this.toast(msg)
        } else if (this is Activity) {
            this.toast(msg)
        }
    }

    fun realToast(strRes: Int) {
        if (this is Fragment) {
            this.toast(strRes)
        } else if (this is Activity) {
            this.toast(strRes)
        }
    }

    fun showEmptyView() {}

    fun showLoading() {}

    fun hideLoading() {}
}