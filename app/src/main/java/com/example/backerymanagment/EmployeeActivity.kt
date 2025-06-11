package com.example.backerymanagment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import com.example.backerymanagment.Adapters.employe_custom_list
import com.example.backerymanagment.Adapters.employe_custom_list_adapter
import com.example.backerymanagment.Database.DatabaseHelper

class EmployeeActivity : AppCompatActivity() {


    lateinit var listView: ListView
    lateinit var customData: ArrayList<employe_custom_list>
    lateinit var customeList: employe_custom_list_adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)
        listView = findViewById(R.id.employee_list_view)
        readData()
    }


    fun readData()
    {
        customData = ArrayList()
        customeList = employe_custom_list_adapter(this, customData)
        val db = DatabaseHelper(this)
        val data = db.readEmployee()
        if (data.count > 0)
        {
            while (data.moveToNext())
            {
                customData.add(employe_custom_list(data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5),data.getString(6),data.getString(7), data.getInt(0)))
            }
        }
        listView.adapter = customeList
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_new_employe, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_new_employe -> {
                startActivity(Intent(this@EmployeeActivity, AddNewEmployeeActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        readData()
    }
}