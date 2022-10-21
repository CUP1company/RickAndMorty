package com.project.rickandmorty.presentation.listOfcharacter

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.project.rickandmorty.R
import com.project.rickandmorty.databinding.FragmentListOfCharactorsBinding

class ListOfCharactors : Fragment(R.layout.fragment_list_of_charactors) {

    private var _binding: FragmentListOfCharactorsBinding? = null
    private val binding get() = _binding!!

    private lateinit var vm: ListOfCharactorsViewModel

    private val listCharct by lazy { ListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentListOfCharactorsBinding.bind(view)

        vm = ViewModelProvider(this)[ListOfCharactorsViewModel::class.java]

        vm.getCharacters()

        vm.listObjData.observe(viewLifecycleOwner, Observer {
            listCharct.setData(vm.listObjData.value!!)
            setupRecycleview()
        })



    }

    private fun setupRecycleview() {
        binding.listObj.adapter = listCharct
        binding.listObj.layoutManager =
            LinearLayoutManager(context, OrientationHelper.VERTICAL, false)
    }


}