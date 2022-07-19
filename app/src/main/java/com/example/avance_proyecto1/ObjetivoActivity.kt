package com.example.avance_proyecto1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.avance_proyecto1.databinding.ActivityObjetivoBinding
import com.example.avance_proyecto1.databinding.NivelActividadBinding
import com.example.avance_proyecto1.db.DbRegistro
import com.example.avance_proyecto1.tab.Activity_Generation

class ObjetivoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityObjetivoBinding
    var peso = 0;
    var edad = 0;
    var talla = 0;
    var sexo = "";
    var nivelAct = 0;

    val dbRegistro = DbRegistro(this);
    var kcal = 0.0;
    var nivel = 0.0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityObjetivoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        peso = intent.getIntExtra("peso", 0);
        talla = intent.getIntExtra("talla", 0);
        edad = intent.getIntExtra("edad", 0);
        sexo = intent.getStringExtra("sexo").toString();
        nivelAct = intent.getIntExtra("nivel", 0);

        if (nivelAct == 1){
            nivel = 1.15;
        }else if (nivelAct == 2){
            nivel = 1.35;
        }else if (nivelAct == 3){
            nivel = 1.55;
        }else if (nivelAct == 4){
            nivel = 1.75;
        }else if (nivelAct == 5){
            nivel = 1.95;
        }

        if (sexo == "femenino"){
            kcal = ((10 * peso ) + (6.25 * talla) - (5 * edad) - 161)*nivel;
            //dbRegistro.insertRegistro(edad, sexo,talla, peso, kcal)
        }else{
            kcal = ((10 * peso) + (6.25 * talla) - (5 * edad ) + 5)*nivel;
            //dbRegistro.insertRegistro(edad, sexo,talla, peso, kcal)
        }

        binding.btnPerder.setOnClickListener {
            kcal -= 300;
            insertar()
        }
        binding.btnMantener.setOnClickListener {
            insertar()
        }
        binding.btnConstruir.setOnClickListener {
            kcal += 300;
            insertar()
        }
    }

    private fun insertar(){
        val items = dbRegistro.insertRegistro(edad, sexo,talla, peso, kcal)
        if (items > 0 ){
            val i = Intent(this,Activity_Generation::class.java)
            startActivity(i)
        }
    }
}