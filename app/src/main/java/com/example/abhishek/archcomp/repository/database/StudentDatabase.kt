package com.example.abhishek.archcomp.repository.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.abhishek.archcomp.repository.database.Dao.StudentDao
import com.example.abhishek.archcomp.repository.database.entity.StudentEntity

@Database(entities = arrayOf(StudentEntity::class), version = 1)
abstract class StudentDatabase:RoomDatabase(){

    abstract fun studentDao():StudentDao

    companion object {
        private var INSTANCE: StudentDatabase? = null

        fun getDatabase(c:Context): StudentDatabase {
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(c.applicationContext, StudentDatabase::class.java, "student_database")
                        .build()

            }

            return INSTANCE!!
        }

        fun destroyInstance(){
            INSTANCE = null
        }

    }
}
