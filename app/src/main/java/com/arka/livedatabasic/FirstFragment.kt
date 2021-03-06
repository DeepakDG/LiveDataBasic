package com.arka.livedatabasic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.arka.livedatabasic.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private lateinit var mainActivityViewModel:MainActivityViewModel
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mainActivityViewModel= ViewModelProvider(this).get(MainActivityViewModel::class.java)
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var count: LiveData<Int> = mainActivityViewModel.getInitialCount()

        count.observe(viewLifecycleOwner, Observer {
            binding.textviewFirst.text = it.toString()
        })
        binding.buttonFirst.setOnClickListener {
            mainActivityViewModel.getCurrentCount()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}