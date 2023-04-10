package com.wanhesec.core.base

import android.os.Bundle

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/26 下午4:10
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/26 下午4:10 1.00 初始版本
 * ****************************************************************
 */
interface IActivity : IView{
    fun initWidows() {}

    fun initArgs(extras: Bundle?): Boolean = true
}