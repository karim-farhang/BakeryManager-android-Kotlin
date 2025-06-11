package com.example.backerymanagment.Adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.backerymanagment.Database.DatabaseHelper
import com.example.backerymanagment.R
import com.example.backerymanagment.customerUpdateActivity


class customer_custom_list_adapter(

    private val myContext: Context,
    private val customListItem: ArrayList<customer_custom_list>
) : ArrayAdapter<customer_custom_list>(myContext, 0, customListItem) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listLayout = convertView
        val holder: ViewHolder
        if (listLayout == null) {
            val inflaterList = (myContext as Activity).layoutInflater
            listLayout = inflaterList.inflate(R.layout.customer_custom_list_view, parent, false)

            holder = ViewHolder()
            holder.txtName = listLayout!!.findViewById(R.id.customerCustomList_name)
            holder.txtAddress = listLayout.findViewById(R.id.customerCustomList_address)
            holder.txtPhone = listLayout.findViewById(R.id.customerCustomList_phone)
            holder.txtDate= listLayout.findViewById(R.id.customerCustomList_date)
            holder.txtDescription = listLayout.findViewById(R.id.customerCustomList_description)
            holder.btnDelete = listLayout.findViewById(R.id.customerCustomList_btn_delete)
            holder.btnUpdate = listLayout.findViewById(R.id.customerCustomList_btnUpdate)

            listLayout.setTag(holder)
        } else {
            holder = listLayout.getTag() as ViewHolder
        }

        val listItem = customListItem[position]
        holder.txtName!!.setText(listItem.name)
        holder.txtAddress!!.setText(listItem.address)
        holder.txtPhone!!.setText(listItem.phone)
        holder.txtDate!!.setText(listItem.date)
        holder.txtDescription!!.setText(listItem.description)
        holder.ID = listItem.id

        holder.btnDelete!!.setOnClickListener {
            val alert = AlertDialog.Builder(context as Activity)
            alert.setTitle("حذف کردن")
            alert.setIcon(R.mipmap.ic_launcher)
            alert.setMessage("آیا میخواهد حذف شود؟")
            alert.setCancelable(false)

            alert.setPositiveButton("بله") { _, _ ->
                // delete operation
                val db = DatabaseHelper(myContext)
                val result: Boolean = db.deleteCustomer(listItem.id.toString())
                when {
                    result -> {
                        Toast.makeText(myContext, "موفقانه حذف شد ", Toast.LENGTH_SHORT).show()
                    }
                    else -> Toast.makeText(myContext, " حذف نشد ", Toast.LENGTH_SHORT).show()
                }
            }
            alert.setNegativeButton("نخیر") { _, _ -> }
            val myAler = alert.create()
            myAler.show()
        }

        holder.btnUpdate!!.setOnClickListener {
            val band = Bundle()
            band.putInt("id",listItem.id)
            band.putString("name",listItem.name)
            band.putString("address",listItem.address)
            band.putString("phone",listItem.phone)
            band.putString("date",listItem.date)
            band.putString("desc",listItem.description)

            val intent = Intent(myContext,customerUpdateActivity::class.java)
            intent.putExtras(band)
            myContext.startActivity(intent)
        }
        return listLayout
    }
    class ViewHolder {
        internal var txtName: TextView? = null
        internal var txtAddress: TextView? = null
        internal var txtPhone: TextView? = null
        internal var txtDate: TextView? = null
        internal var txtDescription: TextView? = null
        internal var ID: Int? = 0
        internal var btnDelete: Button? = null
        internal var btnUpdate: Button? = null
    }
}

