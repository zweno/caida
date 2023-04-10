package com.wanhesec.core.delegate

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.wanhesec.core.annotation.BindViewModel
import com.wanhesec.core.common.ViewModelFactory
import com.wanhesec.core.mvvm.IMvmFragment
import java.lang.reflect.Field

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 下午2:11
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/27 下午2:11 1.00 初始版本
 * ****************************************************************
 */
class MvmFragmentDelegateImpl(private var fm: FragmentManager?,
                              private var fragment: Fragment?)
    : FragmentDelegateImpl(fm, fragment), IMvmFragment {

    override fun getLayoutId(): Int = 0

    private var iMvmFragment: IMvmFragment? = fragment as IMvmFragment

    override fun onCreated(savedInstanceState: Bundle?) {
        super.onCreated(savedInstanceState)

        initViewModel()
        iMvmFragment?.dataObserver()
    }

    /**
     *  根据 @BindViewModel 注解, 查找注解标示的变量（ViewModel）
     *  并且 创建 ViewModel 实例, 注入到变量中
     */
    private fun initViewModel() {
        fragment?.apply {
            javaClass.fields
                .filter { field -> field.isAnnotationPresent(BindViewModel::class.java) }
                .forEach { field -> injectViewModel(field, this) }
        }
    }

    private fun injectViewModel(field: Field?, fragment: Fragment) = field?.apply {
        isAccessible = true
        val viewModel = ViewModelFactory.createViewModel(field, fragment)
        set(fragment, viewModel)
    }

    /**
     *  防止内存泄漏
     */
    override fun onDestroyed() {
        super.onDestroyed()
        this.fm = null
        this.fragment = null
        this.iMvmFragment = null
    }
}