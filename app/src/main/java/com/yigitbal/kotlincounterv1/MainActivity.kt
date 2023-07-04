package com.yigitbal.kotlincounterv1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    //private lateinit var spinner: Spinner
    private lateinit var editText: EditText
    private lateinit var sayi: String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var editText: EditText
        lateinit var sayi: String
        editText = findViewById(R.id.numberInputText)


/*
        val hashMap: HashMap<Int, String> = HashMap() //define empty hashmap
        hashMap[0] = "Sure seçin"
        hashMap[1] = "Ayetel Kürsi"
        hashMap[2] = "Salavat"
        hashMap[3] = "Fatiha"
        hashMap[4] = "Felak"
        hashMap[5] = "Fetih"
        hashMap[6] = "Fil"
        hashMap[7] = "Kafirun"
        hashMap[8] = "Kevser"
        hashMap[9] = "Kureyş"
        hashMap[10] = "Maun"
        hashMap[11] = "İhlas"
        hashMap[12] = "Nas"
        hashMap[13] = "Nasr"
        hashMap[14] = "Tebbet"

        for (key in hashMap.keys) {
            println("Element at key $key = ${hashMap[key]}")
        }

        spinner = findViewById(R.id.spinner)
        val lessonsList: MutableList<String> =
            mutableListOf(
                "Sure seçin",
                "Ayetel Kürsi",
                "Salavat",
                "Fatiha",
                "Felak",
                "Fetih",
                "Fil",
                "Kafirun",
                "Kevser",
                "Kureyş",
                "Maun",
                "İhlas",
                "Nas",
                "Nasr",
                "Tebbet",
            )


        val adapter =
            ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_item, lessonsList)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        spinner.adapter = adapter


        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                okunacakSure = hashMap[p2].toString()

                Toast.makeText(this@MainActivity, okunacakSure, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@MainActivity, "Herhangi bir sure seçilmedi", Toast.LENGTH_SHORT)
                    .show()
            }
        }
*/
        val buttonClick = findViewById<Button>(R.id.buttonKaydet)

        buttonClick.setOnClickListener {
            sayi = editText.text.toString()
            if (sayi.isEmpty()) {
                Toast.makeText(
                    this@MainActivity,
                    "Lütfen bir sayı girin",
                    Toast.LENGTH_LONG
                )
                    .show()
            } else {
                if (sayi == "0") {
                    Toast.makeText(this, "Lütfen sıfırdan farklı bir sayı girin", Toast.LENGTH_LONG)
                        .show()
                } else {
                    val intent = Intent(this, AnasayfaActivity::class.java)

                    intent.putExtra("Sayi", sayi)
                    startActivity(intent)
                }
            }


        }


    }


}
