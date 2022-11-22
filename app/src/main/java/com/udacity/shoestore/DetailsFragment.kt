package com.udacity.shoestore
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentAddNewShoeBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.shoe_item.*


class DetailsFragment : Fragment() {
    private  val TAG = "MyActivity"
    private var  shoe: Shoe? = null
    private var  name: String?=null
    private var  size: String?=null
     private var  company: String?=null
     private var  description: String?=null
    private lateinit var viewModel: ShoeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // inflate details( add new shoe ) fragment using DataBindingUtil
        val binding:FragmentAddNewShoeBinding =DataBindingUtil.inflate(
            inflater,R.layout.fragment_add_new_shoe,container,false
        )
        // add listener to name EditText to save changes and save it's value in name var
        binding.shoeNameEditText.addTextChangedListener {
            name=binding.shoeNameEditText.text.toString()

        }
        // add listener to size EditText to save changes and save it's value in size var
        binding.shoeSizeEditText.addTextChangedListener {
            size=binding.shoeSizeEditText.text.toString()

        }
        // add listener to company EditText to save changes and save it's value in company var
        binding.shoeCompanyEditText.addTextChangedListener {
            company=binding.shoeCompanyEditText.text.toString()

        }
        // add listener to description EditText to save changes and save it's value in description var
        binding.shoeDescriptionEditText.addTextChangedListener {
            description=binding.shoeDescriptionEditText.text.toString()

        }

        viewModel= ViewModelProvider(this).get(ShoeViewModel::class.java)
        binding.saveButton.setOnClickListener{ saveButton->
            // on press save all data in editTexts will be as object of shoe
            shoe=Shoe(name.toString(),size.toString(),company.toString(),description.toString())
            // binding.show ---> to get data field edit text fields using she variable in <data> element
           /*   var shoe:Shoe= binding.shoe
              name= shoe?.name.toString()
              size = shoe?.size.toString()
              company = shoe?.company.toString()
              description= shoe?.description.toString()*/


            // shoe values of all fields in logcat
            Log.i(TAG, "$shoe")
            Log.i(TAG, "${shoe?.name}")
            Log.i(TAG, "${shoe?.size}")
            Log.i(TAG, "${shoe?.company}")
            Log.i(TAG, "${shoe?.description}")


            // add the object to shoe list in viewModel
            if (shoe!=null){
                // call addNew fun to add new shoe to list
                viewModel.addNewShoe(name.toString(),size.toString(),company.toString(),description.toString())
                saveButton.findNavController().navigate(R.id.action_addNewShoeFragment_to_shoeListing2)

             }else{
              saveButton.findNavController().navigate(R.id.action_addNewShoeFragment_to_shoeListing2)

            }

        }

        // cancel button on pressed
        binding.cancelButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_addNewShoeFragment_to_shoeListing2)
        }

        return binding.root
    }



}