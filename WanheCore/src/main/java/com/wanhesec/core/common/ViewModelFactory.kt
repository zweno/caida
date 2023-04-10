package com.wanhesec.core.common

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.wanhesec.core.mvvm.BaseViewModel
import com.wanhesec.core.mvvm.IMvmActivity
import com.wanhesec.core.mvvm.IMvmFragment
import com.wanhesec.core.mvvm.IMvmView
import java.lang.reflect.Field

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 上午9:32
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/27 上午9:32 1.00 初始版本
 * ****************************************************************
 */
object ViewModelFactory {
    /**
     *  创建 对应的 ViewModel, 并且 添加 通用 SharedData (LiveData) 到 ViewModel中
     */
    fun createViewModel(field: Field, fragment: Fragment): BaseViewModel {
        val viewModel = realCreateViewModel(field, fragment)
        initSharedData(fragment as IMvmFragment, viewModel)
        return viewModel
    }

    /**
     *  创建 对应的 ViewModel, 并且 添加 通用 SharedData (LiveData) 到 ViewModel中
     */
    fun createViewModel(field: Field, activity: Activity): BaseViewModel {
        val viewModel = realCreateViewModel(field, activity as FragmentActivity)
        initSharedData(activity as IMvmActivity, viewModel)
        return viewModel
    }

    @Suppress("UNCHECKED_CAST")
    private fun realCreateViewModel(field: Field, owner: ViewModelStoreOwner): BaseViewModel {
        val viewModelClass = field.genericType as Class<BaseViewModel>

        return ViewModelProvider(owner,ViewModelProvider.NewInstanceFactory()).get(viewModelClass)
    }

    private fun initSharedData(view: IMvmView, viewModel: BaseViewModel) {

        val observer: Observer<SharedData> = Observer { sharedData ->
            sharedData?.run {
                when (type) {
                    SharedType.TOAST -> view.showToast(msg)
                    SharedType.ERROR -> view.showError(msg)
                    SharedType.SHOW_LOADING -> view.showLoading()
                    SharedType.HIDE_LOADING -> view.hideLoading()
                    SharedType.RESOURCE -> view.showToast(strRes)
                    SharedType.EMPTY -> view.showEmptyView()
                }
            }
        }

        // 订阅通用 observer
        viewModel.sharedData.observe(view as LifecycleOwner, observer)
    }
}