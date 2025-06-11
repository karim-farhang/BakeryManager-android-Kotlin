package com.example.backerymanagment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.backerymanagment.Database.DatabaseHelper

class employeUpdateActivity : AppCompatActivity() {


    lateinit var txtName: EditText
    lateinit var txtAddress: EditText
    lateinit var txtPhone: EditText
    lateinit var txtDate: EditText
    lateinit var txtPosition:EditText
    lateinit var txtSalary:EditText
    lateinit var txtDescription: EditText
    lateinit var btnUpdate: Button
    lateinit var btnClear: Button

    lateinit var bandle: Bundle
    lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employe_update)

        txtName = findViewById(R.id.txt_name)
        txtAddress = findViewById(R.id.txt_address)
        txtPhone = findViewById(R.id.txt_phone)
        txtDate = findViewById(R.id.txt_date)
        txtPosition = findViewById(R.id.txt_position)
        txtSalary = findViewById(R.id.txt_salary)
        txtDescription = findViewById(R.id.txt_description)

        btnUpdate = findViewById(R.id.btn_save)
        btnClear = findViewById(R.id.btn_clear)

        databaseHelper = DatabaseHelper(this)

        bandle = intent.extras!!

        txtName.setText(bandle.getCharSequence("name"))
        txtAddress.setText(bandle.getCharSequence("address"))
        txtPhone.setText(bandle.getCharSequence("phone"))
        txtDate.setText(bandle.getCharSequence("date"))
        txtPosition.setText(bandle.getCharSequence("pos"))
        txtSalary.setText(bandle.getCharSequence("salary"))
        txtDescription.setText(bandle.getCharSequence("desc"))

        btnUpdate.setOnClickListener {

            val id = bandle.getInt("id").toString()
            val name = txtName.text.toString()
            val address = txtAddress.text.toString()
            val phone = txtPhone.text.toString()
            val date = txtDate.text.toString()
            val pos = txtPosition.text.toString()
            val salary = txtSalary.text.toString()
            val desc = txtDescription.text.toString()

            val result: Boolean = databaseHelper.updateEmployee(id, name, address,phone, date,pos,salary, desc)
            when
            {
                result -> Toast.makeText(applicationContext, "موفقانه به روز رسانی شد!", Toast.LENGTH_SHORT).show()
                else -> Toast.makeText(applicationContext, "بروز رسانی صورت نگرفت!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}