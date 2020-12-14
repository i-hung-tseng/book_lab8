package com.tom.lab8

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tom.lab8.R
import android.util.Log


class Main2Activity : AppCompatActivity() {

    override fun onCreate(saveInstanceState: Bundle?){
        super.onCreate(saveInstanceState)
        setContentView(R.layout.activity_main2)
        val btn_send = findViewById<Button>(R.id.btn_send)
        val ed_name  = findViewById<EditText>(R.id.ed_name)
        val ed_phone = findViewById<EditText>(R.id.ed_phone)

        btn_send.setOnClickListener{
            when{
                ed_name.length()<1-> Toast.makeText(this,"請輸入姓名",Toast.LENGTH_SHORT).show()
                ed_phone.length()<1-> Toast.makeText(this,"請輸入電話",Toast.LENGTH_SHORT).show()
                else->{
                    val b = Bundle()
                    b.putString("name",ed_name.text.toString())
                    b.putString("phone",ed_phone.text.toString())
                    setResult(Activity.RESULT_OK,Intent().putExtras(b))
                    finish()
                    Log.e("Main2Activity","btn_send有進去btn_send")
                }
            }
        }
    }
}

