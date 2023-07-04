package com.yigitbal.kotlincounterv1


import android.app.AlertDialog
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class AnasayfaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anasayfa)

        val kalanMiktarEditText = findViewById<TextView>(R.id.kalanMiktarText)
        val okunanMiktarEditText = findViewById<TextView>(R.id.okunanMiktarText)
        val builder = AlertDialog.Builder(this)




        val gelenSayi = intent.getStringExtra("Sayi")
        println(gelenSayi)
        var kalanSayi: Int
        kalanSayi = gelenSayi!!.toInt()
        var okunanSayi = 0

        kalanMiktarEditText.text = "Kalan: $kalanSayi"
        okunanMiktarEditText.text = "0"


        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


        val buttonGeri = findViewById<Button>(R.id.buttonGeri)
        buttonGeri.setOnClickListener {
            builder.setTitle("Geri dönmek istediğinize emin misiniz??")

            builder.setPositiveButton("Evet") { dialog, which ->
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
                Toast.makeText(this, "Geri dönüldü", Toast.LENGTH_LONG).show()
            }

            builder.setNegativeButton("Hayır") { dialog, which ->
                println("işlem_iptal")
            }
            builder.show()

        }

        val buttonArttir = findViewById<Button>(R.id.buttonArttir)
        buttonArttir.setOnClickListener {
            if (kalanSayi != 0) {
                kalanSayi = kalanSayi - 1
                okunanSayi = okunanSayi + 1
                if (kalanSayi == 0) {
                    Toast.makeText(this, "Bitti", Toast.LENGTH_LONG).show()
                    it.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                    val v = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        v.vibrate(
                            VibrationEffect.createOneShot(
                                500,
                                VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                        Log.e("titresim", "uzun")
                        builder.setTitle("Bitti. Başka zikir çekmek ister misiniz??")

                        builder.setPositiveButton("Evet") { dialog, which ->
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        }

                        builder.setNegativeButton("Hayır") { dialog, which ->
                            ActivityCompat.finishAffinity(this)
                        }
                        builder.show()
                    } else {
                        v.vibrate(500)
                        Log.e("titresim", "kisa")
                    }
                }
            }
            kalanMiktarEditText.text = "Kalan: $kalanSayi"
            okunanMiktarEditText.text = "$okunanSayi"

        }

        val buttonAzalt = findViewById<Button>(R.id.buttonAzalt)
        buttonAzalt.setOnClickListener {
            if (okunanSayi != 0) {
                kalanSayi = kalanSayi + 1
                okunanSayi = okunanSayi - 1
            } else {
                Toast.makeText(this,"Sıfırlandı",Toast.LENGTH_SHORT).show()


            }
            kalanMiktarEditText.text = "Kalan: $kalanSayi"
            okunanMiktarEditText.text = "$okunanSayi"

        }

        val buttonReset = findViewById<Button>(R.id.buttonReset)
        buttonReset.setOnClickListener {
            builder.setTitle("Sıfırlamak istediğinize emin misiniz??")

            builder.setPositiveButton("Evet") { dialog, which ->
                kalanSayi = gelenSayi.toInt()
                okunanSayi = 0
                kalanMiktarEditText.text = "Kalan: $kalanSayi"
                okunanMiktarEditText.text = "$okunanSayi"
                Toast.makeText(this, "Sıfırlandı", Toast.LENGTH_LONG).show()
            }

            builder.setNegativeButton("Hayır") { dialog, which ->
                Toast.makeText(
                    this,
                    "Hayır", Toast.LENGTH_SHORT
                ).show()
            }
            builder.show()


        }


    }
}