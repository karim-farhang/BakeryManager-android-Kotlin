package com.example.backerymanagment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import com.example.backerymanagment.Adapters.materail_custom_list
import com.example.backerymanagment.Adapters.materail_custom_list_adapter
import com.example.backerymanagment.Database.DatabaseHelper
import com.example.backerymanagment.R.*

class MatiralActivity : AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var customData: ArrayList<materail_custom_list>
    lateinit var customeList: materail_custom_list_adapter


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_matiral)


        listView = findViewById(id.list_view)
        readData()


    }

    fun readData()
    {
        customData = ArrayList()
        customeList = materail_custom_list_adapter(this, customData)
        val db = DatabaseHelper(this)
        val data = db.readMaterial()
        if (data.count > 0)
        {
            while (data.moveToNext())
            {
                customData.add(materail_custom_list(data.getString(1), data.getString(2), data.getString(3), data.getString(4), data.getString(5), data.getInt(0)))
            }
        }
        listView.adapter = customeList
    }


    override fun onResume() {
        super.onResume()
        readData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_new_matireal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            id.add_new -> {
                startActivity(Intent(this@MatiralActivity, AddNewMaterialActivety::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        readData()
    }
}

