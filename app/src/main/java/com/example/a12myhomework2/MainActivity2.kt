package com.example.a12myhomework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.item_child.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

       val name2=intent.getStringExtra("Keyname")
       val name3=intent.getStringExtra("Keyinfo")

        text_nomi.text=name2
        text_info.text=name3

    }
}