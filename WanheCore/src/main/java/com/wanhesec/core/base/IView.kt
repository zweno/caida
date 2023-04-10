package com.wanhesec.core.base

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/26 下午4:11
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/26 下午4:11 1.00 初始版本
 * ****************************************************************
 */
interface IView {

    fun getLayoutId(): Int

    fun initBefore() {}

    fun initView() {}

    fun initListener() {}

    fun initData() {}


}