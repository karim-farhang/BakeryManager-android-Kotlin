package com.example.backerymanagment.Adapters


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import com.example.backerymanagment.R
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.backerymanagment.Database.DatabaseHelper
import com.example.backerymanagment.LoansUpdateActivity

class loans_custome_list_adapter(
    private val myContext: Context,
    private val customListItem: ArrayList<loans_custom_list>
) : ArrayAdapter<loans_custom_list>(myContext, 0, customListItem) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listLayout = convertView
        val holder: ViewHolder
        if (listLayout == null) {
            val inflaterList = (myContext as Activity).layoutInflater
            listLayout = inflaterList.inflate(R.layout.loans_custome_list_view, parent, false)

            holder = ViewHolder()
            holder.txtCustomer = listLayout!!.findViewById(R.id.loansCustomList_Customer)
            holder.txtAmount = listLayout.findViewById(R.id.loansCustomList_amount)
            holder.txtDate = listLayout.findViewById(R.id.loansCustomList_date)
            holder.txtPhoneNumber = listLayout.findViewById(R.id.loansCustomList_phoneNumber)
            holder.txtDescription = listLayout.findViewById(R.id.loansCustomList_description)
            holder.btnDelete = listLayout.findViewById(R.id.loansCustomList_btn_delete)
            holder.btnUpdate = listLayout.findViewById(R.id.loansCustomList_btnUpdate)

            listLayout.setTag(holder)
        } else {
            holder = listLayout.getTag() as ViewHolder
        }

        val listItem = customListItem[position]
        holder.txtCustomer!!.setText(listItem.customer)
        holder.txtAmount!!.setText(listItem.amount)
        holder.txtDate!!.setText(listItem.date)
        holder.txtPhoneNumber!!.setText(listItem.phoneNumber)
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
                val result: Boolean = db.deleteLoans(listItem.id.toString())
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
            band.putString("name",listItem.customer)
            band.putString("amount",listItem.amount)
            band.putString("date",listItem.date)
            band.putString("phone",listItem.phoneNumber)
            band.putString("desc",listItem.description)

            val intent = Intent(myContext,LoansUpdateActivity::class.java)
            intent.putExtras(band)
            myContext.startActivity(intent)

        }

        return listLayout
    }


    class ViewHolder {
        internal var txtCustomer: TextView? = null
        internal var txtAmount: TextView? = null
        internal var txtDate: TextView? = null
        internal var txtPhoneNumber: TextView? = null
        internal var txtDescription: TextView? = null
        internal var ID: Int? = 0
        internal var btnDelete: Button? = null
        internal var btnUpdate: Button? = null
    }
}

