package com.wanhesec.core.common

import android.app.Activity

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 上午9:31
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/4/27 上午9:31 1.00 初始版本
 * ****************************************************************
 */
object ActivityManager {
    /**
     * 管理所有存活的 Activity
     */
    private val activityList by lazy { arrayListOf<Activity>() }

    fun add(activity: Activity) {
        synchronized(ActivityManager::class.java) {
            if (!activityList.contains(activity)) {
                activityList.add(activity)
            }
        }
    }

    /**
     * 删除集合里的指定的 Activity 实例
     */
    fun remove(activity: Activity) {
        synchronized(ActivityManager::class.java) {
            if (activityList.contains(activity)) {
                activityList.remove(activity)
            }
        }
    }

    /**
     * finish 所有Activity
     */
    fun finishAll() {
        synchronized(ActivityManager::class.java) {
            activityList.forEach { activity -> activity.finish() }
        }
    }
}