package com.example.backerymanagment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.backerymanagment.Database.DatabaseHelper
import java.util.Calendar

class updateSaleActivity : AppCompatActivity() {


    lateinit var txtAmount: EditText
    lateinit var txtPrice: EditText
    lateinit var txtCustomer: EditText
    lateinit var txtDate: EditText

    lateinit var btnUpdate: Button
    lateinit var btnClear: Button

    lateinit var bandle: Bundle
    lateinit var databaseHelper: DatabaseHelper



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_sale)

        txtAmount = findViewById(R.id.txt_amount)
        txtPrice = findViewById(R.id.txt_price)
        txtCustomer = findViewById(R.id.txt_customer)
        txtDate = findViewById(R.id.txt_date)

        btnUpdate = findViewById(R.id.btn_save)
        btnClear = findViewById(R.id.btn_clear)

        databaseHelper = DatabaseHelper(this)

        bandle = intent.extras!!

        txtAmount.setText(bandle.getCharSequence("amount"))
        txtPrice.setText(bandle.getCharSequence("price"))
        txtCustomer.setText(bandle.getCharSequence("customer"))
        txtDate.setText(bandle.getCharSequence("date"))


        btnUpdate.setOnClickListener {

            val id = bandle.getInt("id").toString()
            val amount = txtAmount.text.toString()
            val price = txtPrice.text.toString()
            val cutomer = txtCustomer.text.toString()
            val date = txtDate.text.toString()

            val result: Boolean = databaseHelper.updateSale(id, amount,price,cutomer, date)
            when
            {
                result -> Toast.makeText(applicationContext, "موفقانه به روز رسانی شد!", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(applicationContext, "بروز رسانی صورت نگرفت!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

















