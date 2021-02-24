package com.example.keyevents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.KeyEvent
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private  lateinit var txtHistories: EditText
    private lateinit var btnClear : AppCompatButton
    private var historyStr =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtHistories= findViewById(R.id.txt_histories)
        btnClear = findViewById(R.id.btn_clear)
        txtHistories.setOnKeyListener { _, keyCode, event ->
            var keyCodeHex = java.lang.Integer.toHexString(keyCode)
            var color =""
            when(event.action){
                KeyEvent.ACTION_DOWN->{
                    color="00FF00"
                }
                KeyEvent.ACTION_UP->{
                    color ="FF0000"
                }
            }
            historyStr += "<font color= '#$color'>$keyCodeHex</font><br>"
            val sb = StringBuilder()
            sb.append(historyStr)

            txtHistories.setText(Html.fromHtml(sb.toString()))
            txtHistories.movementMethod = LinkMovementMethod.getInstance()
            return@setOnKeyListener false
        }
        btnClear.setOnClickListener {
            historyStr=""
            txtHistories.setText(historyStr)
        }
    }
}