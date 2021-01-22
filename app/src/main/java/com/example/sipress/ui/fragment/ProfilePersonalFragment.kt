package com.example.sipress.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sipress.R
import com.example.sipress.databinding.ProfilePersonalFragmentBinding
import com.example.sipress.ui.viewModel.ProfilePersonalViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfilePersonalFragment : Fragment() {

    companion object {
        fun newInstance() = ProfilePersonalFragment()
    }

    private lateinit var viewModel: ProfilePersonalViewModel
    private lateinit var binding : ProfilePersonalFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProfilePersonalFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfilePersonalViewModel::class.java)
        // TODO: Use the ViewModel
    }

}