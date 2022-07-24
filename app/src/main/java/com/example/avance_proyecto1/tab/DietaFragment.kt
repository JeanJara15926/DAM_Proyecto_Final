package com.example.avance_proyecto1.tab

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.avance_proyecto1.Activity_Registro
import com.example.avance_proyecto1.OpcionDieta
import com.example.avance_proyecto1.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DietaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DietaFragment : Fragment() {
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

        val root = inflater.inflate(R.layout.fragment_dieta, container, false)
        val button1 = root.findViewById<Button>(R.id.button2);
        val button2 = root.findViewById<Button>(R.id.button3);
        val button3 = root.findViewById<Button>(R.id.button4);
        val button4 = root.findViewById<Button>(R.id.button);

        button1.setOnClickListener {
            val i = Intent(context, OpcionDieta::class.java)
            val bundle = Bundle()
            bundle.putString("nombre", "MEDITERRANEA");
            i.putExtras(bundle);
            startActivity(i)
            Toast.makeText(context, "Has seleccionado dieta Mediterranea", Toast.LENGTH_SHORT).show();
        }
        button2.setOnClickListener {
            val i = Intent(context, OpcionDieta::class.java)
            val bundle = Bundle()
            bundle.putString("nombre", "EQUILIBRADA");
            i.putExtras(bundle);
            startActivity(i)
            Toast.makeText(context, "Has seleccionado dieta Equilibrada", Toast.LENGTH_SHORT).show();
        }
        button3.setOnClickListener {
            val i = Intent(context, OpcionDieta::class.java)
            val bundle = Bundle()
            bundle.putString("nombre", "PROTEINAS");
            i.putExtras(bundle);
            startActivity(i)
            Toast.makeText(context, "Has seleccionado dieta alto en Proteina", Toast.LENGTH_SHORT).show();
        }
        button4.setOnClickListener {
            val i = Intent(context, OpcionDieta::class.java)
            val bundle = Bundle()
            bundle.putString("nombre", "GRASAS");
            i.putExtras(bundle);
            startActivity(i)
            Toast.makeText(context, "Has seleccionado dieta alto en Grasa", Toast.LENGTH_SHORT).show();
        }

        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DietaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DietaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}