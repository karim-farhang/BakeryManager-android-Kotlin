package com.example.backerymanagment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.backerymanagment.Database.DatabaseHelper

class AddNewCustomerActivity : AppCompatActivity() {

    private lateinit var txtName: EditText
    private lateinit var txtAddress: EditText
    private lateinit var txtPhone: EditText
    private lateinit var txtDate: EditText
    private lateinit var txtDescription: EditText

    private lateinit var btnSave: Button
    private lateinit var btnClear: Button

    private lateinit var databaseHelper: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_customer)

        txtName = findViewById(R.id.txt_name)
        txtAddress = findViewById(R.id.txt_address)
        txtPhone = findViewById(R.id.txt_phone)
        txtDate = findViewById(R.id.txt_date)
        txtDescription = findViewById(R.id.txt_description)
        btnSave = findViewById(R.id.btn_save)
        btnClear = findViewById(R.id.btn_clear)

        databaseHelper = DatabaseHelper(this)

        btnClear.setOnClickListener{
            txtName.text.clear()
            txtAddress.text.clear()
            txtDate.text.clear()
            txtPhone.text.clear()
            txtDescription.text.clear()
        }

        btnSave.setOnClickListener{
            val name = txtName.text.toString()
            val address = txtAddress.text.toString()
            val date = txtDate.text.toString()
            val phone = txtPhone.text.toString()
            val description = txtDescription.text.toString()
            val result = databaseHelper.inserNewCustomer(name, address, phone,date, description)
            when
            {
                result-> Toast.makeText(applicationContext,"موفقانه حساب قرضه اضافه شد", Toast.LENGTH_LONG).show()
                else ->  Toast.makeText(applicationContext,"اشتباه رخ داده است", Toast.LENGTH_LONG).show()
            }
        }
    }
}