package com.example.abhishek.archcomp.repository.database.Dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.abhishek.archcomp.repository.database.entity.StudentEntity

@Dao
interface StudentDao {

    @Query("SELECT * FROM students")
    fun getAllStudent():LiveData<List<StudentEntity>>

    @Insert
    fun insertData(student:StudentEntity)

}