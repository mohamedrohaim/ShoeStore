package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import com.udacity.shoestore.databinding.FragmentLoginBinding


class instructionFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for instruction using DataBindingUtil
        val binding: FragmentInstructionBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_instruction,container,false
        )

        // on press next button action
        binding.instructionNextButton.setOnClickListener{
            // navigate to instruction fragment
            it.findNavController().navigate(R.id.action_instructionFragment_to_shoeListing2)
        }
        return binding.root
    }


}