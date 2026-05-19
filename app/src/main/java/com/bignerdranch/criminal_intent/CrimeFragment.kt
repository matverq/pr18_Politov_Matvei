package com.bignerdranch.criminal_intent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

class CrimeFragment : Fragment() {
    private lateinit var crime: Crime
    private lateinit var titleField: EditText
    private lateinit var dateButton: Button
    private lateinit var solvedCheckBox: CheckBox
    private lateinit var selectLanguageCheckBox: CheckBox
    var isLanguageSelected: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime= Crime()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime, container, false)
        titleField = view.findViewById(R.id.crime_title) as EditText
        dateButton = view.findViewById(R.id.crime_date) as Button
        solvedCheckBox=view.findViewById(R.id.crime_solved) as CheckBox
        dateButton.apply {
            text=crime.date.toString()
            isEnabled=false
        }
        return view
    }
    override fun onStart() {
        super.onStart()
        titleField.addTextChangedListener(object : android.text.TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                crime.title = s.toString()
            }

            override fun afterTextChanged(s: android.text.Editable?) {}
        })
        solvedCheckBox.setOnCheckedChangeListener { _, isChecked -> crime.isSolved = isChecked }
        selectLanguageCheckBox.setOnCheckedChangeListener { _, isChecked ->
            crime.isLanguageSelected = isChecked
            Snackbar.make(requireView(),"Вы нажали кнопку", Snackbar.LENGTH_LONG).show()
        }
    }
}