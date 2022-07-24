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

    public long insertDatosCal(double kcal){
        long id = 0;
        Double ehk1 = 0.0;
        Double epk1 = 0.0;
        Double egk1 = 0.0;
        Double ehg1 = 0.0;
        Double epg1 = 0.0;
        Double egg1 = 0.0;

        Double ehk2 = 0.0;
        Double epk2 = 0.0;
        Double egk2 = 0.0;
        Double ehg2 = 0.0;
        Double epg2 = 0.0;
        Double egg2 = 0.0;

        Double ehk3 = 0.0;
        Double epk3 = 0.0;
        Double egk3 = 0.0;
        Double ehg3 = 0.0;
        Double epg3 = 0.0;
        Double egg3 = 0.0;

        Double ehk4 = 0.0;
        Double epk4 = 0.0;
        Double egk4 = 0.0;
        Double ehg4 = 0.0;
        Double epg4 = 0.0;
        Double egg4 = 0.0;

        ehk1 = kcal*0.4;
        epk1 = kcal*0.4;
        egk1 = kcal*0.2;
        ehg1 = kcal/4;
        epg1 = kcal/4;
        egg1 = kcal/9;

        ehk2 = kcal*0.45;
        epk2 = kcal*0.35;
        egk2 = kcal*0.2;
        ehg2 = kcal/4;
        epg2 = kcal/4;
        egg2 = kcal/9;

        ehk3 = kcal*0.2;
        epk3 = kcal*0.4;
        egk3 = kcal*0.4;
        ehg3 = kcal/4;
        epg3 = kcal/4;
        egg3 = kcal/9;

        ehk4 = kcal*0.3;
        epk4 = kcal*0.5;
        egk4 = kcal*0.2;
        ehg4 = kcal/4;
        epg4 = kcal/4;
        egg4 = kcal/9;
        try {
            DbHelper ddbHelper1 = new DbHelper(context);
            SQLiteDatabase db1 = ddbHelper1.getWritableDatabase();

            ContentValues values1 = new ContentValues();
            values1.put("c_nombreg", "EQUILIBRADA");
            values1.put("c_hidratog", ehk1);
            values1.put("c_proteinasg", epk1);
            values1.put("c_grasasg", egk1);
            values1.put("c_hidratog1", ehg1);
            values1.put("c_proteinasg1", epg1);
            values1.put("c_grasasg1", egg1);

            DbHelper ddbHelper2 = new DbHelper(context);
            SQLiteDatabase db2 = ddbHelper2.getWritableDatabase();

            ContentValues values2 = new ContentValues();
            values2.put("c_nombreg", "MEDITERRANEA");
            values2.put("c_hidratog", ehk2);
            values2.put("c_proteinasg", epk2);
            values2.put("c_grasasg", egk2);
            values2.put("c_hidratog1", ehg2);
            values2.put("c_proteinasg1", epg2);
            values2.put("c_grasasg1", egg2);

            DbHelper ddbHelper3 = new DbHelper(context);
            SQLiteDatabase db3 = ddbHelper3.getWritableDatabase();

            ContentValues values3 = new ContentValues();
            values3.put("c_nombreg", "GRASAS");
            values3.put("c_hidratog", ehk3);
            values3.put("c_proteinasg", epk3);
            values3.put("c_grasasg", egk3);
            values3.put("c_hidratog1", ehg3);
            values3.put("c_proteinasg1", epg3);
            values3.put("c_grasasg1", egg3);

            DbHelper ddbHelper4 = new DbHelper(context);
            SQLiteDatabase db4 = ddbHelper4.getWritableDatabase();

            ContentValues values4 = new ContentValues();
            values4.put("c_nombreg", "PROTEINAS");
            values4.put("c_hidratog", ehk4);
            values4.put("c_proteinasg", epk4);
            values4.put("c_grasasg", egk4);
            values4.put("c_hidratog1", ehg4);
            values4.put("c_proteinasg1", epg4);
            values4.put("c_grasasg1", egg4);
            try {
                db1.execSQL("DELETE FROM " + TABLA_DATO_DIETA);
            }catch (Exception e){
                e.toString();
            }
            id = db1.insert(TABLA_DATO_DIETA, null,values1);
            id = db2.insert(TABLA_DATO_DIETA, null,values2);
            id = db3.insert(TABLA_DATO_DIETA, null,values3);
            id = db4.insert(TABLA_DATO_DIETA, null,values4);
        }catch (Exception e){
            e.toString();
        }
        return id;
    }






}
