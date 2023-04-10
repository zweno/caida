package com.wanhesec.core.delegate

import android.app.Activity
import android.os.Bundle
import com.wanhesec.core.base.IActivity

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/26 下午4:13
 * 文件描述: activity代理的具体实现， 实现IAtivity封装方法的调用
 * 注意事项:
 * 修改历史: 2021/4/26 下午4:13 1.00 初始版本
 * ****************************************************************
 */
open class ActivityDelegateImpl (private var activity: Activity?) : ActivityDelegate {

    private var iActivity: IActivity? = activity as IActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        iActivity?.apply {
            // 在界面未初始化之前调用的初始化窗口
            initWidows()

            if (initArgs(activity?.intent?.extras)) {
                activity?.setContentView(getLayoutId())

                initBefore()
                initView()
                initListener()
                initData()
            } else {
                activity?.finish()
            }
        }
    }

    override fun onStart() {
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onStop() {
    }

    override fun onDestroy() {
        this.activity = null
        this.iActivity = null
    }

    override fun onSaveInstanceState(activity: Activity?, outState: Bundle?) {

    }
}