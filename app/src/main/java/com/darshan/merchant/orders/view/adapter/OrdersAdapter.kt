package com.darshan.merchant.orders.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.darshan.merchant.R
import com.darshan.merchant.core.imageloader.ImageLoader
import com.darshan.merchant.databinding.OrderItemBinding
import com.darshan.merchant.orders.model.Order
import javax.inject.Inject

class OrdersAdapter @Inject constructor(
    private val imageLoader: ImageLoader,
    private val layoutInflater: LayoutInflater
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var clickCallback: (order: Order) -> Unit
    private var orders = emptyList<Order>()

    fun setOrders(orders: List<Order>) {
        this.orders = orders
        notifyDataSetChanged()
    }

    fun setOnClickListener(listener: (order: Order) -> Unit) {
        clickCallback = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = OrderItemBinding.inflate(layoutInflater, parent, false)
        return OrderViewHolder(binding, imageLoader)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val dealsListViewHolder = holder as? OrderViewHolder
        dealsListViewHolder?.bind(orders[position])
    }

    override fun getItemCount() = orders.size

    override fun getItemViewType(position: Int) = R.layout.order_item

}