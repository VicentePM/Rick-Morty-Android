package com.example.retrofit_1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.retrofit_1.R
import com.example.retrofit_1.databinding.FragmentSecondBinding
import com.example.retrofit_1.ui.MainActivity
import com.example.retrofit_1.ui.MyViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private val myViewModel: MyViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel.selectedCharacter.observe(viewLifecycleOwner) {
            (requireActivity() as MainActivity).supportActionBar?.title = it.name
            binding.tvName.text = it.name
            Glide.with(this).load(it.image).into(binding.ivImage)

            binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerview.adapter = ChaptersAdapter(it.episode)

            binding.tvStatus.text = it.status
            binding.tvSpecies.text = it.species
            binding.tvOrigin.text = it.origin.name
            binding.tvLocation.text = it.location.name
            binding.tvGender.text = it.gender
        }
    }
}