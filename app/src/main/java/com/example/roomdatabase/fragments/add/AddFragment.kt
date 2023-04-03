package com.example.roomdatabase.fragments.add

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomdatabase.R
import com.example.roomdatabase.data.User
import com.example.roomdatabase.data.UserViewModel
import com.example.roomdatabase.databinding.FragmentAddBinding


class AddFragment : Fragment() {

    private lateinit var bind: FragmentAddBinding
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bind = FragmentAddBinding.inflate(inflater, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        bind.buttonSaveDB.setOnClickListener{
            intsertDataToDatabase()
        }
        return bind.root
    }

    private fun intsertDataToDatabase() {
        val firstName = bind.addFirstNameEd.text.toString()
        val lastName = bind.addLastNameEd.text.toString()
        val age = bind.addAgeEd.text

        if(inputCheck(firstName, lastName, age)){
            val user = User(0, firstName, lastName, age.toString().toInt())
            mUserViewModel.addUser(user)

            Toast.makeText(requireContext(), "Запись $firstName добавлена в базу", Toast
                .LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Заполните все поля", Toast
                .LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return firstName.isNotEmpty() && lastName.isNotEmpty() && age.isNotEmpty()
    }
}