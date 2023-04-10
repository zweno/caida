package com.wanhesec.ygandroid.common.api

import com.wanhesec.core.BuildConfig
import com.wanhesec.core.annotation.BaseUrl
import com.wanhesec.core.bean.BaseResponse
import com.wanhesec.ygandroid.ui.data.model.LoggedInUser
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * ****************************************************************
 * 作    者:Created by it-xiangfan2
 * 创建时间: 2021/5/17 下午2:56
 * 文件描述:
 * 注意事项:
 * 修改历史: 2021/5/17 下午2:56 1.00 初始版本
 * ****************************************************************
 */
@BaseUrl(BuildConfig.API_HOST)
interface ApiService {

    @POST(API.LOGIN)
    suspend fun login(@Query("loginName") username: String,
                    @Query("loginPwd") password: String,@Query("app_id") app_id: String="1"):BaseResponse<LoggedInUser>

}