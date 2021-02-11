package com.workshopkotlin.myapplication.adapter

import com.workshopkotlin.myapplication.data.entity.ProductUser

interface ProductAdapterListener {

    fun onClickItemProduct(productEntity: ProductUser)
}