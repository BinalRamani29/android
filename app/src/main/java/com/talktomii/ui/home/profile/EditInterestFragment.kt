package com.talktomii.ui.home.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.talktomii.R
import com.talktomii.databinding.EditInterestFragmentBinding
import com.talktomii.ui.tellusmore.TellUsMoreVM
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class EditInterestFragment : DaggerFragment(R.layout.edit_interest_fragment) {
    private lateinit var binding: EditInterestFragmentBinding

    private val viewModels by viewModels<TellUsMoreVM>()

    @Inject
    lateinit var viewModel: TellUsMoreVM


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EditInterestFragmentBinding.inflate(inflater, container, false)
        binding.vm = viewModels
        return binding.root


    }

    private fun setListener() {
        binding.txtBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setListener()
        binding.vm = viewModels
        val recyclerview = binding.rvTopics
//        viewModels.isUser.set(args.isUser)

        val layoutManager = FlexboxLayoutManager()
        layoutManager.flexWrap = FlexWrap.WRAP
        layoutManager.flexDirection = FlexDirection.ROW
        recyclerview.layoutManager = layoutManager
    }

}