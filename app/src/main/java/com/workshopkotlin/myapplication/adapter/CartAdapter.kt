package com.workshopkotlin.myapplication.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.workshopkotlin.myapplication.R
import com.workshopkotlin.myapplication.data.entity.ProductUserPurchase
import kotlinx.android.synthetic.main.row_item_purchase.view.*

class CartAdapter(private val cartList: MutableList<ProductUserPurchase>) :
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindViewHolder(productUserPurchase: ProductUserPurchase) {
            with(itemView) {
                tv_product_title.text = productUserPurchase.productEntity.namaProduk
                tv_product_price.text = productUserPurchase.productEntity.hargaProduk
                tv_product_shipping_address.text = productUserPurchase.purchaseEntity.shippingAddress
            }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CartAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.row_item_purchase, p0, false))
    }

    override fun getItemCount(): Int = cartList.size

    override fun onBindViewHolder(p0: CartAdapter.ViewHolder, p1: Int) {
        p0.bindViewHolder(cartList[p1])
    }
}