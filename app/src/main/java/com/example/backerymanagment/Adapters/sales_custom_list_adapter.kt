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
import com.example.backerymanagment.updateSaleActivity

class sales_custom_list_adapter(

    private val myContext: Context,
    private val customListItem: ArrayList<sales_custom_list>
) : ArrayAdapter<sales_custom_list>(myContext, 0, customListItem) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listLayout = convertView
        val holder: ViewHolder
        if (listLayout == null) {
            val inflaterList = (myContext as Activity).layoutInflater
            listLayout = inflaterList.inflate(R.layout.sales_custom_list_view, parent, false)

            holder = ViewHolder()
            holder.txtAmount = listLayout!!.findViewById(R.id.saleCustomList_amount)
            holder.txtPrice = listLayout.findViewById(R.id.saleCustomList_price)
            holder.txtCustomer = listLayout.findViewById(R.id.saleCustomList_Customer)
            holder.txtDate= listLayout.findViewById(R.id.saleCustomList_date)
            holder.btnDelete = listLayout.findViewById(R.id.saleCustomList_btn_delete)
            holder.btnUpdate = listLayout.findViewById(R.id.saleCustomList_btnUpdate)
            listLayout.setTag(holder)

        } else {
            holder = listLayout.getTag() as ViewHolder
        }

        val listItem = customListItem[position]
        holder.txtAmount!!.setText(listItem.amount)
        holder.txtPrice!!.setText(listItem.price)
        holder.txtCustomer!!.setText(listItem.customer)
        holder.txtDate!!.setText(listItem.date)
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
                val result: Boolean = db.deleteSale(listItem.id.toString())
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
            band.putString("amount",listItem.amount)
            band.putString("price",listItem.price)
            band.putString("customer",listItem.customer)
            band.putString("date",listItem.date)

            val intent = Intent(myContext, updateSaleActivity::class.java)
            intent.putExtras(band)
            myContext.startActivity(intent)
        }
        return listLayout
    }
    class ViewHolder {
        internal var txtAmount: TextView? = null
        internal var txtPrice: TextView? = null
        internal var txtCustomer: TextView? = null
        internal var txtDate: TextView? = null
        internal var ID: Int? = 0
        internal var btnDelete: Button? = null
        internal var btnUpdate: Button? = null
    }
}

