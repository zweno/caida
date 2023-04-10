package com.wanhesec.core.delegate

import android.app.Activity
import android.os.Bundle
import com.wanhesec.core.annotation.BindViewModel
import com.wanhesec.core.common.ViewModelFactory
import com.wanhesec.core.mvvm.IMvmActivity
import java.lang.reflect.Field

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/26 下午4:15
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/26 下午4:15 1.00 初始版本
 * ****************************************************************
 */
class MvmActivityDelegateImpl(private var activity: Activity?)
    : ActivityDelegateImpl(activity), IMvmActivity {

    override fun getLayoutId(): Int = 0

    private var iMvmActivity: IMvmActivity? = activity as IMvmActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        initViewModel()
        super.onCreate(savedInstanceState)
        iMvmActivity?.dataObserver()
    }

    /**
     *  根据 @BindViewModel 注解, 查找注解标示的变量（ViewModel）
     *  并且 创建 ViewModel 实例, 注入到变量中
     */
    private fun initViewModel() {
        activity?.apply {
            javaClass.fields
                .filter { field -> field.isAnnotationPresent(BindViewModel::class.java) }
                .forEach { field -> injectViewModel(field, this) }
        }
    }

    private fun injectViewModel(field: Field?, activity: Activity) {
        field?.apply {
            isAccessible = true
            val viewModel = ViewModelFactory.createViewModel(field, activity)
            set(activity, viewModel)
        }
    }

    /**
     *  防止内存泄漏
     */
    override fun onDestroy() {
        super.onDestroy()
        this.activity = null
        this.iMvmActivity = null
    }
}