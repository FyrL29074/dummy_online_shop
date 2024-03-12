package com.fyrl29074.productslist.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.fyrl29074.productslist.databinding.FragmentProductsListBinding
import com.fyrl29074.productslist.presentation.recyclerView.ProductsAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductsListFragment : Fragment() {

    private var _binding: FragmentProductsListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProductsListViewModel by viewModel()
    private val productsAdapter = ProductsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        initFlow()
    }

    private fun initUi() {
        binding.products.adapter = productsAdapter
    }

    private fun initFlow() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect { state ->
                handleState(state)
            }
        }
    }

    private fun handleState(state: State) {
        when (state) {
            is State.Loading -> {
                binding.progressBar.isVisible = true
            }

            is State.Loaded -> {
                binding.progressBar.isVisible = false
                viewModel.pagedProducts.onEach { products ->
                    productsAdapter.submitData(products)
                }.launchIn(viewLifecycleOwner.lifecycleScope)
            }

            is State.Error -> {
                binding.progressBar.isVisible = false
                Toast.makeText(
                    requireContext(),
                    state.message,
                    Toast.LENGTH_SHORT
                ).show()
            }

            is State.Waiting -> {
                viewModel.getProductsByPage(FIRST_PAGE)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val FIRST_PAGE = 1
    }
}