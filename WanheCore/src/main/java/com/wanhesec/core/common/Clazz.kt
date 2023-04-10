package com.wanhesec.core.common

import java.lang.reflect.Field
import java.lang.reflect.ParameterizedType

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/4/27 上午9:32
 * 文件描述: 反射工具
 * 注意事项:
 * 修改历史: 2021/4/27 上午9:32 1.00 初始版本
 * ****************************************************************
 */
object Clazz {
    @Suppress("UNCHECKED_CAST")
    fun <T> getClass(t: Any): Class<T> {
        // 通过反射 获取当前类的父类的泛型 (T) 对应 Class类
        return (t.javaClass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[0]
                as Class<T>
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> getFiledClazz(field: Field) = field.genericType as Class<T>

}