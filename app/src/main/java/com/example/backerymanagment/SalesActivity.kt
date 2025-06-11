package com.example.backerymanagment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import com.example.backerymanagment.Adapters.customer_custom_list
import com.example.backerymanagment.Adapters.customer_custom_list_adapter
import com.example.backerymanagment.Adapters.sales_custom_list
import com.example.backerymanagment.Adapters.sales_custom_list_adapter
import com.example.backerymanagment.Database.DatabaseHelper

class SalesActivity : AppCompatActivity() {


    lateinit var listView: ListView
    lateinit var customData: ArrayList<sales_custom_list>
    lateinit var customeList: sales_custom_list_adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sales)

        listView = findViewById(R.id.sale_list_view)
        readData()
    }


    fun readData()
    {
        customData = ArrayList()
        customeList = sales_custom_list_adapter(this, customData)
        val db = DatabaseHelper(this)
        val data = db.readSales()
        if (data.count > 0)
        {
            while (data.moveToNext())
            {
                customData.add(sales_custom_list(data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getInt(0)))
            }
        }
        listView.adapter = customeList
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_new_sales, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_new_sales -> {
                startActivity(Intent(this@SalesActivity, AddNewSaleActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        readData()
    }
}