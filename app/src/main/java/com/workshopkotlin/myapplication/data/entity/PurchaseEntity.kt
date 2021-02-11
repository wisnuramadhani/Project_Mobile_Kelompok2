package com.workshopkotlin.myapplication.data.entity

import android.arch.persistence.room.*

@Entity(
    tableName = "purchase",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id_user"],
            childColumns = ["id_user_pembelian"]
        ),
        ForeignKey(
            entity = ProductEntity::class,
            parentColumns = ["id_produk"],
            childColumns = ["id_produk_pembelian"]
        )
    ],
    indices = [Index(
        value = ["id_pembelian"],
        unique = true
    ), Index(value = ["id_user_pembelian"]), Index(value = ["id_produk_pembelian"])]
)
data class PurchaseEntity(
    @ColumnInfo(name = "id_user_pembelian") var idUser: Long? = null,
    @ColumnInfo(name = "id_produk_pembelian") var idProduct: Long? = null,
    @ColumnInfo(name = "shipping_address_pembelian") var shippingAddress: String? = null
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_pembelian")
    var id: Long? = null
}