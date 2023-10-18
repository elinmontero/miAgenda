package com.example.miagenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbActividades extends BaseDatos {

    Context context;

    public DbActividades(@Nullable Context context) {
        super(context);

        this.context = context;

    }

    public long AgregarActividad(String titulo, String descripcion) {
        long id = 0;
        try {
            BaseDatos baseDatos = new BaseDatos(context);
            SQLiteDatabase db = baseDatos.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("TITULO", titulo);
            values.put("DESCRIPCION", descripcion);

            id = db.insert(Tabla_Nombre, null, values);

        } catch (Exception ex) {
            ex.toString();

        }
        return id;

    }
    public ArrayList<Actividades> mostrarListaActividades(){
        BaseDatos baseDatos = new BaseDatos(context);
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        ArrayList<Actividades> actividadesLista = new ArrayList<>();

        Actividades usuarios = null;
        Cursor cursorUsuarios = null;

        cursorUsuarios = db.rawQuery(" SELECT * FROM " + Tabla_Nombre , null);
        if (cursorUsuarios.moveToFirst()) do {
            usuarios = new Actividades();
            usuarios.setId(cursorUsuarios.getInt(0));
            usuarios.setTitulo(cursorUsuarios.getString(1));
            usuarios.setDescripcion(cursorUsuarios.getString(2));

            actividadesLista.add(usuarios);

        } while (cursorUsuarios.moveToNext());

        cursorUsuarios.close();

        return actividadesLista;

    }

    public Actividades verActividad(int id){
        BaseDatos baseDatos = new BaseDatos(context);
        SQLiteDatabase db = baseDatos.getWritableDatabase();


        Actividades usuarios = null;
        Cursor cursorUsuarios ;

        cursorUsuarios = db.rawQuery(" SELECT * FROM " + Tabla_Nombre +
                " WHERE id = " + id + " LIMIT 1", null);
        if (cursorUsuarios.moveToFirst())  {
            usuarios = new Actividades();
            usuarios.setId(cursorUsuarios.getInt(0));
            usuarios.setTitulo(cursorUsuarios.getString(1));
            usuarios.setDescripcion(cursorUsuarios.getString(2));

        }

        cursorUsuarios.close();

        return usuarios;

    }

    public boolean editarActividad(int id, String titulo, String descripcion) {
        boolean correcto = false;

        BaseDatos baseDatos = new BaseDatos(context);
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        try {
            db.execSQL("UPDATE " + Tabla_Nombre + " SET titulo = '"+ titulo +"', " +
                    "descripcion = '"+ descripcion +"' WHERE id = '"+ id +"' ");
            correcto = true;


        } catch (Exception ex) {
            ex.toString();
            correcto = false;

        } finally {
            db.close();
        }
        return correcto;

    }

    public boolean eliminarActividad(int id) {
        boolean correcto = false;

        BaseDatos baseDatos = new BaseDatos(context);
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM " + Tabla_Nombre +  " WHERE id = '"+ id +"' ");
            correcto = true;


        } catch (Exception ex) {
            ex.toString();
            correcto = false;

        } finally {
            db.close();
        }
        return correcto;

    }

}
