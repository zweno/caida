package com.wanhesec.core.delegate

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.wanhesec.core.base.IFragment

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 下午2:08
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/27 下午2:08 1.00 初始版本
 * ****************************************************************
 */
open class FragmentDelegateImpl(
    private var fragmentManager: FragmentManager?,
    private var fragment: Fragment?
) : FragmentDelegate {

    private var iFragment: IFragment? = fragment as IFragment

    override fun onAttached(context: Context) {
    }

    override fun onCreated(savedInstanceState: Bundle?) {

        fragment?.let { fragment ->
            var clazz = fragment.javaClass.superclass

            while (clazz?.name != Fragment::class.java.name) {
                clazz = clazz?.superclass
            }

            val field = clazz.getDeclaredField("mContentLayoutId")

            field.isAccessible = true
            field.set(fragment, iFragment?.getLayoutId())
        }
    }

    override fun onViewCreated(v: View, savedInstanceState: Bundle?) {
        iFragment?.apply {
            initBefore()
            initView()
            initListener()
            initData()
        }
    }

    override fun isAdd(): Boolean = fragment?.isAdded ?: false

    override fun onActivityCreate(savedInstanceState: Bundle?) {
    }

    override fun onStarted() {
    }

    override fun onResumed() {
    }

    override fun onPaused() {
    }

    override fun onStopped() {}

    override fun onSaveInstanceState(outState: Bundle) {}

    override fun onViewDestroyed() {}

    /**
     *  防止内存泄漏
     */
    override fun onDestroyed() {
        this.fragmentManager = null
        this.fragment = null
        this.iFragment = null
    }

    override fun onDetached() {}
}