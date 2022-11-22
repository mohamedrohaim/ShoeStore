package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

class loginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //// // Inflate the layout for login using DataBindingUtil
        val binding:FragmentLoginBinding=DataBindingUtil.inflate(
            inflater,R.layout.fragment_login,container,false
        )
        // login button on press action
        binding.loginButton.setOnClickListener{
            //navigate to welcome Fragment
            it.findNavController().navigate(R.id.action_loginFragment2_to_welcomeFragment)

        }
        //new login button on press action
        binding.newLoginButton.setOnClickListener{
            //navigate to welcome Fragment
            it.findNavController().navigate(R.id.action_loginFragment2_to_welcomeFragment)

        }




        return binding.root
    }


}