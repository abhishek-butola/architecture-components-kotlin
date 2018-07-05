package com.example.abhishek.archcomp.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.abhishek.archcomp.repository.StudentRepository
import com.example.abhishek.archcomp.repository.database.entity.StudentEntity

class StudentViewModel(application: Application) : AndroidViewModel(application) {

    private var studentRepository:StudentRepository? = null
    private var studentList:LiveData<List<StudentEntity>>? = null

    init {
        studentRepository = StudentRepository(application)
        studentList = studentRepository?.getStudentList()
    }

    fun getStudentList():LiveData<List<StudentEntity>>{
        return studentList!!
    }

    fun insertStudent(studentEntity: StudentEntity){
        studentRepository?.insertStudent(studentEntity)
    }
}