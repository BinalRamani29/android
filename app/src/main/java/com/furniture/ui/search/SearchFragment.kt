package com.furniture.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.furniture.data.model.Interest
import com.furniture.data.model.Payload
import com.furniture.databinding.SearchFragmentBinding
import com.furniture.interfaces.CommonInterface
import com.furniture.interfaces.SearchInterface
import com.furniture.interfaces.SearchItemClick
import com.furniture.viewmodel.SearchViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SearchFragment : DaggerFragment(), SearchInterface, CommonInterface, SearchItemClick {

    private lateinit var binding: SearchFragmentBinding

    @Inject
    lateinit var viewModel: SearchViewModel
    private var adapterCategories: AdapterCategories? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = SearchFragmentBinding.inflate(inflater, container, false)
        initAdapter()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun initAdapter() {
        adapterCategories = AdapterCategories(requireContext(), this)
//        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//        layoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
//        binding.rvCategories.layoutManager = layoutManager
        binding.rvCategories.adapter = adapterCategories

    }

    private fun init() {
        viewModel.searchInterface = this
        viewModel.commonInterface = this
        viewModel.getAllInstruction()
    }

    override fun onStarted() {

    }

    override fun onFailure(message: String) {
    }

    override fun onSearchAllInstruction(data: Payload) {
        adapterCategories!!.setImagesList(data.interest)
    }

    override fun onViewSearchClick(interest: Interest) {
        view?.findNavController()
            ?.navigate(SearchFragmentDirections.actionSearchFragmentToHomeFragment(interest._id))

    }
}