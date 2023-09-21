package com.example.imagesearchapp.ui.view

import android.os.Bundle
import android.provider.MediaStore.Images
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imagesearchapp.data.model.Document
import com.example.imagesearchapp.databinding.FragmentSearchBinding
import com.example.imagesearchapp.ui.adapter.ImageSearchAdapter
import com.example.imagesearchapp.ui.viewmodel.ImageSearchViewModel
import com.example.imagesearchapp.util.Constants.SEARCH_IMAGES_TIME_DELAY


class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding?= null
    private val binding get() = _binding!!

    private lateinit var imageSearchViewModel: ImageSearchViewModel
    private lateinit var imageSearchAdapter: ImageSearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater,container,false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageSearchViewModel = (activity as MainActivity).imageSearchViewModel

        setupRecyclerView()
        searchImages()

        imageSearchViewModel.searchResult.observe(viewLifecycleOwner) { response ->
            val images:List<Document> = response.documents
            Log.d("TAG", "onViewCreated: ${images}")
            imageSearchAdapter.submitList(images)
            Log.d("TAG", "onViewCreated: ${response}")
        }
    }

    private fun setupRecyclerView() {
        imageSearchAdapter = ImageSearchAdapter()
        binding.searchFragRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(requireContext(),2)
            adapter = imageSearchAdapter
        }
    }

    private fun searchImages(){
        var startTime = System.currentTimeMillis()
        var endTime: Long

        binding.searchFragEditSearch.text =
            Editable.Factory.getInstance().newEditable(imageSearchViewModel.query)

        binding.searchFragEditSearch.addTextChangedListener {text: Editable? ->
            endTime = System.currentTimeMillis()
            if (endTime - startTime >= SEARCH_IMAGES_TIME_DELAY) {
                text?.let {
                    val query = it.toString().trim()
                    if (query.isNotEmpty()) {
                        imageSearchViewModel.searchImages(query)
                        Log.d("TAG", "searchImages: ${imageSearchViewModel.searchImages(query)}")
                    }
                }
            }
            startTime=endTime
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}
