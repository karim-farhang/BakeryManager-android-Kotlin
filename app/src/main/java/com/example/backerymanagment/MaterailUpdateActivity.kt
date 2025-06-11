package com.example.backerymanagment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.backerymanagment.Database.DatabaseHelper

class MaterailUpdateActivity : AppCompatActivity() {

    lateinit var txtName: EditText
    lateinit var txtAmount: EditText
    lateinit var txtPrice: EditText
    lateinit var txtDate: EditText
    lateinit var txtDescription: EditText
    lateinit var btnUpdate: Button
    lateinit var btnClear: Button

    lateinit var bandle: Bundle
    lateinit var databaseHelper: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materail_update)


        txtName = findViewById(R.id.Update_name)
        txtAmount = findViewById(R.id.Update_amount)
        txtPrice = findViewById(R.id.Update_price)
        txtDate = findViewById(R.id.Update_date)
        txtDescription = findViewById(R.id.Update_description)

        btnUpdate = findViewById(R.id.Updatebtn_update)
        btnClear = findViewById(R.id.Updatebtn_clear)

        databaseHelper = DatabaseHelper(this)

        bandle = intent.extras!!

        txtName.setText(bandle.getCharSequence("name"))
        txtAmount.setText(bandle.getCharSequence("amount"))
        txtPrice.setText(bandle.getCharSequence("price"))
        txtDate.setText(bandle.getCharSequence("date"))
        txtDescription.setText(bandle.getCharSequence("desc"))

        btnUpdate.setOnClickListener {

            val id = bandle.getInt("id").toString()
            val name = txtName.text.toString()
            val amount = txtAmount.text.toString()
            val price = txtPrice.text.toString()
            val date = txtDate.text.toString()
            val desc = txtDescription.text.toString()

            val result: Boolean = databaseHelper.updateMaterial(id, name, amount, price, date, desc)
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















