package com.example.bankingapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankingapp.R
import com.example.bankingapp.databinding.ItemTransactionBinding
import com.example.bankingapp.models.Transaction

class TransactionAdapter(private val transactions: List<Transaction>) :
    RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    class TransactionViewHolder(val binding: ItemTransactionBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val item = transactions[position]
        holder.binding.icon.setImageResource(item.iconRes)
        holder.binding.title.text = item.title
        holder.binding.category.text = item.category
        holder.binding.amount.text = item.amount

        holder.binding.title.setTextColor(holder.itemView.context.getColor(R.color.white))
        holder.binding.category.setTextColor(holder.itemView.context.getColor(R.color.backGroundcolorCategory))

        if(item.amount.startsWith("-")) {
            holder.binding.amount.setTextColor(holder.itemView.context.getColor(android.R.color.holo_red_dark))
        } else {
            holder.binding.amount.setTextColor(holder.itemView.context.getColor(android.R.color.holo_green_dark))
        }

    }

    override fun getItemCount(): Int = transactions.size
}

