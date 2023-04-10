package com.wanhesec.core.mvvm

import com.wanhesec.core.base.IFragment

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 上午9:24
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/27 上午9:24 1.00 初始版本
 * ****************************************************************
 */
interface IMvmFragment :IFragment,IMvmView {
    fun dataObserver() {}
}