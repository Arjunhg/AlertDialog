package com.example.alertdialouge
/* It's one of the 4 types of dialogue box*/

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.alertdialouge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            //We will make a builder of alert dialogue
            val builder1 = AlertDialog.Builder(this) //AlertDialog is a class in android studios

            builder1.setTitle("Are you sure?")

            builder1.setMessage("Do you want to close the App?")

            //Now we will use vector asset to get symbol
            builder1.setIcon(R.drawable.baseline_exit_to_app_24)

            builder1.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i ->
                // What action should be performed when Yes is clicked?
                finish()
            })

            builder1.setNegativeButton("No",DialogInterface.OnClickListener { dialogInterface, i ->
               // What action should be performed when No is clicked?
            })

            builder1.show()
        }

        binding.btn2.setOnClickListener {
            val options  = arrayOf("Gulab Jamun", "Rasmallai", "Kaju Katli") //To make multiple option dialog box we use array and arrayOf is builtin function for using array
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which is Your Favourite Sweet?")

            //Now we will give option
            builder2.setSingleChoiceItems(options, 0, DialogInterface.OnClickListener { dialogInterface, which ->
                //What action should be performed when user clicks on any options
                Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT).show() //Use $ sign when you want to use code part(variable, function etc) inside string
            } )

            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                // What action should be performed when Yes is clicked?
            })

            builder2.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                // What action should be performed when No is clicked?
            })

            builder2.show()
        }

        binding.btn3.setOnClickListener {
            val options  = arrayOf("Gulab Jamun", "Rasmallai", "Kaju Katli") //To make multiple option dialog box we use array and arrayOf is builtin function for using array
            val builder2 = AlertDialog.Builder(this) //In same method you can't make builder2 again but in different you can
            builder2.setTitle("Which is Your Favourite Sweet?")

            //Now we will give option
            builder2.setMultiChoiceItems(options, null, DialogInterface.OnMultiChoiceClickListener { dialogInterface, which, b ->
                Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT).show() //Use $ sign when you want to use code part(variable, function etc) inside string

            })

            builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->
                // What action should be performed when Yes is clicked?
            })

            builder2.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                // What action should be performed when No is clicked?
            })

            builder2.show()
        }
    }
}