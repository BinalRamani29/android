package com.furniture.ui.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
    private val search: String = ""
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
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
        binding.rvCategories.adapter = adapterCategories
    }

    private fun init() {
        viewModel.searchInterface = this
        viewModel.commonInterface = this
        viewModel.getAllInstruction(search)

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                viewModel.getAllInstruction(binding.etSearch.text.toString())
            }

        })
    }

    override fun onStarted() {

    }

    override fun onFailure(message: String) {
    }

    override fun onSearchAllInstruction(data: Payload) {
        adapterCategories?.interestArrayList = arrayListOf()
        adapterCategories!!.setImagesList(data.interest)
    }

    override fun onViewSearchClick(interest: Interest) {
        view?.findNavController()
            ?.navigate(SearchFragmentDirections.actionSearchFragmentToHomeFragment(interest._id))

    }
}