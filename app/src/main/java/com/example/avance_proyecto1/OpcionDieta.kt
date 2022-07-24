package com.example.avance_proyecto1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.avance_proyecto1.databinding.ActivityOpcionDietaBinding
import com.example.avance_proyecto1.db.DbRegistro

class OpcionDieta : AppCompatActivity() {
    private lateinit var binding: ActivityOpcionDietaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityOpcionDietaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var nombre = "";
        nombre = intent.getStringExtra("nombre").toString();
        //Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()
        var r1 = 0.0
        var r2 = 0.0
        var r3 = 0.0
        var r4 = 0.0
        var r5 = 0.0
        var r6 = 0.0
        val dbRegistro = DbRegistro(this);
        val miArreglo = dbRegistro.ObtenerDieta(nombre);

        r1=miArreglo.get(0)
        r2=miArreglo.get(1)
        r3=miArreglo.get(2)
        r4=miArreglo.get(3)
        r5=miArreglo.get(4)
        r6=miArreglo.get(5)

        binding.t1.text=r1.toString().substring(0,5);
        binding.t2.text=r2.toString().substring(0,5);
        binding.t3.text=r3.toString().substring(0,5);
        binding.t4.text=r4.toString().substring(0,5);
        binding.t5.text=r5.toString().substring(0,5);
        binding.t6.text=r6.toString().substring(0,5);



        if(nombre=="EQUILIBRADA"){
            binding.nombre.text="Dieta EQUILIBRADA"
            val id = resources.getIdentifier("equilibrada", "drawable", packageName)
            binding.imageView4.setImageResource(id)
            binding.textd.text= "Una alimentación equilibrada supone un aporte de nutrientes adecuado a las necesidades individuales de cada persona para el mantenimiento de la salud y debe cubrir las demandas energéticas del organismo.\n" +
                    "Las dietas variadas permiten asegurar la ingestión proporcionada de todos los nutrientes, debiendo ajustar individualmente las calorías necesarias en función de la actividad desarrollada.\n" +
                    "Otro de los aspectos que debe tenerse en cuenta son las posibles variaciones individuales por componentes genéticos, ambientales."

        }else if(nombre=="MEDITERRANEA"){
            binding.nombre.text="Dieta MEDITERRANEA"
            val id = resources.getIdentifier("medit", "drawable", packageName)
            binding.imageView4.setImageResource(id)
            binding.textd.text="Se trata de una alimentación variada, sin exceder las necesidades diarias de cada individuo, en función de su edad, sexo, talla y actividad física.\n" +
                                "Se recomienda el consumo de carbohidratos en cantidad de hasta 300-400 g./día, sobre todo en forma de legumbres, verduras y frutas.\n" +
                                "Es preciso evitar la grasa animal, a excepción de la que proviene de pescados marinos y pequeños aportes de lácteos, con consumo preferente de aceite de oliva en cantidad diaria que oscila de 70 a 80 gramos."

        }else if(nombre=="GRASAS"){
            binding.nombre.text="Dieta ALTO EN GRASAS"
            val id = resources.getIdentifier("altograsas", "drawable", packageName)
            binding.imageView4.setImageResource(id)
            binding.textd.text="Las grasas aportan energía y ayudan a absorber determinados nutrientes. Cada gramo de grasa nos proporciona 9 kcal. mientras que un gramo de carbohidratos sólo nos proporciona 4 kcal.\n" +
                                "Se recomienda que las grasas de la dieta aporten entre un 20 y un 30% de las necesidades energéticas diarias."

        }else if(nombre=="PROTEINAS"){
            binding.nombre.text="Dieta ALTO EN PROTEINAS"
            val id = resources.getIdentifier("proteina", "drawable", packageName)
            binding.imageView4.setImageResource(id)
            binding.textd.text="Las proteínas son los nutrientes que desempeñan un mayor número de funciones en las células de todos lo seres vivos. Forman parte de la estructura de los tejidos y por otro lado tienen función metabólica y reguladora."

        }



    }
}