package com.wanhesec.ygandroid.ui.login

import android.app.Activity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.wanhesec.core.annotation.BindViewModel
import com.wanhesec.core.ext.Toasts.toast
import com.wanhesec.core.ext.setTiggerClickListener
import com.wanhesec.core.mvvm.IMvmActivity
import com.wanhesec.ygandroid.R

class LoginActivity : AppCompatActivity() , IMvmActivity {

    @BindViewModel
    lateinit var loginViewModel: LoginViewModel
    //进度条
    private lateinit var loading :ProgressBar

    override fun getLayoutId(): Int = R.layout.activity_login
    //初始化操作
    override fun initView() {
        super.initView()
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.login)
        loading = findViewById<ProgressBar>(R.id.loading)

        //Textwacher 三个回调 中after
        //afterTextChanged
        username.afterTextChanged {
            loginViewModel.loginDataChanged(
                username.text.toString(),
                password.text.toString()
            )
        }
        //pply函数扩展了所有的泛型对象,在闭包范围内可以任意调用该对象的任意方法,并在最后返回该对象.
        password.apply {
            afterTextChanged {
                loginViewModel.loginDataChanged(
                    username.text.toString(),
                    password.text.toString()
                )
            }
        //监听器
            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        loginViewModel.login(
                            username.text.toString(),
                            password.text.toString()
                        )
                }
                false
            }

            login.setTiggerClickListener {
                loginViewModel.login(username.text.toString(), password.text.toString())
            }
        }
    }

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading.visibility = View.GONE
    }
    override fun dataObserver() {
        super.dataObserver()
        quickObserve(loginViewModel.loginData){
            onSuccess {

                toast("登录成功")
            }
            onFailure {
                toast("$it")
            }
            onException {
                toast("${it?.message}")
            }
        }
    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome)
        val displayName = model.displayName
        // TODO : initiate successful logged in experience
        Toast.makeText(
            applicationContext,
            "$welcome $displayName",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }


}
/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
//Textview  3个回调方法
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}