package com.example.backerymanagment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.backerymanagment.Database.DatabaseHelper
import java.time.DateTimeException
import java.util.Calendar
import java.util.Date
import kotlin.time.Duration.Companion.days

class AddNewSaleActivity : AppCompatActivity() {

    private lateinit var txtAmount: EditText
    private lateinit var txtPrice: EditText
    private lateinit var txtCustomer: EditText
    private lateinit var txtDate: EditText

    private lateinit var btnSave: Button
    private lateinit var btnClear: Button

    private lateinit var databaseHelper: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_sale)

        txtAmount = findViewById(R.id.txt_amount)
        txtPrice = findViewById(R.id.txt_price)
        txtCustomer = findViewById(R.id.txt_customer)
        txtDate = findViewById(R.id.txt_date)

        btnSave = findViewById(R.id.btn_save)
        btnClear = findViewById(R.id.btn_clear)

        databaseHelper = DatabaseHelper(this)

        btnClear.setOnClickListener{
            txtAmount.text.clear()
            txtPrice.text.clear()
            txtDate.text.clear()
            txtCustomer.text.clear()
        }

        btnSave.setOnClickListener{
            val amount = txtAmount.text.toString()
            val price = txtPrice.text.toString()
            val date = txtDate.text.toString()
            val customer = txtCustomer.text.toString()
            val result = databaseHelper.inserNewSale(amount,price, date,customer)
            when
            {
                result-> Toast.makeText(applicationContext,"موفقانه اضافه شد", Toast.LENGTH_LONG).show()
                else ->  Toast.makeText(applicationContext,"اشتباه رخ داده است", Toast.LENGTH_LONG).show()
            }
        }
    }
}












