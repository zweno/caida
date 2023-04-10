package com.wanhesec.core

import android.app.Application
import com.wanhesec.core.delegate.ActivityLifecycle
import com.wanhesec.core.http.BaseRetrofitConfig
import com.wanhesec.core.http.DefaultRetrofitConfig
import com.wanhesec.core.mvvm.actuator.IActivityActuator
import com.wanhesec.core.mvvm.actuator.ILiveDataActuator

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/26 下午2:19
 * 文件描述: 核心初始化类，内部使用，不采用contentProvider来初始化
 * 注意事项:
 * 修改历史: 2021/4/26 下午2:19 1.00 初始版本
 * ****************************************************************
 */
object Core {
    var retrofitConfig: BaseRetrofitConfig = DefaultRetrofitConfig()

    var activityActuator: IActivityActuator? = null

    var liveDataActuator: ILiveDataActuator? = null

    var printLog = true


     fun init(application: Application) {
        application.registerActivityLifecycleCallbacks(ActivityLifecycle)
    }


    fun initRetrofitConfig(retrofitConfig: BaseRetrofitConfig) {
        this.retrofitConfig = retrofitConfig
    }

    fun configActivityActuator(actuator: IActivityActuator) {
        this.activityActuator = actuator
    }

    fun configLiveDataActuator(actuator: ILiveDataActuator) {
        this.liveDataActuator = actuator
    }
}