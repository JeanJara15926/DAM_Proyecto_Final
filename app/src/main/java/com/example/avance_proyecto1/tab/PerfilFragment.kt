package com.example.avance_proyecto1.tab

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.avance_proyecto1.Activity_Registro
import com.example.avance_proyecto1.R
import com.example.avance_proyecto1.db.DbRegistro
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_perfil.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PerfilFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PerfilFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_perfil, container, false)
        val button = root.findViewById<Button>(R.id.btnEditar);
        val img = root.findViewById<ImageView>(R.id.img_imc);
        val textView = root.findViewById<TextView>(R.id.tv_imc);
        val textViewtxt = root.findViewById<TextView>(R.id.tv_imc_txt);
        val textViewfcm = root.findViewById<TextView>(R.id.img_fcm);
        val dbRegistro = DbRegistro(context);

        val imc = dbRegistro.imc
        val fcm = dbRegistro.fcm
        textViewfcm.text = ("Frecuencia Cardiaca Maxima: "+ fcm).substring(0,34);

        textView.text = ("Tu IMC es: "+ imc).substring(0,15);
        //colocar img según imc
        if(imc <= 18.5){
            val id = resources.getIdentifier("grafico_peso_bajo", "drawable", context?.packageName)
            textViewtxt.text = "Peso Bajo"
            img.setImageResource(id)
        }else if(imc > 18.5 && imc <= 24.9){
            val id = resources.getIdentifier("grafico_normal", "drawable", context?.packageName)
            textViewtxt.text = "Peso Normal"
            img.setImageResource(id)
        }else if (imc > 24.9 && imc < 29.9){
            val id = resources.getIdentifier("grafico_exceso_peso", "drawable", context?.packageName)
            textViewtxt.text = "Exceso de Peso"
            img.setImageResource(id)
        }else if (imc > 29.9 && imc < 34.9){
            val id = resources.getIdentifier("grafico_obeso", "drawable", context?.packageName)
            textViewtxt.text = "Obeso"
            img.setImageResource(id)
        }
        else if (imc > 34.9){
            val id = resources.getIdentifier("grafico_extrem_obeso", "drawable", context?.packageName)
            textViewtxt.text = "Extremadamente Obeso"
            img.setImageResource(id)
        }


        button.setOnClickListener {
            val i = Intent(context, Activity_Registro::class.java)
            val bundle = Bundle()
            bundle.putBoolean("actualiarRegistro", true);
            i.putExtras(bundle);
            startActivity(i)
            //Toast.makeText(context, "CLICK",Toast.LENGTH_SHORT).show();
        }
        return root;
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PerfilFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PerfilFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}