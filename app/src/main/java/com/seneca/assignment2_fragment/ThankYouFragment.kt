package com.seneca.assignment2_fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment


class ThankYouFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val thankYouFragmentView : View = inflater.inflate(R.layout.fragment_thank_you, container, false)


        val nameFromBundle = arguments?.getString("key_Name")
        val emailFromBundle = arguments?.getString("key_email")
        val genderFromBundle = arguments?.getString("key_gender")
        val familyEmailFromBundle = arguments?.getBoolean("key_family_email")
        val termsFromBundle = arguments?.getBoolean("key_T&C")
        
        val tvName : TextView = thankYouFragmentView.findViewById(R.id.tvName)
        val tvEmail : TextView = thankYouFragmentView.findViewById(R.id.tvEmail)
        val tvGender : TextView = thankYouFragmentView.findViewById(R.id.tvGender)
        val tvFamilyEvents : TextView = thankYouFragmentView.findViewById(R.id.tvFamily)
        val tvTerms : TextView = thankYouFragmentView.findViewById(R.id.tvTerms)


        tvName.text = nameFromBundle
        tvEmail.text = emailFromBundle
        tvGender.text = genderFromBundle
        tvFamilyEvents.text = if(familyEmailFromBundle == true) "Subscribed" else "Not subscribed"
        tvTerms.text = if(termsFromBundle == true) "Accepted" else "Not accepted"


        val btnGoActivityTwo : Button = thankYouFragmentView.findViewById(R.id.btnGoActivityTwo)
        btnGoActivityTwo.setOnClickListener{
            val intent : Intent = Intent(activity, SecondActivity::class.java)
            intent.putExtra("user_name", nameFromBundle)
            startActivity(intent)
        }



        return thankYouFragmentView
    }

}