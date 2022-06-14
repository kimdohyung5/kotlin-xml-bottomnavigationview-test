package com.kimdo.bottomnavtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kimdo.bottomnavtest.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {

    private var _binding:FragmentInfoBinding? = null
    private val binding: FragmentInfoBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonGotoChild.setOnClickListener {
            findNavController().navigate(R.id.to_infoChild)
        }

        binding.buttonGotoSetting.setOnClickListener {
            val localActivity = requireActivity() as MainActivity
            localActivity.changeSelectedItemId( R.id.fragment_setting )
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}