package com.example.sipress.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.sipress.R
import com.example.sipress.databinding.CheckNisFragmentBinding
import com.example.sipress.ui.viewModel.CheckNISViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckNISFragment : Fragment() {

    companion object {
        fun newInstance() = CheckNISFragment()
    }

    private val viewModel: CheckNISViewModel by viewModels()
    private lateinit var binding:CheckNisFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CheckNisFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}