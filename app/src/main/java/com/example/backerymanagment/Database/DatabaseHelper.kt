package com.example.backerymanagment.Database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.util.Log
import com.example.backerymanagment.Database.DatabaseContainer.MaterialTable
import com.example.backerymanagment.Database.DatabaseContainer.LoansTable
import com.example.backerymanagment.Database.DatabaseContainer.CustomerTable
import com.example.backerymanagment.Database.DatabaseContainer.EmployeeTable
import com.example.backerymanagment.Database.DatabaseContainer.SalesTable


class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, databaseName, null, databaseVersion) {

    companion object {
        private const val databaseName = "DB.db"
        private const val databaseVersion = 1
    }

    override fun onCreate(p0: SQLiteDatabase?) {

        val CreateTableMaterail =
            "CREATE TABLE " + MaterialTable.tableName + "(" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + MaterialTable.columnName + " TEXT, " + MaterialTable.columnAmount + " TEXT, " + MaterialTable.columnPrice + " TEXT, " + MaterialTable.columnDate + " TEXT, " + MaterialTable.columnDescription + " TEXT);"
        val CreateTableLoans =
            "CREATE TABLE " + LoansTable.tableName + "(" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + LoansTable.columnsCustomer + " TEXT, " + LoansTable.columnsAmount + " TEXT, " + LoansTable.columnsDate + " TEXT, " + LoansTable.columnsPhoneNumber + " TEXT, " + LoansTable.columnsDescription + " TEXT);"
        val CreateTableCustomer =
            "CREATE TABLE " + CustomerTable.tableName + "(" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + CustomerTable.columnName + " TEXT, " + CustomerTable.columnAddress + " TEXT, " + CustomerTable.columnsPhone + " TEXT, " + CustomerTable.columnsDate + " TEXT, " + CustomerTable.columnsDescription + " TEXT);"
        val CreateTableEmployee =
            "CREATE TABLE " + EmployeeTable.tableName + "(" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + EmployeeTable.columnName + " TEXT, " + EmployeeTable.columnAddress + " TEXT, " + EmployeeTable.columnsPhone + " TEXT, " + EmployeeTable.columnsDate + " TEXT, " + EmployeeTable.columnsPosition + " TEXT, " + EmployeeTable.columnsSalary + " TEXT, " + CustomerTable.columnsDescription + " TEXT);"
        val CreateTableSale =
            "CREATE TABLE " + SalesTable.tableName + "(" + BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + SalesTable.columnsAmount + " TEXT, " + SalesTable.columnsPrice + " TEXT, " + SalesTable.columnsCustomer + " TEXT, " + SalesTable.columnsDate + " TEXT);"


        p0!!.execSQL(CreateTableMaterail)
        p0.execSQL(CreateTableLoans)
        p0.execSQL(CreateTableCustomer)
        p0.execSQL(CreateTableEmployee)
        p0.execSQL(CreateTableSale)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        val DropMaterial = "DROP TABLE IF EXISTS " + MaterialTable.tableName + ""
        val DropLoans = "DROP TABLE IF EXISTS " + LoansTable.tableName + ""
        val DropCustomer = "DROP TABLE IF EXISTS " + CustomerTable.tableName + ""
        val DropEmployee = "DROP TABLE IF EXISTS " + EmployeeTable.tableName + ""
        val DropSales = "DROP TABLE IF ESISTS" + SalesTable.tableName + ""

        p0!!.execSQL(DropMaterial)
        p0.execSQL(DropLoans)
        p0.execSQL(DropCustomer)
        p0.execSQL(DropEmployee)
        p0.execSQL(DropSales)
    }


    fun inserNewMaterial(
        name: String,
        amount: String,
        price: String,
        date: String,
        description: String
    ): Boolean {
        val db: SQLiteDatabase = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(MaterialTable.columnName, name)
        contentValues.put(MaterialTable.columnAmount, amount)
        contentValues.put(MaterialTable.columnPrice, price)
        contentValues.put(MaterialTable.columnDate, date)
        contentValues.put(MaterialTable.columnDescription, description)
        val insert_data = db.insert(MaterialTable.tableName, null, contentValues)
        db.close()
        return !insert_data.equals(-1)
    }

    // Primary material
    fun readMaterial(): Cursor {
        val db: SQLiteDatabase = this.writableDatabase
        val read: Cursor = db.rawQuery("SELECT * FROM " + MaterialTable.tableName + "", null)
        return read
    }

    fun deleteMaterial(id: String): Boolean {
        val db: SQLiteDatabase = this.writableDatabase
        val deleteData = db.delete(MaterialTable.tableName, "${BaseColumns._ID}=?", arrayOf(id))
        return !deleteData.equals(-1)
    }

    fun updateMaterial(
        id: String,
        name: String,
        amount: String,
        price: String,
        date: String,
        description: String
    ): Boolean {
        val db: SQLiteDatabase = this.writableDatabase
        val contentValue = ContentValues()
        contentValue.put(MaterialTable.columnName, name)
        contentValue.put(MaterialTable.columnAmount, amount)
        contentValue.put(MaterialTable.columnPrice, price)
        contentValue.put(MaterialTable.columnDate, date)
        contentValue.put(MaterialTable.columnDescription, description)
        val update =
            db.update(MaterialTable.tableName, contentValue, "${BaseColumns._ID}=?", arrayOf(id))
        db.close()
        return !update.equals(-1)

    }


    // loans
    fun inserNewLoans(
        customer: String,
        amount: String,
        date: String,
        phoneNumber: String,
        description: String
    ): Boolean {
        val db: SQLiteDatabase = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(LoansTable.columnsCustomer, customer)
        contentValues.put(LoansTable.columnsAmount, amount)
        contentValues.put(LoansTable.columnsDate, date)
        contentValues.put(LoansTable.columnsPhoneNumber, phoneNumber)
        contentValues.put(LoansTable.columnsDescription, description)
        val insert_data = db.insert(LoansTable.tableName, null, contentValues)
        db.close()
        return !insert_data.equals(-1)
    }

    fun readLoans(): Cursor {
        val db: SQLiteDatabase = this.writableDatabase
        val read: Cursor = db.rawQuery("SELECT * FROM " + LoansTable.tableName + "", null)
        return read
    }

    fun deleteLoans(id: String): Boolean {
        val db: SQLiteDatabase = this.writableDatabase
        val deleteData = db.delete(LoansTable.tableName, "${BaseColumns._ID}=?", arrayOf(id))
        return !deleteData.equals(-1)
    }

    fun updateLoans(
        id: String,
        customer: String,
        amount: String,
        date: String,
        phone: String,
        description: String
    ): Boolean {
        val db: SQLiteDatabase = this.writableDatabase
        val contentValue = ContentValues()
        contentValue.put(LoansTable.columnsCustomer, customer)
        contentValue.put(LoansTable.columnsAmount, amount)
        contentValue.put(LoansTable.columnsDate, date)
        contentValue.put(LoansTable.columnsPhoneNumber, phone)
        contentValue.put(LoansTable.columnsDescription, description)
        val update =
            db.update(LoansTable.tableName, contentValue, "${BaseColumns._ID}=?", arrayOf(id))
        db.close()
        return !update.equals(-1)

    }


    // customer
    fun inserNewCustomer(
        name: String,
        address: String,
        phone: String,
        date: String,
        description: String
    ): Boolean {
        val db: SQLiteDatabase = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(CustomerTable.columnName, name)
        contentValues.put(CustomerTable.columnAddress, address)
        contentValues.put(CustomerTable.columnsPhone, phone)
        contentValues.put(CustomerTable.columnsDate, date)
        contentValues.put(CustomerTable.columnsDescription, description)
        val insert_data = db.insert(CustomerTable.tableName, null, contentValues)
        db.close()
        return !insert_data.equals(-1)
    }

    fun readCustomer(): Cursor {
        val db: SQLiteDatabase = this.writableDatabase
        val read: Cursor = db.rawQuery("SELECT * FROM " + CustomerTable.tableName + "", null)
        return read
    }

    fun deleteCustomer(id: String): Boolean {
        val db: SQLiteDatabase = this.writableDatabase
        val deleteData = db.delete(CustomerTable.tableName, "${BaseColumns._ID}=?", arrayOf(id))
        return !deleteData.equals(-1)
    }

    fun updateCustomer(
        id: String,
        name: String,
        address: String,
        phone: String,
        date: String,
        description: String
    ): Boolean {
        val db: SQLiteDatabase = this.writableDatabase
        val contentValue = ContentValues()
        contentValue.put(CustomerTable.columnName, name)
        contentValue.put(CustomerTable.columnAddress, address)
        contentValue.put(CustomerTable.columnsPhone, phone)
        contentValue.put(CustomerTable.columnsDate, date)
        contentValue.put(CustomerTable.columnsDescription, description)
        val update =
            db.update(CustomerTable.tableName, contentValue, "${BaseColumns._ID}=?", arrayOf(id))
        db.close()
        return !update.equals(-1)
    }


    // Employee
    fun inserNewEmployee(
        name: String,
        address: String,
        phone: String,
        date: String,
        postion: String,
        salary: String,
        description: String
    ): Boolean {
        val db: SQLiteDatabase = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(EmployeeTable.columnName, name)
        contentValues.put(EmployeeTable.columnAddress, address)
        contentValues.put(EmployeeTable.columnsPhone, phone)
        contentValues.put(EmployeeTable.columnsDate, date)
        contentValues.put(EmployeeTable.columnsPosition, postion)
        contentValues.put(EmployeeTable.columnsSalary, salary)
        contentValues.put(EmployeeTable.columnsDescription, description)
        val insert_data = db.insert(EmployeeTable.tableName, null, contentValues)
        db.close()
        return !insert_data.equals(-1)
    }


    fun readEmployee(): Cursor {
        val db: SQLiteDatabase = this.writableDatabase
        val read: Cursor = db.rawQuery("SELECT * FROM " + EmployeeTable.tableName + "", null)
        return read
    }

    fun deleteEmployee(id: String): Boolean {
        val db: SQLiteDatabase = this.writableDatabase
        val deleteData = db.delete(EmployeeTable.tableName, "${BaseColumns._ID}=?", arrayOf(id))
        return !deleteData.equals(-1)
    }

    fun updateEmployee(
        id: String,
        name: String,
        address: String,
        phone: String,
        date: String,
        position: String,
        salary: String,
        description: String
    ): Boolean {
        val db: SQLiteDatabase = this.writableDatabase
        val contentValue = ContentValues()
        contentValue.put(EmployeeTable.columnName, name)
        contentValue.put(EmployeeTable.columnAddress, address)
        contentValue.put(EmployeeTable.columnsPhone, phone)
        contentValue.put(EmployeeTable.columnsDate, date)
        contentValue.put(EmployeeTable.columnsPosition, position)
        contentValue.put(EmployeeTable.columnsSalary, salary)
        contentValue.put(EmployeeTable.columnsDescription, description)
        val update =
            db.update(EmployeeTable.tableName, contentValue, "${BaseColumns._ID}=?", arrayOf(id))
        db.close()
        return !update.equals(-1)
    }


    //sales
    fun inserNewSale(amount: String, price: String, customer: String, date: String, ): Boolean {
        val db: SQLiteDatabase = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(SalesTable.columnsAmount, amount)
        contentValues.put(SalesTable.columnsPrice, price)
        contentValues.put(SalesTable.columnsCustomer, customer)
        contentValues.put(SalesTable.columnsDate, date)
        val insert_data = db.insert(SalesTable.tableName, null, contentValues)
        db.close()
        return !insert_data.equals(-1)
    }


    fun readSales(): Cursor {
        val db: SQLiteDatabase = this.writableDatabase
        val read: Cursor = db.rawQuery("SELECT * FROM " + SalesTable.tableName + "", null)
        return read
    }

    fun deleteSale(id: String): Boolean {
        val db: SQLiteDatabase = this.writableDatabase
        val deleteData = db.delete(SalesTable.tableName, "${BaseColumns._ID}=?", arrayOf(id))
        return !deleteData.equals(-1)
    }

    fun updateSale(id: String, amount: String, price: String, customer: String, date: String, ): Boolean {
        val db: SQLiteDatabase = this.writableDatabase
        val contentValue = ContentValues()
        contentValue.put(SalesTable.columnsAmount,amount)
        contentValue.put(SalesTable.columnsPrice, price)
        contentValue.put(SalesTable.columnsCustomer, customer)
        contentValue.put(SalesTable.columnsDate, date)
        val update = db.update(SalesTable.tableName, contentValue, "${BaseColumns._ID}=?", arrayOf(id))
        db.close()
        return !update.equals(-1)
    }

}
