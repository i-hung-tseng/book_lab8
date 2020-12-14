package com.tom.lab8

import android.media.Image
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text




//使用朝狀class，<裡面是泛型，傳遞型別>另外，Contact是一個型別?
class MyAdapter(private val contacts:ArrayList<Contact>):RecyclerView.Adapter<MyAdapter.ViewHolder>()
//實作RecyclerView並且緩存View，以下的v是幹嘛的
{class ViewHolder( v:View):RecyclerView.ViewHolder(v){

    val tv_name = v.findViewById<TextView>(R.id.tv_name)
    val tv_phone = v.findViewById<TextView>(R.id.tv_phone)
    val img_delete = v.findViewById<ImageView>(R.id.img_delete)
}

    //創建新的ViewHolder，並連接畫面
    //需要回傳的型態是ViewHolder
    override fun onCreateViewHolder(viewGroup:ViewGroup,position:Int)
            :ViewHolder {
        //對於一個沒有被載入或者想要動態載入的介面，都需要使用LayoutInflater.inflate()來載入
        //有被載入的是指，有在onCreate() 下面顯示的，沒有的話則需要透過動態加載，或是其他Actviity去加載
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.adapter_row, viewGroup, false)
        //為何ViewHolder()裡面可以有v
        return ViewHolder(v)
    }
     override fun getItemCount()= contacts.size

     override fun onBindViewHolder(holder:ViewHolder,position:Int){

         //依照位置去顯示字
         holder.tv_name.text= contacts[position].name
         holder.tv_phone.text =contacts[position].phone
         holder.img_delete.setOnClickListener{

             //removeAt(position)根據行的索引來刪除，為何這邊是用()而不是[]
             contacts.removeAt(position)
             //更新列表
             notifyDataSetChanged()
         }
    }
}


