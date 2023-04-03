package com.example.roomdatabase.fragments.update

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.roomdatabase.R
import com.example.roomdatabase.data.User
import com.example.roomdatabase.data.UserViewModel
import com.example.roomdatabase.databinding.FragmentUpdateBinding

class UpdateFragment : Fragment() {

    lateinit var bind: FragmentUpdateBinding
    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bind = FragmentUpdateBinding.inflate(inflater, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        bind.updateFirstNameEd.setText(args.currentUser.first_name)
        bind.updateLastNameEd.setText(args.currentUser.last_name)
        bind.updateAgeEd.setText(args.currentUser.age.toString())

        bind.buttonUpdateDB.setOnClickListener{
            updateItem()
        }

        return bind.root
    }

    private fun updateItem() {
        val firstName = bind.updateFirstNameEd.text.toString()
        val lastName = bind.updateLastNameEd.text.toString()
        val age = bind.updateAgeEd.text

        if(inputCheck(firstName, lastName, age)){
            val user = User(args.currentUser.id, firstName, lastName, age.toString().toInt())
            mUserViewModel.updateUser(user)
            Toast.makeText(requireContext(), "Запись $firstName успешно изменена", Toast
                .LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Заполните все поля", Toast
                .LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return firstName.isNotEmpty() && lastName.isNotEmpty() && age.isNotEmpty()
    }
}