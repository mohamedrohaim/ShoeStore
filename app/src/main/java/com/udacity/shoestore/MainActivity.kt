package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)


        // my host fragment to host other fragments ->form udacity course
        val navController=this.findNavController(R.id.HostFragment)
        //show ActionBar with nacController to navigate back
         NavigationUI.setupActionBarWithNavController(this,navController)


    }



    // this 2 override function i learned from weekly session with session lead @Ahmed Mubarak- Android - Session Lead
    // fun to control arrow back button
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.HostFragment)
        NavigationUI.setupActionBarWithNavController(this,navController)
        // current destination is shoe list -->not to go back
        if (navController.currentDestination?.id == R.layout.fragment_shoe_listing) {
            // prevent go back from arrow
            finish()
            return true
        }

        //allow go back
        return navController.navigateUp()
    }
    // control navigate back from backButton
    override fun onBackPressed() {
        val navController = this.findNavController(R.id.HostFragment)
        if (navController.currentDestination?.id == R.layout.fragment_shoe_listing) {
            // prevent go back from backButton
            finish()
            return
        }
        //allow go back
        return super.onBackPressed()
    }

}
