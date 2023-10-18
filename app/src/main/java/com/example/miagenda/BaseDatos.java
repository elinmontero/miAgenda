package com.example.miagenda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDatos extends SQLiteOpenHelper {

    private static final String Database_Nombre = "Usuarios";
    static final String Tabla_Nombre = "Usuario";
    private static final int Database_version = 1;


    public BaseDatos(@Nullable Context context) {
        super(context, Database_Nombre, null, Database_version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Tabla_Nombre + "(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " titulo TEXT NOT NULL," +
                " descripcion TEXT NOT NULL )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE " + Tabla_Nombre);
        onCreate(db);

    }
}
