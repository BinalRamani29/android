package com.talktomii.ui.home.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.talktomii.databinding.FragmentNotificationsBinding
import com.talktomii.ui.home.HomeViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class NotificationFragment : DaggerFragment() {

    private lateinit var binding: FragmentNotificationsBinding


    @Inject
    lateinit var viewModel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        return binding.root

    }

    private fun setListener() {


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvTodayNotifi.adapter = AdapterTodayNotification()
        binding.rvYesterdayNotification.adapter = AdapterYesterdayNotification()
        setListener()
    }
}