package com.example.belajarintent

import android.app.Notification.EXTRA_TEXT
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat.EXTRA_TEXT
import android.view.View
import android.widget.Button


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnIntent  : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIntent = findViewById(R.id.btn_intent)
        val btnIntentData = findViewById<Button>(R.id.btn_pindah_data)
        val btnIntentObjek = findViewById<Button>(R.id.btn_pindah_objek)

        btnIntent.setOnClickListener(this)
        btnIntentData.setOnClickListener(this)
        btnIntentObjek.setOnClickListener(this)

     }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_intent ->{
                val intentBiasa = Intent(this@MainActivity, PindahActivity::class.java)
                startActivity(intentBiasa)
            }
            R.id.btn_pindah_data -> run {
                val intentData = Intent(this@MainActivity, PindahDataActivity::class.java)
                intentData.putExtra(PindahDataActivity.EXTRA_TEXT,
                    "nama : Eddy Marthin Sirait" +
                          "nim : 2110031802051" +
                          "prodi : Teknik Informatika TI")
                startActivity(intentData)
            }
            R.id.btn_pindah_objek -> run {
                val  cars = Cars(
                    "Toyota Yaris",
                    2020,
                    "BM 2020 SAR"
                )
                val intentObject = Intent(this@MainActivity, PindahObjekActivity::class.java)
                intentObject.putExtra(PindahObjekActivity.EXTRA_CARS, cars)
                startActivity(intentObject)
            }
            }

    }
}