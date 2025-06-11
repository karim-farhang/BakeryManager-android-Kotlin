package com.example.backerymanagment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.backerymanagment.Database.DatabaseHelper


class AddNewMaterialActivety : AppCompatActivity() {

    private lateinit var txtName: EditText
    private lateinit var txtAmount: EditText
    private lateinit var txtPrice: EditText
    private lateinit var txtDate: EditText
    private lateinit var txtDescription: EditText

    private lateinit var btnSave: Button
    private lateinit var btnClear: Button

    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_material_activiey)

        txtName = findViewById(R.id.txt_name)
        txtAmount = findViewById(R.id.txt_amount)
        txtPrice = findViewById(R.id.txt_price)
        txtDate = findViewById(R.id.txt_date)
        txtDescription = findViewById(R.id.txt_description)
        btnSave = findViewById(R.id.btn_save)
        btnClear = findViewById(R.id.btn_clear)

        databaseHelper = DatabaseHelper(this)


        btnClear.setOnClickListener {
            txtName.text.clear()
            txtAmount.text.clear()
            txtPrice.text.clear()
            txtDate.text.clear()
            txtDescription.text.clear()
        }

        btnSave.setOnClickListener {

            val name = txtName.text.toString()
            val amount = txtAmount.text.toString()
            val price = txtPrice.text.toString()
            val date = txtDate.text.toString()
            val description = txtDescription.text.toString()

            val result = databaseHelper.inserNewMaterial(name, amount, price, date, description)
            when{
                result->Toast.makeText(applicationContext,"Data Inserted Successfully...",Toast.LENGTH_LONG).show()
                else ->  Toast.makeText(applicationContext,"Same thing is wrong...",Toast.LENGTH_LONG).show()
            }
        }





    }
}






