package com.example.sipress.ui.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.sipress.R
import com.example.sipress.data.SchoolData
import com.example.sipress.databinding.CheckNisFragmentBinding
import com.example.sipress.ui.viewModel.CheckNISViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckNISFragment : Fragment() {

    companion object {
        fun newInstance() = CheckNISFragment()
        private const val TAG = "CheckNISFragment"
    }

    private val viewModel: CheckNISViewModel by viewModels()
    private lateinit var binding:CheckNisFragmentBinding
    private lateinit var loadingDialog : AlertDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CheckNisFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loadingLayout = LayoutInflater.from(requireContext()).inflate(R.layout.loading_layout, null, false)
        loadingDialog = AlertDialog.Builder(requireContext())
                .setView(loadingLayout)
                .create()

        viewModel.loadSchoolList()
    }


    override fun onResume() {
        super.onResume()
        viewModel.schoolList.observe(viewLifecycleOwner, {schoolList:List<SchoolData>? ->
            binding.moreSchoolButton.setOnClickListener {
                if (schoolList.isNullOrEmpty()){
                    loadingDialog.show()
                }else{
                    viewModel.showSearchSchoolDialog(requireView(), schoolList)
                }
            }
        })
    }

}