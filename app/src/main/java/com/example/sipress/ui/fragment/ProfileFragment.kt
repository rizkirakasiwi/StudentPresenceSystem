package com.example.sipress.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sipress.databinding.ProfileFragmentBinding
import com.example.sipress.ui.viewModel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private val viewModel: ProfileViewModel by viewModels()
    private lateinit var binding : ProfileFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = ProfileFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewPagerAdapter(this, viewModel.listFragment).observe(viewLifecycleOwner, {fragmentStateAdapter->
            binding.viewPagerProfile.adapter = fragmentStateAdapter
        })

        viewModel.tabLayoutMediator(binding.viewPagerProfile,binding.tabProfile,viewModel.tabText).observe(viewLifecycleOwner, {tabMediator->
            tabMediator.attach()
        })

    }




}