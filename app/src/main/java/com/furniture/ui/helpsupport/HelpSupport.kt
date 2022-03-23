package com.furniture.ui.helpsupport

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.furniture.databinding.HelpSupportBinding
import dagger.android.support.DaggerAppCompatActivity

class HelpSupport : DaggerAppCompatActivity(){

    private lateinit var binding: HelpSupportBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, com.furniture.R.layout.help_support)

        binding.tvhelpBack.setOnClickListener {
            finish()
        }

        binding.openchatBtn.setOnClickListener { 
            val intent = Intent(this,ChatSupportActivity::class.java)
            startActivity(intent)
        }
    }
}