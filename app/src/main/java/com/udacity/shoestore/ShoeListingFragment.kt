package com.udacity.shoestore


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListingBinding

import kotlinx.android.synthetic.main.shoe_item.view.*

class ShoeListingFragment:Fragment() {


    // take reference to ShoeViewModel
    private lateinit var viewModel: ShoeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        // Inflate the layout for shoeShoeListing fragment
        val binding: FragmentShoeListingBinding = DataBindingUtil.inflate(
            inflater,R.layout.fragment_shoe_listing,container,false
        )




        // define the linearlayout to access it and add new View
        val layout: LinearLayout = binding.shoeLinearLayout
        //initialize viewModel
        viewModel=ViewModelProvider(this).get(ShoeViewModel::class.java)

        // observe the list and loop its item's (shoe obj)
        viewModel.shoeList.observe(viewLifecycleOwner,Observer{

            // way of in 0 until .size -->got from geeksForGeeks
            for (i in 0 until it.size) {

                // initialize the shoeItem i will add shoe and display at linearLayout
                var shoeItem:View= inflater?.inflate(R.layout.shoe_item, null)
                // set shoe textViews Values
                shoeItem.shoeName.text=it[i].name
                shoeItem.shoeSize.text=it[i].size
                shoeItem.sheCompany.text=it[i].company
                shoeItem.shoeDescription.text=it[i].description
                // add shoeItem(the view contain shoe data) to linear layout
                layout.addView(shoeItem)
            }


        })


        //on press floating action button -> navigate to add new shoe(detailsFragment)
        binding.addNewShoeFloatingActionButton.setOnClickListener(){
            it.findNavController().navigate(R.id.action_shoeListing2_to_addNewShoeFragment)

        }
        // show the menu -> from udacity course
        setHasOptionsMenu(true)
        return binding.root
    }

    // inflate the menu and pass it's element(logout)  ->from udacity course
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu,menu)
    }

    // on item menu selected --> from developer.android.com
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            // when press on about item navigate to login fragment
            R.id.logout->
                view?.findNavController()?.navigate(R.id.action_shoeListing2_to_loginFragment22)
        }
        return true
    }


}




