package com.singhenterprises.mvvmexample.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.singhenterprises.mvvmexample.data.db.entities.CURRENT_USER_ID
import com.singhenterprises.mvvmexample.data.db.entities.User

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user: User) : Long

    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getUser() : LiveData<User>



}