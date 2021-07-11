package com.darshan.merchant.orders.view.adapter

import androidx.recyclerview.widget.RecyclerView
import com.darshan.merchant.R
import com.darshan.merchant.core.imageloader.ImageLoader
import com.darshan.merchant.databinding.OrderItemBinding
import com.darshan.merchant.orders.model.Order

class OrderViewHolder(
    private val binding: OrderItemBinding,
    private val imageLoader: ImageLoader
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(order: Order) {
        binding.orderId.text = binding.root.resources.getString(R.string.order_id, order.id)
        binding.orderTime.text = order.createdAt.toString()
        binding.remainingTime.text = "2 mins"
        binding.totalItems.text = order.quantity.toString()
    }

}