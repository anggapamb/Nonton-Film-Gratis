package com.anggapambudi.nontonfilmgratis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import org.jetbrains.anko.sdk27.coroutines.onClick

class HelpActivity : AppCompatActivity() {

    private lateinit var backDev: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        backDev = findViewById(R.id.backDeveloper)

        backDev.onClick {
            finish()
        }

    }
}