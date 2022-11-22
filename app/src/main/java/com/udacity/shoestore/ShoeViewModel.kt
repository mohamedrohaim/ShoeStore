package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel :ViewModel(){

    //private shoe MutableList of Shoe with lifeData
    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    //initial method
    init {
        shoeListInitialization()
    }
    //public shoe list
     val shoeList: LiveData<MutableList<Shoe>>
         get() = _shoeList


    // function to add new item to the list
    // got add and plus fun  from stackOverflow
     fun addNewShoe(name:String,size:String,company:String,description:String) {
        _shoeList.value?.add(Shoe(name, size, company, description))
        //_shoeList.value!!.plus(Shoe(name,size,company,description))
    }

    // initial values as a demo
    private fun shoeListInitialization() {
        _shoeList.value=mutableListOf(
            Shoe("First shoe","18","adidas","sporty"),
            Shoe("second shoe","20","nike","basket sport"),
            Shoe("third shoe","25","SRS","normal shoe"),
            Shoe("fourth shoe","30","nike","basket sport"),
            Shoe("fifth shoe","14","nike","basket sport"),
            Shoe("shoe","23","nike","basket sport")
        )

    }

}