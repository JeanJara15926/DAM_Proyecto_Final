package com.example.avance_proyecto1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.avance_proyecto1.databinding.NivelActividadBinding
import com.example.avance_proyecto1.db.DbRegistro

class NivelActividadActivity : AppCompatActivity() {
    private lateinit var binding: NivelActividadBinding

    var peso = 0;
    var edad = 0;
    var talla = 0;
    var sexo = "";
    var nivelAct = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NivelActividadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        peso = intent.getIntExtra("peso", 0);
        talla = intent.getIntExtra("talla", 0);
        edad = intent.getIntExtra("edad", 0);
        sexo = intent.getStringExtra("sexo").toString();

        binding.btnSedentario.setOnClickListener{
            //Toast.makeText(this, sexo, Toast.LENGTH_SHORT).show();
            nivelAct = 1;
            send();
        }
        binding.btnPocoActivo.setOnClickListener{
            nivelAct = 2;
            send();
        }
        binding.btnActivo.setOnClickListener{
            nivelAct = 3;
            send();
        }
        binding.btnMuyActivo.setOnClickListener{
            nivelAct = 4;
            send();
        }
        binding.btnMuyMuyActivo.setOnClickListener{
            nivelAct = 5;
            send();
        }

    }

    private fun send(){
        val i = Intent(this,ObjetivoActivity::class.java)
        val bundle = Bundle()
        bundle.putInt("peso", peso);
        bundle.putInt("talla", talla);
        bundle.putInt("edad", edad);
        bundle.putString("sexo", sexo);
        bundle.putInt("nivel", nivelAct);
        i.putExtras(bundle);
        startActivity(i)

    }
}