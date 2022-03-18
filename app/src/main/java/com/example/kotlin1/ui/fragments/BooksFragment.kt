package com.example.kotlin1.ui.fragments

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin1.R
import com.example.kotlin1.databinding.FragmentBooksBinding
import com.example.kotlin1.ui.adapters.BooksAdapter
import com.example.kotlin1.ui.base.BaseFragment
import com.example.kotlin1.ui.model.BookModel


class BooksFragment : BaseFragment<FragmentBooksBinding>(
    R.layout.fragment_books
) {
    override val binding: FragmentBooksBinding by viewBinding(FragmentBooksBinding::bind)
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val adapter = BooksAdapter { BookModel -> onClick(BookModel) }

    override fun setupViews() {
        initAdapter()
    }

    private fun initAdapter() {
        adapter.setList(sharedViewModel.getBooks())
        binding.recyclerview.adapter = adapter

    }

    private fun onClick(model: BookModel) {
        sharedViewModel.putDescription(model.description)
        findNavController().navigate(R.id.booksDetailsFragment)

    }


}


