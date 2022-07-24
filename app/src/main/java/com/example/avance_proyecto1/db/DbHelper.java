package com.example.avance_proyecto1.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "gym.db";
    public static final String TABLA_REGISTRO = "registro";
    public static final String TABLA_INDICE = "indice";
    public static final String TABLA_DIETA = "dieta";
    public static final String TABLA_DATO_DIETA = "dato_dieta";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_REGISTRO + "(" +
                "n_id_registro INTEGER PRIMARY KEY AUTOINCREMENT," +
                "n_edad INTEGER NOT NULL," +
                "c_sexo TEXT NOT NULL," +
                "n_talla INTEGER NOT NULL," +
                "n_peso INTGER NOT NULL," +
                "kcal INTEGER NOT NULL)"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_INDICE + "(" +
                "n_id_indice INTEGER PRIMARY KEY AUTOINCREMENT," +
                "n_id_registro INTEGER NOT NULL," +
                "n_imc TEXT NOT NULL," +
                "c_imc_img TEXT NOT NULL," +
                "n_fcmax INTGER NOT NULL)"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_DIETA + "(" +
                "n_id_dieta INTEGER PRIMARY KEY AUTOINCREMENT," +
                "c_nombre TEXT NOT NULL," +
                "c_fruta TEXT NOT NULL," +
                "c_lacteos TEXT NOT NULL," +
                "c_proteinas TEXT NOT NULL," +
                "c_verduras TEXT NOT NULL," +
                "c_frutos_cereales TEXT NOT NULL)"
        );

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLA_DATO_DIETA + "(" +
                "n_id_dato_dieta INTEGER PRIMARY KEY AUTOINCREMENT," +
                "c_nombreg TEXT NOT NULL," +
                "c_hidratog REAL NOT NULL," +
                "c_proteinasg REAL NOT NULL," +
                "c_grasasg REAL NOT NULL," +
                "c_hidratog1 REAL NOT NULL," +
                "c_proteinasg1 REAL NOT NULL," +
                "c_grasasg1 REAL NOT NULL)"
        );

        sqLiteDatabase.execSQL("INSERT INTO "+TABLA_DIETA+" (c_nombre, c_fruta, c_lacteos, c_proteinas, c_verduras, c_frutos_cereales) " +
                "VALUES ('c_nombre', 'c_nombre', 'c_nombre', 'c_nombre', 'c_nombre', 'c_nombre'), " +
                "('c_nombre2', 'c_nombre2', 'c_nombre2', 'c_nombre2', 'c_nombre2', 'c_nombre2') " +
                "");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLA_REGISTRO);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLA_INDICE);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLA_DIETA);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLA_DATO_DIETA);
        onCreate(sqLiteDatabase);
    }
}
