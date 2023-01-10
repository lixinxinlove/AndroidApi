package com.lixinxinlove.androidapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lixinxinlove.androidapi.databinding.ItemHomeListViewBinding

class HomeListAdapter(private val mList: List<String>, val onItemClick: (String) -> Unit) :
    RecyclerView.Adapter<BaseTapViewHolder<ItemHomeListViewBinding>>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseTapViewHolder<ItemHomeListViewBinding> {
        return BaseTapViewHolder(
            ItemHomeListViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: BaseTapViewHolder<ItemHomeListViewBinding>,
        position: Int
    ) {
        holder.viewBinding.titleText.text = mList[position]

        holder.viewBinding.titleText.setOnClickListener {
            onItemClick(mList[position])
        }

    }


    override fun getItemCount(): Int {
        return mList.size
    }


}