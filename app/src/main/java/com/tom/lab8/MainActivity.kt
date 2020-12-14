package com.tom.lab8


import android.app.Activity
import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.util.Log

class MainActivity : AppCompatActivity() {
    //延遲初始化，kotlin要求每次聲明時，一定要先初始化。但是lateinit 可以先延遲初始化
    private lateinit var adapter:MyAdapter
    //以下的<Contact>型態，已經由最下面的Contact定義了

    //全域變數
    companion object{
        private val contacts = ArrayList<Contact>()
    }

    //使用onActivityResult取得資訊
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //可以使用let來處理陣列項目
        data?.extras?.let {
            if (requestCode==1 && resultCode == Activity.RESULT_OK){
                //原本name應該是Int，但是書上寫是String
                contacts.add(Contact(it.getString("name"),it.getString("phone")))
                adapter.notifyDataSetChanged()
                Log.e("MainActivity","有成功要到資料")

            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val btn_add = findViewById<Button>(R.id.btn_add)
        //實例化linearLayoutManager
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        //有時候沒畫面就是忘了把這個指派給linerLayoutManager
        recyclerView.layoutManager = linearLayoutManager
        adapter = MyAdapter(contacts)
        recyclerView.adapter = adapter
        btn_add.setOnClickListener{
            startActivityForResult(Intent(this,Main2Activity::class.java),1)
        }
    }
}
data class Contact(
    val name:String?,
    val phone:String?
)

