package com.example.backerymanagment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.backerymanagment.Database.DatabaseHelper

class LoansUpdateActivity : AppCompatActivity() {

    lateinit var txtCustomer: EditText
    lateinit var txtAmount: EditText
    lateinit var txtDate: EditText
    lateinit var txtPhoneNumber: EditText
    lateinit var txtDescription: EditText
    lateinit var btnUpdate: Button
    lateinit var btnClear: Button

    lateinit var bandle: Bundle
    lateinit var databaseHelper: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loans_update)

        txtCustomer = findViewById(R.id.Update_Customer)
        txtAmount = findViewById(R.id.Update_amount)
        txtDate = findViewById(R.id.Update_date)
        txtPhoneNumber = findViewById(R.id.Update_phoneUumber)
        txtDescription = findViewById(R.id.Update_description)

        btnUpdate = findViewById(R.id.Updatebtn_update)
        btnClear = findViewById(R.id.Updatebtn_clear)

        databaseHelper = DatabaseHelper(this)

        bandle = intent.extras!!

        txtCustomer.setText(bandle.getCharSequence("name"))
        txtAmount.setText(bandle.getCharSequence("amount"))
        txtDate.setText(bandle.getCharSequence("date"))
        txtPhoneNumber.setText(bandle.getCharSequence("phone"))
        txtDescription.setText(bandle.getCharSequence("desc"))

        btnUpdate.setOnClickListener {

            val id = bandle.getInt("id").toString()
            val name = txtCustomer.text.toString()
            val amount = txtAmount.text.toString()
            val date = txtDate.text.toString()
            val phone = txtPhoneNumber.text.toString()
            val desc = txtDescription.text.toString()

            val result: Boolean = databaseHelper.updateLoans(id, name, amount, date, phone, desc)
            when {
                result -> Toast.makeText(
                    applicationContext,
                    "موفقانه به روز رسانی شد!",
                    Toast.LENGTH_SHORT
                ).show()
                else -> Toast.makeText(
                    applicationContext,
                    "بروز رسانی صورت نگرفت!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}