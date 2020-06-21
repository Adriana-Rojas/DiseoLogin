package com.example.juliocesar.diseologin.database;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DataHelper extends SQLiteOpenHelper {

    public static final String db = "db_blog";
    public static final String tb_blog = "tb_blog";
    public static final String tb_evaluador = "tb_evaluador";

    public static final List<String> create = new ArrayList<String>(){{


        add("create table " + tb_blog+
                "(id INTEGER PRIMARY KEY,nombre text null, telefono text null, correo text null, contraseña text null)");
        add("create table " + tb_evaluador+
                "(id INTEGER PRIMARY KEY,nombre text null, telefono text null, correo text null, contraseña text null)");
    }};

    public static final List<String> table = new ArrayList<String>(){{
        add(tb_blog);
        add(tb_evaluador);
    }};

    public DataHelper(Context context) {
        super(context, db, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        for (int i = 0; i < create.size(); i++){
            sqLiteDatabase.execSQL(create.get(i));
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        for (int j = 0; j < table.size(); j++){
            sqLiteDatabase.execSQL(table.get(j));
        }
    }

}
