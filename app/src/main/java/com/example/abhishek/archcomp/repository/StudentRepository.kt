package com.example.abhishek.archcomp.repository

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.example.abhishek.archcomp.repository.database.Dao.StudentDao
import com.example.abhishek.archcomp.repository.database.StudentDatabase
import com.example.abhishek.archcomp.repository.database.entity.StudentEntity

class StudentRepository(application: Application) {

    private var studentDao:StudentDao? = null
    private var studentList: LiveData<List<StudentEntity>>? = null

    init {
        var db:StudentDatabase = StudentDatabase.getDatabase(application)
        this.studentDao = db.studentDao()
        this.studentList = studentDao?.getAllStudent()
    }

    fun getStudentList():LiveData<List<StudentEntity>>{
        return studentList!!
    }

    fun insertStudent(student: StudentEntity){
        InsertAsyncTask(studentDao!!).execute(student)

    }

     class InsertAsyncTask(dao: StudentDao) : AsyncTask<StudentEntity, Void, Void>() {
         var asyncStudentDao: StudentDao? =null
         init {
              asyncStudentDao = dao
         }

        override fun doInBackground(vararg params: StudentEntity?): Void? {
            asyncStudentDao?.insertData(params[0]!!)
            return null;
        }

    }


}