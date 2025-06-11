package com.example.backerymanagment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.backerymanagment.Database.DatabaseHelper

class ReportActivity : AppCompatActivity() {

    lateinit var totalAmountOfSale: TextView
    lateinit var totalAmountOfLoans :TextView
    lateinit var txtDate :EditText
    lateinit var btnAction:Button
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
        databaseHelper = DatabaseHelper(this)
        totalAmountOfSale = findViewById(R.id.txt_totalSale)
        totalAmountOfLoans = findViewById(R.id.txttotalLoans)
        btnAction = findViewById(R.id.btnExecute)
        txtDate = findViewById(R.id.txt_date)
        btnAction.setOnClickListener {

           // val date = txtDate.text.toString()
           // val bu:StringBuffer = databaseHelper.report(date)
           // totalAmountOfSale.setText(bu[0].toString())
           // totalAmountOfLoans.setText(bu[1].toString())
        }



    }
}