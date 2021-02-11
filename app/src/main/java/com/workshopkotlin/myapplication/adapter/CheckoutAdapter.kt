package com.workshopkotlin.myapplication.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.workshopkotlin.myapplication.R
import com.workshopkotlin.myapplication.data.entity.PurchaseEntity

class CheckoutAdapter(val checkoutList: MutableList<PurchaseEntity>)
    :RecyclerView.Adapter<CheckoutAdapter.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bindViewHolder(purchaseEntity: PurchaseEntity) {
            with(itemView){
//                tv_product_title.text = purchaseEntity
            }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CheckoutAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.row_item_product, p0, false))
    }

    override fun getItemCount(): Int = checkoutList.size

    override fun onBindViewHolder(p0: CheckoutAdapter.ViewHolder, p1: Int) {
        p0.bindViewHolder(checkoutList[p1])
    }
}