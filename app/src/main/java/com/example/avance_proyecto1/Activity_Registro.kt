package com.example.avance_proyecto1

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.avance_proyecto1.databinding.ActivityRegistroBinding
import com.example.avance_proyecto1.db.DbHelper
import com.example.avance_proyecto1.db.DbRegistro
import com.example.avance_proyecto1.tab.Activity_Generation


class Activity_Registro : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkBoxHombre.setOnClickListener{
            binding.checkBoxMujer.isChecked = false;
        }
        binding.checkBoxMujer.setOnClickListener {
           binding.checkBoxHombre.isChecked = false;
        }
        val dbhelper = DbHelper(this);
        val db =  dbhelper.writableDatabase;

        if (db != null){
            val dbRegistro = DbRegistro(this);
            val valdiar = dbRegistro.validarRegistro()
            if (valdiar > 0){
                val i = Intent(this, Activity_Generation::class.java)
                startActivity(i)
            }
        }else{
            Toast.makeText(this,"BASE DE DATOS ERROR", Toast.LENGTH_SHORT).show();
        }

        binding.btnSeguir.setOnClickListener {

            val edadtxt = (binding.txtEdad.text.toString());
            val tallatxt = (binding.txtTalla.text.toString());
            val pesotxt =  (binding.txtPeso.text.toString());

            if (!(edadtxt == "" || tallatxt == "" || pesotxt == "" )){
                if(Integer.parseInt(edadtxt) <= 0 ){
                    Toast.makeText(this, "Edad no valido", Toast.LENGTH_SHORT).show();
                }else if (Integer.parseInt(tallatxt) <= 0 || Integer.parseInt(tallatxt) >= 300){
                    Toast.makeText(this, "Talla no valido", Toast.LENGTH_SHORT).show();
                }else if (Integer.parseInt(pesotxt) <= 0 || Integer.parseInt(pesotxt) >= 200){
                    Toast.makeText(this, "Peso no valido", Toast.LENGTH_SHORT).show();
                }else{
                    val checkMujer = binding.checkBoxMujer.isChecked
                    val edad = Integer.parseInt(edadtxt);
                    val talla = Integer.parseInt(tallatxt);
                    val peso = Integer.parseInt(pesotxt);
                    if(checkMujer){
                        val i = Intent(this, NivelActividadActivity::class.java)
                        val bundle = Bundle()
                        bundle.putInt("peso", peso);
                        bundle.putInt("talla", talla);
                        bundle.putInt("edad", edad);
                        bundle.putString("sexo", "femenino");
                        i.putExtras(bundle);
                        startActivity(i)
                    }else{
                        val i = Intent(this, NivelActividadActivity::class.java)
                        val bundle = Bundle()
                        bundle.putInt("peso", peso);
                        bundle.putInt("talla", talla);
                        bundle.putInt("edad", edad);
                        bundle.putString("sexo", "masculino");
                        i.putExtras(bundle);
                        startActivity(i)
                    }
                }

            }else{
                Toast.makeText(this,"Datos incompletos", Toast.LENGTH_LONG).show();
            }


        }
    }
}