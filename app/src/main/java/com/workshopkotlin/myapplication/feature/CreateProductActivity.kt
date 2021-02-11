package com.workshopkotlin.myapplication.feature

import android.database.sqlite.SQLiteException
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wajahatkarim3.easyvalidation.core.view_ktx.validator
import com.workshopkotlin.myapplication.R
import com.workshopkotlin.myapplication.data.ecDatabase
import com.workshopkotlin.myapplication.data.entity.ProductEntity
import com.workshopkotlin.myapplication.data.sharedpref.SharedprefUtil
import com.workshopkotlin.myapplication.utils.validator.MinValRule
import kotlinx.android.synthetic.main.activity_create_product.*
import kotlinx.android.synthetic.main.app_bar_create_product.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.toast

class CreateProductActivity : AppCompatActivity() {

    private val database: ecDatabase by lazy {
        ecDatabase(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_product)

        onClickListener()
    }

    private fun onClickListener() {
        iv_logo.setOnClickListener {
            finish()
        }

        btn_add.setOnClickListener {
            if (isValid()){
                doAddProductProcess()
            }
        }
    }

    private fun doAddProductProcess() {
        val product = ProductEntity(
            et_name_prouct.text.toString(),
            et_desc_product.text.toString(),
            et_price_product.text.toString(),
            et_stock.text.toString().toInt(),
            SharedprefUtil.idUser!!
        )

        doAsycAddProduct(product)
    }

    private fun doAsycAddProduct(product: ProductEntity) {
        GlobalScope.launch(Dispatchers.Main) {
            val isSuccess = withContext(Dispatchers.Default) {
                try {
                    addProductToDb(product)
                    return@withContext true
                }catch (e: SQLiteException){
                    e.printStackTrace()
                    return@withContext false
                }
            }

            if (isSuccess){
                toast("Berhasil menambah produk")
                finish()
            }else{
                toast("Gagal menambah produk")
            }
        }
    }

    private fun addProductToDb(product: ProductEntity){
        return database.productDao().insertProduct(product)
    }

    private fun isValid(): Boolean {
        var valid = true

        et_stock.validator()
            .nonEmpty()
            .onlyNumbers()
            .addRule(MinValRule(1))
            .addErrorCallback {
                et_stock.error = it
                et_stock.requestFocus()
                valid = false
            }
            .check()

        et_price_product.validator()
            .nonEmpty()
            .onlyNumbers()
            .addRule(MinValRule(5000))
            .addErrorCallback {
                et_price_product.error = it
                et_price_product.requestFocus()
                valid = false
            }
            .check()


        et_desc_product.validator()
            .nonEmpty()
            .minLength(10)
            .addErrorCallback {
                et_desc_product.error = it
                et_desc_product.requestFocus()
                valid = false
            }
            .check()

        et_name_prouct.validator()
            .nonEmpty()
            .minLength(5)
            .addErrorCallback {
                et_name_prouct.error = it
                et_name_prouct.requestFocus()
                valid = false
            }
            .check()

        return valid
    }
}
