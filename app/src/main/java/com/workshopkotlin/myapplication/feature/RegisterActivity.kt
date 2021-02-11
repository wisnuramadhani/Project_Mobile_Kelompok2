package com.workshopkotlin.myapplication.feature

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator
import com.workshopkotlin.myapplication.R
import com.workshopkotlin.myapplication.base.StatusCode
import com.workshopkotlin.myapplication.data.ecDatabase
import com.workshopkotlin.myapplication.data.entity.UserEntity
import com.workshopkotlin.myapplication.data.sharedpref.SharedprefUtil
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.*

class RegisterActivity : AppCompatActivity() {

    private val database: ecDatabase by lazy {
        ecDatabase.invoke(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        onClickListener()
    }

    private fun onClickListener() {
        btn_register.setOnClickListener {
            if (isValid()) {
                doRegisterProcess()
            }
        }

        tv_login.setOnClickListener {
            startActivity(intentFor<LoginActivity>().noHistory())
        }
    }

    private fun doRegisterProcess() {
        GlobalScope.launch {
            val userEntity = UserEntity(et_name.text.toString(), et_email.text.toString(), et_password.text.toString())
            var statusCodeResult: StatusCode
            try {
                val idUser = doRegister(userEntity)
                SharedprefUtil.idUser = idUser
                statusCodeResult = if (idUser > 0){
                    StatusCode.STATUS_OK
                }else{
                    StatusCode.STATUS_INVALID_INPUT
                }
            } catch (e: SQLiteConstraintException) {
                statusCodeResult = StatusCode.STATUS_BAD_REQUEST
            }

            launch(Dispatchers.Main) {
                when(statusCodeResult){
                    StatusCode.STATUS_OK -> {
                        storeDataUserLocally()
                        startActivity(intentFor<MainActivity>().newTask().clearTask())
                        toast("Berhasil register")
                    }
                    StatusCode.STATUS_BAD_REQUEST ->{
                        toast("Email sudah digunakan")
                    }
                    StatusCode.STATUS_INVALID_INPUT ->{
                        toast("Gagal register")
                    }
                    else -> {
                        toast("Gagal register")
                    }
                }
            }
        }
    }

    private fun storeDataUserLocally() {
        SharedprefUtil.emailUser = et_email.text.toString()
        SharedprefUtil.nameUser = et_name.text.toString()
        SharedprefUtil.isLoggin = true
    }

    private fun doRegister(userEntity: UserEntity): Long {
        return database.userDao().insertUser(userEntity)
    }

    private fun isValid(): Boolean {
        var valid = true

        et_password.validator()
            .nonEmpty()
            .minLength(6)
            .addErrorCallback {
                et_password.error = it
                valid = false
                et_password.requestFocus()
            }
            .check()

        et_email.validator()
            .nonEmpty()
            .validEmail()
            .addErrorCallback {
                et_email.error = it
                valid = false
                et_email.requestFocus()
            }
            .check()

        et_name.validator()
            .nonEmpty()
            .minLength(3)
            .noNumbers()
            .addErrorCallback {
                et_name.error = it
                valid = false
                et_name.requestFocus()
            }
            .check()


        return valid
    }
}
