package com.wanhesec.core.mvvm

import androidx.annotation.StringRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wanhesec.core.annotation.BindRepository
import com.wanhesec.core.bean.KResponse
import com.wanhesec.core.common.Clazz
import com.wanhesec.core.common.SharedData
import com.wanhesec.core.common.SharedType
import com.wanhesec.core.config.Setting
import com.wanhesec.core.ext.launchUI
import com.wanhesec.core.ext.showLog
import com.wanhesec.core.livedata.CommonLiveData
import com.wanhesec.core.mvvm.actuator.LiveDataActuator
import com.wanhesec.core.mvvm.actuator.RequestActuator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 上午9:25
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/27 上午9:25 1.00 初始版本
 * ****************************************************************
 */
abstract class BaseViewModel : ViewModel(), IMvmView {


    init {
        //注入 repository
        javaClass.fields
            .filter { field -> field.isAnnotationPresent(BindRepository::class.java) }
            .forEach { field ->field.set(this, Clazz.getFiledClazz<IBaseRepository>(field).newInstance())  }
    }
    /**
     *  Activity级别, 公共 LiveData
     */
    val sharedData by lazy { MutableLiveData<SharedData>() }

    fun launchUI(
        block: suspend CoroutineScope.() -> Unit,
        error: ((Throwable) -> Unit)? = null
    ): Job {
        return viewModelScope.launchUI({
            block()
        }, {
            error?.invoke(it) ?: showException(it.toString())
        })
    }

    private fun showException(exception: String) {
        exception.showLog()
        showError(Setting.UNKNOWN_ERROR)
    }

    override fun showToast(msg: String) {
        sharedData.value = SharedData(msg, type = SharedType.TOAST)
    }

    override fun showError(msg: String) {
        sharedData.value = SharedData(msg, type = SharedType.ERROR)
    }

    override fun showToast(@StringRes strRes: Int) {
        sharedData.value = SharedData(strRes = strRes, type = SharedType.RESOURCE)
    }

    override fun showEmptyView() {
        sharedData.value = SharedData(type = SharedType.EMPTY)
    }

    override fun showLoading() {
        sharedData.value = SharedData(type = SharedType.SHOW_LOADING)
    }

    override fun hideLoading() {
        sharedData.value = SharedData(type = SharedType.HIDE_LOADING)
    }

    fun <R> superLaunch(liveData: CommonLiveData<R>, block: LiveDataActuator<R>.() -> Unit) {
        LiveDataActuator(viewModelScope, liveData).apply(block)
    }

    fun <R> superLaunchRequest(liveData: CommonLiveData<R>, block: suspend CoroutineScope.() -> KResponse<R>) {
        LiveDataActuator(viewModelScope, liveData).request { block() }
    }

    fun <R> quickLaunch(block: RequestActuator<R>.() -> Unit) {
        RequestActuator<R>(viewModelScope).apply(block)
    }
}