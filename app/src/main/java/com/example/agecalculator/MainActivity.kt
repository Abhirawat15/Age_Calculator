package com.example.agecalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {

    var tvSelectedDate:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn=findViewById<Button>(R.id.btn)
        tvSelectedDate=findViewById(R.id.tvSelectedDate)

        btn.setOnClickListener{
            clickDatePicker()
        }
    }

    fun clickDatePicker(){
        val myCalendar=Calendar.getInstance()
        val year=myCalendar.get(Calendar.YEAR)
        val month=myCalendar.get(Calendar.MONTH)
        val day=myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{ view, selectedYear, selectedMonth, selectedDay ->
                Toast.makeText(this,"Year was $selectedYear, month was ${selectedMonth+1}, day of month was $selectedDay",Toast.LENGTH_LONG).show()

                val selectedDate="$selectedDay/${selectedMonth+1}/$selectedYear"
                tvSelectedDate?.text=selectedDate

                val sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate=sdf.parse(selectedDate)
            },
            year,
            month,
            day
        ).show()

    }
}