package com.example.payoo.ui.view.diskon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.payoo.R

class DiskonFragment : Fragment() {

    companion object {
        fun newInstance() = DiskonFragment()
    }

    private lateinit var viewModel: DiskonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_diskon, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DiskonViewModel::class.java)
        // TODO: Use the ViewModel
    }

}