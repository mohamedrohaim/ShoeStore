package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import kotlinx.android.synthetic.main.fragment_instruction.view.*

class welcomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for  welcome fragment using DataBindingUtil
        val binding: FragmentWelcomeBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_welcome,container,false
        )
        binding.nextWelcomeButton.setOnClickListener{
            //navigate to instruction fragment
            it.findNavController().navigate(R.id.action_welcomeFragment_to_instructionFragment)
        }



        return binding.root
    }


}