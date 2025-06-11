package com.example.backerymanagment.Database

import android.provider.BaseColumns

object DatabaseContainer {

    class MaterialTable : BaseColumns
    {
        companion object
        {
            val tableName = "Material"
            val columnName = "Name"
            val columnAmount = "Amount"
            val columnPrice = "Price"
            val columnDate = "Date"
            val columnDescription = "Description"
        }
    }

    class LoansTable:BaseColumns
    {
        companion object
        {
            val tableName= "Loans"
            val columnsCustomer = "Customer"
            val columnsAmount = "Amount"
            val columnsDate = "Date"
            val columnsPhoneNumber = "Phone"
            val columnsDescription = "Description"
        }
    }



    class CustomerTable:BaseColumns
    {
        companion object
        {
            val tableName= "Customer"
            val columnName = "Name"
            val columnAddress = "Adderss"
            val columnsPhone = "Phone"
            val columnsDate = "Date"
            val columnsDescription = "Description"
        }
    }



    class EmployeeTable:BaseColumns
    {
        companion object
        {
            val tableName= "Employee"
            val columnName = "Name"
            val columnAddress = "Adderss"
            val columnsPhone = "Phone"
            val columnsDate = "Date"
            val columnsPosition = "Position"
            val columnsSalary = "Salary"
            val columnsDescription = "Description"
        }
    }


    class SalesTable:BaseColumns
    {
        companion object
        {
            val tableName = "Sales"
            val columnsAmount =  "Amount"
            val columnsPrice =  "Price"
            val columnsCustomer = "Customer"
            val columnsDate =  "Date"
        }
    }

}