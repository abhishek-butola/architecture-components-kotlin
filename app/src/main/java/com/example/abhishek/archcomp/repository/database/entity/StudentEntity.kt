package com.example.abhishek.archcomp.repository.database.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "students")
data class StudentEntity (
                          var name:String,
                          var skills:String){

    @PrimaryKey(autoGenerate = true)var id:Long = 0
}