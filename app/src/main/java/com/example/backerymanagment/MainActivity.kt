package com.example.backerymanagment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnMaterial: Button
    private lateinit var btnLoans: Button
    private lateinit var btnEmployee: Button
    private lateinit var btnSales:Button
    private lateinit var btnReport: Button
    private lateinit var btnCustomer: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMaterial = findViewById(R.id.btnMaterial)
        btnLoans = findViewById(R.id.btnLoans)
        btnEmployee = findViewById(R.id.btnEmployee)
        btnReport = findViewById(R.id.btnReport)
        btnCustomer = findViewById(R.id.btnCustomer)
        btnSales = findViewById(R.id.btnSale)


        btnMaterial.setOnClickListener {
            startActivity(Intent(this@MainActivity, MatiralActivity::class.java))
        }


        btnLoans.setOnClickListener {
            startActivity(Intent(this@MainActivity, LoansActivity::class.java))
        }


        btnEmployee.setOnClickListener {
            startActivity(Intent(this@MainActivity, EmployeeActivity::class.java))
        }


        btnReport.setOnClickListener {
           // startActivity(Intent(this@MainActivity, ReportActivity::class.java))
        }


        btnCustomer.setOnClickListener {
            startActivity(Intent(this@MainActivity, CustomerActivity::class.java))
        }

        btnSales.setOnClickListener {
            startActivity(Intent(this@MainActivity,SalesActivity::class.java))
        }

    }
}