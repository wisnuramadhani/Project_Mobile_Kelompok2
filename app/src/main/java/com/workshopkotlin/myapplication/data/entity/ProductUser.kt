package com.workshopkotlin.myapplication.data.entity

import android.arch.persistence.room.Embedded
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ProductUser : Parcelable {
    @Embedded
    lateinit var userEntity: UserEntity
    @Embedded
    lateinit var productEntity: ProductEntity
}