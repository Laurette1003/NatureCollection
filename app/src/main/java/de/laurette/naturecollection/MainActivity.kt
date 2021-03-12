package de.laurette.naturecollection

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.laurette.naturecollection.fragments.HomeFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // injecter le fragment dans notre boite (fragment_container)
        //val nous permet de stocker une valeur qui ne changera pas
        //supportFragmentManager permet de gerer les framents sur android
         val transaction = supportFragmentManager.beginTransaction()
         transaction.replace(R.id.fragment_container, HomeFragment(this))
         transaction.addToBackStack(null)
         transaction.commit()
    }
}