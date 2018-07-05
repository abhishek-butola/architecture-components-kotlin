package com.example.abhishek.archcomp.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.abhishek.archcomp.R
import com.example.abhishek.archcomp.R.id.*
import com.example.abhishek.archcomp.adapter.StudentListAdapter
import com.example.abhishek.archcomp.repository.database.entity.StudentEntity
import com.example.abhishek.archcomp.viewmodel.StudentViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter:StudentListAdapter

    private lateinit var viewModel:StudentViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(StudentViewModel::class.java)

        recyclerView = findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = StudentListAdapter(this)

        recyclerView.adapter = adapter

        viewModel.getStudentList().observe(this, Observer {
            adapter.setList(it!!)
        })


        btn_add.setOnClickListener {

            var name:String = et_name.text.toString()
            var skills: String = et_skills.text.toString()
            var student = StudentEntity(name, skills)
            viewModel.insertStudent(student)
        }
    }
}
