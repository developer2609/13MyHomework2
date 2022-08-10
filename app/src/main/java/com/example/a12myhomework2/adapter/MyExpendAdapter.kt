package com.example.a12myhomework2.adapter

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.a12myhomework2.Malumot
import com.example.a12myhomework2.databinding.ItemChildBinding
import com.example.a12myhomework2.databinding.ItemGroupBinding

class MyExpendAdapter(val map: HashMap<String,ArrayList<Malumot>>,val titleList:ArrayList<String>):
BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return titleList.size
    }

    override fun getChildrenCount(p0: Int): Int {
        val group=titleList[p0]
        val childList=map[group]
        return childList?.size!!
    }

    override fun getGroup(p0: Int): Any {
        val group=titleList[p0]
        return group
    }

    override fun getChild(p0: Int, p1: Int): Any {
        val group=titleList[p0]
        val childList=map[group]
        return childList?.get(p1)!!
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        val itemGroup=ItemGroupBinding.inflate(LayoutInflater.from(p3?.context),p3,false)
        itemGroup.tvItemGroup.text=titleList[p0]
        return itemGroup.root
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        val itemChildBinding= ItemChildBinding.inflate(LayoutInflater.from(p4?.context),p4,false)
        val group=titleList[p0]
        val childList=map[group]
        itemChildBinding.tvItemChild.text=childList?.get(p1)?.text
        return itemChildBinding.root
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }


}