package com.lixinxinlove.androidapi.ui.adapter

import androidx.viewbinding.ViewBinding
import androidx.recyclerview.widget.RecyclerView

class BaseTapViewHolder<T : ViewBinding>(var viewBinding: T) : RecyclerView.ViewHolder(
    viewBinding.root
)