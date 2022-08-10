package com.example.a12myhomework2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
import com.example.a12myhomework2.adapter.MyExpendAdapter
import com.example.a12myhomework2.databinding.ActivityMainBinding
import com.example.a12myhomework2.databinding.ItemChildBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_child.*

class MainActivity : AppCompatActivity() {

      lateinit var map: HashMap<String,ArrayList<Malumot>>
      lateinit var titlelist:ArrayList<String>
      lateinit var myExpendAdapter: MyExpendAdapter



      private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)







        loadDate()


        myExpendAdapter= MyExpendAdapter(map,titlelist)
        binding.expendView.setAdapter(myExpendAdapter)
    }

    private fun loadDate() {
        map= HashMap()
        titlelist= ArrayList()
        titlelist.add("Mobiles")
        val mobillist= arrayListOf(Malumot("MI","GKWGS KUGKUKv kgkgk kgkg"),
            Malumot("Realmi","GKWGS KUGKUKv kgkgk kgkg"),
            Malumot("Iphone","GKWGS KUGKUKv kgkgk kgkg"),
            Malumot("Huawei","GKWGS KUGKUKv kgkgk kgkg"))

        titlelist.add("Laptops")
        val laptoplist= arrayListOf(Malumot("Msi","Acer"),
          Malumot("Hp","dbsjfbjjnjbjdn"),
          Malumot("Lenova","dbsjfbjjnjbjdn"),
          Malumot("Mac","dbsjfbjjnjbjdn"))

        titlelist.add("Computer Accessories")
        val laptopaccesslist= arrayListOf(Malumot("Pendrive","jjjcsjnjn"),
          Malumot("Mouse","kkndkfdkke"),
          Malumot("Kuller","kkndkfdkke"),
          Malumot("Klaviratura","kkndkfdkke"))


        titlelist.add("Home Entertainment")
        val homeentertainlist= arrayListOf(Malumot("Pendrive","Bag"))



        titlelist.add("TVs by brand")
        val tvslist= arrayListOf(Malumot("Pendrive","Bag"))

        map[titlelist[0]]=mobillist
        map[titlelist[1]]=laptoplist
        map[titlelist[2]]=laptopaccesslist
        map[titlelist[3]]=homeentertainlist
        map[titlelist[4]]=tvslist




        expend_view.setOnChildClickListener(object :ExpandableListView.OnChildClickListener{
            override fun onChildClick(
                p0: ExpandableListView?,
                p1: View?,
                p2: Int,
                p3: Int,
                p4: Long
            ): Boolean {
                 val intent=Intent(this@MainActivity,MainActivity2::class.java)
                intent.putExtra("Keyiname",map[titlelist[p2]]?.get(p3)?.text)
                intent.putExtra("Keyinfo",map[titlelist[p2]]?.get(p3)?.info)
                startActivity(intent)
                return false
            }


        })




    }
}