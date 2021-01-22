package com.example.sipress.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sipress.R
import com.example.sipress.ui.viewModel.CheckNISViewModel

class CheckNISFragment : Fragment() {

    companion object {
        fun newInstance() = CheckNISFragment()
    }

    private lateinit var checkNISViewModel: CheckNISViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.check_nis_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        checkNISViewModel = ViewModelProvider(this).get(CheckNISViewModel::class.java)
        // TODO: Use the ViewModel
    }

}