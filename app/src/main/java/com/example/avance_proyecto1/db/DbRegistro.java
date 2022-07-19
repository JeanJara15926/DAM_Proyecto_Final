package com.example.avance_proyecto1.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

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
}
