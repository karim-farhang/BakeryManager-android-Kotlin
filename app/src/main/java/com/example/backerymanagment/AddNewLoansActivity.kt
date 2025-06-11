package com.example.backerymanagment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.backerymanagment.Database.DatabaseHelper

class AddNewLoansActivity : AppCompatActivity() {


    private lateinit var txtCustomer: EditText
    private lateinit var txtAmount: EditText
    private lateinit var txtDate: EditText
    private lateinit var txtPhone: EditText
    private lateinit var txtDescription: EditText

    private lateinit var btnSave: Button
    private lateinit var btnClear: Button

    private lateinit var databaseHelper: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_loans)

        txtCustomer = findViewById(R.id.txt_customer)
        txtAmount = findViewById(R.id.txt_amount)
        txtDate = findViewById(R.id.txt_date)
        txtPhone = findViewById(R.id.txt_phone)
        txtDescription = findViewById(R.id.txt_description)
        btnSave = findViewById(R.id.btn_save)
        btnClear = findViewById(R.id.btn_clear)

        databaseHelper = DatabaseHelper(this)


        btnClear.setOnClickListener {
            txtCustomer.text.clear()
            txtAmount.text.clear()
            txtDate.text.clear()
            txtPhone.text.clear()
            txtDescription.text.clear()
        }

        btnSave.setOnClickListener {

            val name = txtCustomer.text.toString()
            val amount = txtAmount.text.toString()
            val date = txtDate.text.toString()
            val phone = txtPhone.text.toString()
            val description = txtDescription.text.toString()

            val result = databaseHelper.inserNewLoans(name, amount, date,phone, description)
            when{
                result-> Toast.makeText(applicationContext,"موفقانه حساب قرضه اضافه شد", Toast.LENGTH_LONG).show()
                else ->  Toast.makeText(applicationContext,"اشتباه رخ داده است", Toast.LENGTH_LONG).show()
            }
        }

    }
}