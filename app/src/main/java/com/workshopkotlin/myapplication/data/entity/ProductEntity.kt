package com.workshopkotlin.myapplication.data.entity

import android.arch.persistence.room.*
import android.arch.persistence.room.ForeignKey.CASCADE
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Entity(
    tableName = "produk",
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = ["id_user"],
        childColumns = ["id_owner"],
        onDelete = CASCADE
    )],
    indices = [
        Index(value = ["id_owner"])
    ]
)
@Parcelize
data class ProductEntity(
    @ColumnInfo(name = "nama_produk") var namaProduk: String? = null,
    @ColumnInfo(name = "deskripsi_produk") var deskpripsiProduk: String? = null,
    @ColumnInfo(name = "harga_produk") var hargaProduk: String? = null,
    @ColumnInfo(name = "stok_produk") var stokProduk: Int? = null,
    @ColumnInfo(name = "id_owner") var idUser: Long? = null
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_produk")
    var idProduk: Long? = null
}