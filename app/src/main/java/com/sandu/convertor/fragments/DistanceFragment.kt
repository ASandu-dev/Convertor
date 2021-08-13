package com.sandu.convertor.fragments

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.sandu.convertor.R
import com.sandu.convertor.data.DistanceConverters


class DistanceFragment : Fragment() {
    val distance = DistanceConverters()
    var firstValue:String = ""
    var secondValue:String = ""

    val units: ArrayList<CharSequence> = arrayListOf<CharSequence>(
        this.toString(),
        R.array.unit_name.toString(), android.R.layout.simple_spinner_item.toString()
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


            return inflater.inflate(R.layout.fragment_distance, container, false)
        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spinner: Spinner = view.findViewById(R.id.spinner)
        val spinner2: Spinner = view.findViewById(R.id.spinner2)
        val convert_btn:Button = view.findViewById(R.id.convert_btn)
        val from_tv:EditText = view.findViewById(R.id.from_tv)
        val to_tv:EditText = view.findViewById(R.id.to_tv)
        val ctx = this.context



        spinner.adapter = activity?.let {
            ArrayAdapter(
                it, R.layout.spinner_item,
                resources.getStringArray(R.array.unit_name)
            )
        } as SpinnerAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val choice = parent?.getItemAtPosition(position).toString()
                firstValue(choice)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        spinner2.adapter = activity?.let {
            ArrayAdapter(
                it, R.layout.spinner_item2,
                resources.getStringArray(R.array.unit_name)
            )
        } as SpinnerAdapter

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val choice2 = parent?.getItemAtPosition(position).toString()
                secondValue(choice2)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        convert_btn.setOnClickListener {
            val from = from_tv.text
          
            getAppropriateConvertFunction()
        }


    }

    private fun getAppropriateConvertFunction() {
        val value = firstValue+"2"+secondValue


        Toast.makeText(view?.context, value, Toast.LENGTH_SHORT).show()
    }

    private fun firstValue(choice: String) {
        firstValue = choice
    }

    private fun secondValue(choice2: String) {
        secondValue = choice2
    }
}




