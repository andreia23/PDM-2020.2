package com.example.cores_desafio.dao

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoHelper (context: Context): SQLiteOpenHelper(context, "bd_cores", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table cores( " +
                "id integer primary key autoincrement, " +
                "nome text, " +
                "codigo integer)"

        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table cores")
        this.onCreate(db)
    }

}