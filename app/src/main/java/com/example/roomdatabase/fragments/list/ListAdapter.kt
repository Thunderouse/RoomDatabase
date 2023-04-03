package com.example.roomdatabase.fragments.list

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.R
import com.example.roomdatabase.data.User

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var userList = emptyList<User>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentUser = userList[position]
        val idTw = holder.itemView.findViewById<TextView>(R.id.idTw)
        val firstNameTw = holder.itemView.findViewById<TextView>(R.id.firsNameTw)
        val lastNameTw = holder.itemView.findViewById<TextView>(R.id.lastNameTw)
        val ageTw = holder.itemView.findViewById<TextView>(R.id.ageTw)
        val rowLayout = holder.itemView.findViewById<ConstraintLayout>(R.id.rowLayout)

        idTw.text = currentUser.id.toString()
        firstNameTw.text = currentUser.first_name
        lastNameTw.text = currentUser.last_name
        ageTw.text = currentUser.age.toString()

        rowLayout.setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentUser)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}