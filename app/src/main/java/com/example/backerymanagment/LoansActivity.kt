package com.example.backerymanagment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import com.example.backerymanagment.Adapters.loans_custom_list
import com.example.backerymanagment.Adapters.loans_custome_list_adapter
import com.example.backerymanagment.Adapters.materail_custom_list
import com.example.backerymanagment.Adapters.materail_custom_list_adapter
import com.example.backerymanagment.Database.DatabaseHelper

class LoansActivity : AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var customData: ArrayList<loans_custom_list>
    lateinit var customeList: loans_custome_list_adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loans)

        listView = findViewById(R.id.loans_list_view)
        readData()
    }


    fun readData()
    {
        customData = ArrayList()
        customeList = loans_custome_list_adapter(this, customData)
        val db = DatabaseHelper(this)
        val data = db.readLoans()
        if (data.count > 0)
        {
            while (data.moveToNext())
            {
                customData.add(loans_custom_list(data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5), data.getInt(0)))
            }
        }
        listView.adapter = customeList
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_new_loans, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_new_loans -> {
                startActivity(Intent(this@LoansActivity, AddNewLoansActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        readData()
    }
}