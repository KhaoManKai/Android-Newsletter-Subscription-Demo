package com.seneca.assignment2_fragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




        if (savedInstanceState == null ){
            loadFragment(NewsletterSubscriptionFormFragment())
        }

    }
    private fun loadFragment(fragment : Fragment){
        val fm : FragmentManager = supportFragmentManager  // fm
        val ft : FragmentTransaction = fm.beginTransaction()   // ft
        fm.popBackStack()   // pop fragment
        ft.replace(R.id.frameLayout, fragment)   // ft begin -> add frag
        ft.addToBackStack(null)   // back stack -> false, recently fragment became reversible
        ft.commit()   // commit -> ft

    }
}