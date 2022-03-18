package com.example.kotlin1.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin1.databinding.ItemBooksBinding
import com.example.kotlin1.ui.model.BookModel


class BooksAdapter(
    val onItemClick: (BookModel) -> Unit
) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {
    private var list: List<BookModel> = arrayListOf()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BooksViewHolder {
        return BooksViewHolder(
            ItemBooksBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    fun setList(list: List<BookModel>) {
        this.list = list
    }


    override fun getItemCount(): Int {
        return list.size
    }

    inner class BooksViewHolder(private val binding: ItemBooksBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(bookModel: BookModel) {
            binding.tvBooks.text = bookModel.title
            binding.imBooks.setImageResource(bookModel.image)
            binding.root.setOnClickListener {
                onItemClick(bookModel)
            }


        }


    }


}