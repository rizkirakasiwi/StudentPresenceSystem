package com.example.sipress.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.sipress.R
import com.example.sipress.ui.viewModel.LandingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LandingFragment : Fragment() {

    companion object {
        fun newInstance() = LandingFragment()
    }

    private val viewModel: LandingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.landing_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.checkUserSessionLogin()
    }

    override fun onStart() {
        super.onStart()
        viewModel.currentUser.observe(viewLifecycleOwner, {
            if (it == null) {
                findNavController().navigate(
                    LandingFragmentDirections.actionLandingFragmentToLoginFragment()
                )
            }else{
                findNavController().navigate(
                    LandingFragmentDirections.actionLandingFragmentToHomeFragment()
                )
            }
        })
    }

}