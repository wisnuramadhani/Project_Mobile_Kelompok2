package com.workshopkotlin.myapplication.data.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "users", indices = [Index(value = ["email"], unique = true)])
@Parcelize
data class UserEntity(
    @ColumnInfo(name = "name") var name: String? = null,
    @ColumnInfo(name = "email") var email: String? = null,
    @ColumnInfo(name = "password") var password: String? = null
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_user")
    var id: Long? = null
}