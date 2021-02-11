package com.workshopkotlin.myapplication.data.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.workshopkotlin.myapplication.data.entity.UserEntity

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: UserEntity) : Long

    @Query("SELECT * FROM users WHERE id_user=:idUser")
    fun getUser(idUser: Int) : UserEntity

    @Query("SELECT * FROM users WHERE email=:email AND password=:password LIMIT 1")
    fun doLogin(email: String, password: String) : MutableList<UserEntity>
}