package com.workshopkotlin.myapplication.data.entity

import android.arch.persistence.room.Embedded

class ProductUserPurchase {
    @Embedded
    lateinit var productEntity: ProductEntity
    @Embedded
    lateinit var userEntity: UserEntity
    @Embedded
    lateinit var purchaseEntity: PurchaseEntity
}