package com.example.retrofit_1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.retrofit_1.R
import com.example.retrofit_1.data.models.Character
import com.example.retrofit_1.databinding.FragmentFirstBinding
import com.example.retrofit_1.ui.MyViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val myViewModel by activityViewModels<MyViewModel> {
        MyViewModel.MyViewModelFactory(requireContext())
    }
    private var page = 1
    private var totalPages = 0

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerview.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)

        val listAdapter = CharacterAdapter(object : CharacterAdapter.OnItemClickListener {
            override fun onItemClick(character: Character) {
                myViewModel.selectedCharacter.value = character
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        })

        binding.recyclerview.adapter = listAdapter

        myViewModel.charactersLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                listAdapter.updateList(it)
            }
        }

        myViewModel.infoLiveData.observe(viewLifecycleOwner) {
            totalPages = it.pages

            if(it.prev == null){
                binding.ivLeft.visibility = View.GONE
            } else {
                binding.ivLeft.visibility = View.VISIBLE
            }

            if (it.next == null) {
                binding.ivRight.visibility = View.GONE
            } else {
                binding.ivRight.visibility = View.VISIBLE
            }
        }

        myViewModel.getCharacters()

        binding.butSend.setOnClickListener {
            val text = binding.etBuscar.text.toString()
            if (text.isNotEmpty()) {
                myViewModel.findForName(text)
            }
        }

        binding.ivLeft.setOnClickListener {
                page -= 1
                myViewModel.findPageNumber(page)
        }



        binding.ivRight.setOnClickListener {
                page += 1
                myViewModel.findPageNumber(page)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}