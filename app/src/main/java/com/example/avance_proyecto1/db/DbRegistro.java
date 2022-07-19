package com.example.avance_proyecto1.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DbRegistro extends DbHelper{
    Context context;
    public DbRegistro(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertRegistro(int edad, String sexo, int talla, int peso, double kcal){
        long id = 0;
        try {
            DbHelper ddbHelper = new DbHelper(context);
            SQLiteDatabase db = ddbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("n_edad", edad);
            values.put("c_sexo", sexo);
            values.put("n_talla", talla);
            values.put("n_peso", peso);
            values.put("kcal", kcal);
            try {
                db.execSQL("DELETE FROM " + TABLA_REGISTRO);
            }catch (Exception e){
                e.toString();
            }
            id = db.insert(TABLA_REGISTRO, null,values);
        }catch (Exception e){
            e.toString();
        }
        return id;
    }

    public Double validarRegistro(){
        Cursor rows = null;
        Double a = 0.0;
        try {
            DbHelper ddbHelper = new DbHelper(context);
            SQLiteDatabase db = ddbHelper.getWritableDatabase();
            rows =  db.rawQuery("SELECT * FROM " + TABLA_REGISTRO, null);

            if(rows != null ){
                rows.moveToFirst();
                do{
                    Double id = rows.getDouble(0);
                    a = id;
                }while(rows.moveToNext());
            }
            rows.close();

        }catch (Exception e){
            e.toString();
        }
        return a;
    }

    public Double getIMC(){
        Cursor rows = null;
        Double imc = 0.0;
        try {
            DbHelper ddbHelper = new DbHelper(context);
            SQLiteDatabase db = ddbHelper.getWritableDatabase();
            rows =  db.rawQuery("SELECT * FROM " + TABLA_REGISTRO, null);

            if(rows != null){
                rows.moveToFirst();
                do{
                    Double talla = rows.getDouble(3);
                    Double peso = rows.getDouble(4);
                    imc = (peso)/Math.pow((talla/100), 2.0);
                }while(rows.moveToNext());
            }
            rows.close();

        }catch (Exception e){
            e.toString();
        }
        return imc;
    }

    public Double getFCM(){
        Cursor rows = null;
        Double fcm = 0.0;
        try {
            DbHelper ddbHelper = new DbHelper(context);
            SQLiteDatabase db = ddbHelper.getWritableDatabase();
            rows =  db.rawQuery("SELECT * FROM " + TABLA_REGISTRO, null);

            if(rows != null){
                rows.moveToFirst();
                do{
                    Double edad = rows.getDouble(1);
                    fcm = 220-(edad*0.775);
                }while(rows.moveToNext());
            }
            rows.close();

        }catch (Exception e){
            e.toString();
        }
        return fcm;
    }
}
