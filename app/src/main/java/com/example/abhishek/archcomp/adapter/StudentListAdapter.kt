package com.example.abhishek.archcomp.adapter

import android.arch.lifecycle.LiveData
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.abhishek.archcomp.R
import com.example.abhishek.archcomp.repository.database.entity.StudentEntity

class StudentListAdapter(context: Context) : RecyclerView.Adapter<StudentListAdapter.ViewHolder>() {
    private var studentList:List<StudentEntity>? = null
    private var context:Context? = null


    init {

        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.student_item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(studentList==null){
            return 0
        }
        return studentList!!.size
    }

    fun setList(list: List<StudentEntity>){
        studentList = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var student:StudentEntity = studentList!![position]
        holder.nameTv.text = student.name
        holder.skillsTv.text = student.skills

    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var nameTv:TextView
        var skillsTv:TextView

        init {
            nameTv = itemView!!.findViewById(R.id.tv_name)
            skillsTv = itemView.findViewById(R.id.tv_skills)

        }
    }
}