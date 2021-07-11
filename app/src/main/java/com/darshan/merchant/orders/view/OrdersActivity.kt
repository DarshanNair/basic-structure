package com.darshan.merchant.orders.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.darshan.merchant.databinding.ActivityOrdersBinding
import com.darshan.merchant.orders.view.adapter.OrdersAdapter
import com.darshan.merchant.orders.viewmodel.OrdersViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class OrdersActivity : AppCompatActivity() {

    enum class UIState {
        LOADING,
        LOADED
    }

    private lateinit var binding: ActivityOrdersBinding

    @Inject
    lateinit var ordersViewModel: OrdersViewModel

    @Inject
    lateinit var ordersAdapter: OrdersAdapter

    @Inject
    lateinit var ordersLayoutManager: RecyclerView.LayoutManager

    @Inject
    lateinit var dividerItemDecoration: DividerItemDecoration

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)

        binding = ActivityOrdersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        ordersViewModel.apply {
            state.observe(this@OrdersActivity, { it?.let { onDealsLoaded(it) } })
            loadOrders()
        }
    }

    private fun setupRecyclerView() {
        with(binding.viewOrdersLoaded.recyclerView) {
            layoutManager = ordersLayoutManager
            adapter = ordersAdapter
            addItemDecoration(dividerItemDecoration)
        }
    }

    private fun onDealsLoaded(state: OrdersViewModel.State) {
        when (state) {
            OrdersViewModel.State.Loading -> {
                binding.viewFlipperOrders.displayedChild = UIState.LOADING.ordinal
            }
            is OrdersViewModel.State.Success -> {
                binding.viewFlipperOrders.displayedChild = UIState.LOADED.ordinal
                ordersAdapter.setOrders(state.orders)
            }
        }
    }

}
