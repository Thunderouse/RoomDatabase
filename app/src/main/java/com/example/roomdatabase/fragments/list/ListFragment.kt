package com.example.roomdatabase.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase.R
import com.example.roomdatabase.data.UserViewModel
import com.example.roomdatabase.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var bind: FragmentListBinding
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bind = FragmentListBinding.inflate(inflater, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val adapter = ListAdapter()
        val recyclerView = bind.recyclerview
        recyclerView.adapter= adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
         mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer {
                 listuser->
             adapter.setData(listuser)
         })

        bind.addDataToDB.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return bind.root
    }
}