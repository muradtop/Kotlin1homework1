package com.example.kotlin1.ui.fragments.books.detail

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin1.R
import com.example.kotlin1.databinding.FragmentBooksDetailsBinding
import com.example.kotlin1.ui.base.BaseFragment
import com.example.kotlin1.ui.fragments.books.SharedViewModel

import kotlinx.coroutines.launch

class BooksDetailsFragment : BaseFragment<FragmentBooksDetailsBinding>(
    R.layout.fragment_books_details
) {
    override val binding: FragmentBooksDetailsBinding by viewBinding(FragmentBooksDetailsBinding::bind)
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun setupViews() {
        viewLifecycleOwner.lifecycleScope.launch {
            sharedViewModel.description.observe(viewLifecycleOwner) { description -> binding.tvDescription.text = description.toString()
            }
        }
    }
}