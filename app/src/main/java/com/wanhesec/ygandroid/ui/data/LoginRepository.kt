package com.wanhesec.ygandroid.ui.data

import com.wanhesec.core.bean.BaseResponse
import com.wanhesec.core.mvvm.IBaseRepository
import com.wanhesec.ygandroid.common.api.ServiceFactory
import com.wanhesec.ygandroid.ui.data.model.LoggedInUser

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository() : IBaseRepository {


    suspend fun login(username: String, password: String): BaseResponse<LoggedInUser> {
        return ServiceFactory.apiService.login(username,password);

    }
}