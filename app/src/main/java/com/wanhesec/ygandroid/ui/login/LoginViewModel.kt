package com.wanhesec.ygandroid.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import com.wanhesec.core.annotation.BindRepository
import com.wanhesec.core.livedata.CommonLiveData
import com.wanhesec.core.mvvm.BaseViewModel
import com.wanhesec.ygandroid.R
import com.wanhesec.ygandroid.ui.data.LoginRepository
import com.wanhesec.ygandroid.ui.data.Result
import com.wanhesec.ygandroid.ui.data.model.LoggedInUser


class LoginViewModel() : BaseViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()

    @BindRepository
    lateinit var loginRepository : LoginRepository

    val loginData = CommonLiveData<LoggedInUser>()
    fun login(username: String, password: String) {

        superLaunchRequest(loginData){loginRepository.login(username,password)}

    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }
    //登录规则
    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}