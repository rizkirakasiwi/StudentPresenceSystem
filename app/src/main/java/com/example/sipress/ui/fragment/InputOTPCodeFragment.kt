package com.example.sipress.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sipress.R
import com.example.sipress.ui.viewModel.InputOTPCodeViewModel

class InputOTPCodeFragment : Fragment() {

    companion object {
        fun newInstance() = InputOTPCodeFragment()
    }

    private lateinit var viewModel: InputOTPCodeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.input_o_t_p_code_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InputOTPCodeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}