package com.assign.imgur.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.assign.imgur.GalleryTopWeekImages
import com.assign.imgur.ImageData
import com.assign.imgur.R
import com.assign.imgur.adapters.ImagesAdapter
import com.assign.imgur.databinding.FragmentTopImagesBinding
import com.assign.imgur.utils.Resource
import com.assign.imgur.utils.Status
import com.assign.imgur.utils.Utils
import com.assign.imgur.viewmodels.GalleryViewModel


class TopImagesFragment : Fragment() {

    private lateinit var binding: FragmentTopImagesBinding
    private lateinit var topWeekImagesObserver: Observer<Resource<GalleryTopWeekImages>>
    private var adapter: ImagesAdapter? = null
    private var galleryTopWeekImages: GalleryTopWeekImages? = null

    private val viewmodel: GalleryViewModel by activityViewModels()

    companion object {
        const val TAG = "TopImagesFragment"
        fun newInstance() = TopImagesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_top_images, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleListeners()
        initData()
    }

    private fun handleListeners() {

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // Perform search or filter operation here based on the submitted query
                val searchedData = queryImagesData(query, galleryTopWeekImages?.data)
                adapter?.setList(searchedData)
                adapter?.notifyDataSetChanged()
                Log.i("KKKKKKK",query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // Perform live search or filtering as the text changes
                return true
            }
        })


    }

    private fun initData() {
        topWeekImagesObserver = Observer { response ->
            when(response.status) {
                Status.SUCCESS -> {
                    galleryTopWeekImages = response.data
                    updateUI()
                }
                Status.ERROR -> {

                }
                Status.LOADING -> {

                }
            }
        }
        viewmodel.getGalleryTopWeekImages().observe(requireActivity(), topWeekImagesObserver)
    }

    private fun updateUI() {
        initRecyclerView(galleryTopWeekImages)
    }


    private fun initRecyclerView(galleryTopWeekImages: GalleryTopWeekImages?) {
        galleryTopWeekImages?.let {
            val topWeekImagesData = galleryTopWeekImages.data
            adapter = ImagesAdapter(requireContext(), getFilteredImagesData(topWeekImagesData))
            binding.imagesRecyclerView.setAdapter(adapter)
        }
    }

    /**
     * Used to filter out the ImageData ArrayList not containing any image
     *
     */
    private fun getFilteredImagesData(imagesData: ArrayList<ImageData>): ArrayList<ImageData> {
        val filteredImagesData = ArrayList<ImageData>()
        for (imageData in imagesData) {
            if (imageData.images.isNotEmpty())
                filteredImagesData.add(imageData)
        }
        return filteredImagesData
    }

    private fun queryImagesData(query: String, imagesData: ArrayList<ImageData>?): ArrayList<ImageData> {
        var filteredImagesData = ArrayList<ImageData>()
        val similarityMap = hashMapOf<ImageData, Double>()
        imagesData?.let {
            for (imageData in imagesData) {
                if (imageData.images.isNotEmpty()) {
                    val similarity = Utils.findSimilarity(imageData.title.toString(), query)
                    similarityMap.put(imageData, similarity)
                }
            }

            val sortedMap = similarityMap.toList().sortedByDescending { (_,similarity) -> similarity }.toMap()
            filteredImagesData = ArrayList(sortedMap.keys.toList())
        }
        return filteredImagesData
    }
}