package com.workshopkotlin.myapplication.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.workshopkotlin.myapplication.data.dao.ProductDao
import com.workshopkotlin.myapplication.data.dao.PurchaseDao
import com.workshopkotlin.myapplication.data.dao.UserDao
import com.workshopkotlin.myapplication.data.entity.ProductEntity
import com.workshopkotlin.myapplication.data.entity.PurchaseEntity
import com.workshopkotlin.myapplication.data.entity.UserEntity

@Database(entities = [UserEntity::class, ProductEntity::class, PurchaseEntity::class], version = 1)
abstract class ecDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun productDao(): ProductDao

    abstract fun purchaseDao(): PurchaseDao

    companion object {
        @Volatile
        private var instances: ecDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instances ?: synchronized(LOCK) {
            instances ?: buildDatabase(context).also { instances = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ecDatabase::class.java, "ecommerce_database.db"
        ).fallbackToDestructiveMigration().setJournalMode(JournalMode.TRUNCATE).build()
    }
}