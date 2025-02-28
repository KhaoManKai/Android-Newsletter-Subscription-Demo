package com.seneca.assignment2_fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch
import androidx.fragment.app.Fragment


class NewsletterSubscriptionFormFragment : Fragment() {

    private lateinit var etName : EditText
    private lateinit var etEmail : EditText

    private lateinit var rbGender : RadioGroup
    private lateinit var selectedGender : String
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var swReceiveFamilyEmail : Switch
    private lateinit var cbAgreeTandC : CheckBox
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val newsletterSubscriptionFormFragmentView : View = inflater.inflate(R.layout.fragment_newsletter_subscription_form, container, false)

        etName = newsletterSubscriptionFormFragmentView.findViewById(R.id.etName)
        etEmail = newsletterSubscriptionFormFragmentView.findViewById(R.id.etEmail)
        swReceiveFamilyEmail = newsletterSubscriptionFormFragmentView.findViewById(R.id.swReceiveFamilyEmail)
        cbAgreeTandC = newsletterSubscriptionFormFragmentView.findViewById(R.id.cbAgreeTandC)
        rbGender = newsletterSubscriptionFormFragmentView.findViewById(R.id.rbGender)
        val btRegister : Button = newsletterSubscriptionFormFragmentView.findViewById(R.id.btRegister)



        btRegister.setOnClickListener{

            selectedGender = when (rbGender.checkedRadioButtonId) {
                R.id.rbMale -> "Male"
                R.id.rbFemale -> "Female"
                R.id.rbOther -> "Other"
                else -> ""
            }
            val bundle : Bundle = Bundle().apply {
                putString("key_Name", etName.text.toString().trim())
                putString("key_email", etEmail.text.toString().trim())
                putString("key_gender", selectedGender)
                putBoolean("key_family_email", swReceiveFamilyEmail.isChecked)
                putBoolean("key_T&C", cbAgreeTandC.isChecked)
            }

            val thankYouFragment = ThankYouFragment()
            thankYouFragment.arguments = bundle

            requireActivity().supportFragmentManager.popBackStack()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, thankYouFragment)
                .addToBackStack(null)
                .commit()

        }

        return newsletterSubscriptionFormFragmentView
    }

}