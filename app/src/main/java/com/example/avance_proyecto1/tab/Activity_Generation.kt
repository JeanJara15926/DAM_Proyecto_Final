package com.example.avance_proyecto1.tab

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.avance_proyecto1.R
import kotlinx.android.synthetic.main.activity_tab_navigation.*

class Activity_Generation : AppCompatActivity(), View.OnClickListener {
    private val FRAGMENT_PRINCIPAL = 0
    private val FRAGMENT_DIETA = 1
    private val FRAGMENT_PERFIL = 2

    private val indicatorViews = mutableListOf<View>()
    private val titleViews = mutableListOf<ImageView>()
    private var currentIndicator = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_navigation)

        indicatorViews.add(iviPricipal)
        indicatorViews.add(iviDieta)
        indicatorViews.add(iviPerfil)

        titleViews.add(vw_principal)
        titleViews.add(vw_dieta)
        titleViews.add(vw_perfil)

        titleViews.forEach {
            it.setOnClickListener(this)
        }

        selectFirst()
    }

    override fun onClick(view: View?) {
        val bundle = Bundle()

        var fragmentId = when (view?.id) {
            R.id.vw_principal -> FRAGMENT_PRINCIPAL
            R.id.vw_dieta -> FRAGMENT_DIETA
            R.id.vw_perfil -> FRAGMENT_PERFIL

            else -> FRAGMENT_PRINCIPAL
        }

        updateUI(fragmentId)
        changeFragment(bundle, fragmentId)
    }

    private fun selectFirst() {
        val bundle = Bundle()
        val fragmentId = FRAGMENT_PRINCIPAL
        updateUI(fragmentId)
        changeFragment(bundle, fragmentId)
    }

    private fun updateUI(fragmentId: Int) {
        if (currentIndicator >= 0) {
            indicatorViews[currentIndicator].setBackgroundColor(Color.TRANSPARENT)
            //titleViews[currentIndicator].inputType = Typeface.NORMAL
        }
        indicatorViews[fragmentId].setBackgroundColor(Color.parseColor("#5ECEF9"))
        //titleViews[fragmentId].inputType = Typeface.BOLD
        currentIndicator = fragmentId
    }

    private fun changeFragment(bundle: Bundle, fragmentId: Int) {

        val fragment = factoryFragment(bundle, fragmentId)
        //fragment.setArguments(bundle)

        fragment?.let {
            //val transaction = supportFragmentManager.beginTransaction()
            //transaction.replace(R.id.flayContainer, it)
            //transaction.addToBackStack(null)

            // Commit the transaction
            //transaction.commit()

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flayContainer, it)
                addToBackStack(null)
                commit()
            }
        }
    }

    private fun factoryFragment(bundle: Bundle, fragmentId: Int): Fragment? {
        when (fragmentId) {
            FRAGMENT_PRINCIPAL -> return PrincipalFragment()
            FRAGMENT_DIETA -> return DietaFragment()
            FRAGMENT_PERFIL -> return PerfilFragment()
        }
        return null
    }
}