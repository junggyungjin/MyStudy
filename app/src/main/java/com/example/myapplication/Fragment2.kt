package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.example.myapplication.databinding.FragmentTwoBinding

class Fragment2 : Fragment() {

    private var _binding : FragmentTwoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        Log.d("life_cycle", "F onCreateView")

        // 프라그먼트가 인터페이스를 처음으로 그릴 때 호출된다.
        // inflater -> 뷰를 그려주는 역할
        // container -> 부모뷰
//        return inflater.inflate(R.layout.fragment1, container, false)
        _binding = FragmentTwoBinding.inflate(inflater, container, false)
        return binding.root
    }
}