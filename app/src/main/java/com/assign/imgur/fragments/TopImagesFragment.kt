package com.assign.imgur.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.assign.imgur.GalleryTopWeekImages
import com.assign.imgur.ImageData
import com.assign.imgur.R
import com.assign.imgur.adapters.ImagesAdapter
import com.assign.imgur.databinding.FragmentTopImagesBinding
import com.assign.imgur.utils.Constants
import com.assign.imgur.utils.Resource
import com.assign.imgur.utils.Status
import com.assign.imgur.viewmodels.GalleryViewModel


class TopImagesFragment : Fragment() {

    private lateinit var binding: FragmentTopImagesBinding
    private lateinit var topWeekImagesObserver: Observer<Resource<GalleryTopWeekImages>>
    private var adapter: ImagesAdapter? = null
    private var galleryTopWeekImages: GalleryTopWeekImages? = null
    private var filteredImageData = ArrayList<ImageData>()

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

    /**
     * Handles the listeners.
     */
    private fun handleListeners() {

        /**
         * Used to handle the query input in the searchview.
         * Filtering recyclerview items on submitting search query, i.e. clicking on the search icon on the keyboard after entering a query.
         * Resets the recyclerview in case the query text is empty.
         */

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // Perform search or filter operation here based on the submitted query
                if (query.isEmpty()) {
                    resetRecyclerView()
                }
                val searchedData = queryImagesData(query, filteredImageData)
                adapter?.setList(searchedData)
                adapter?.notifyDataSetChanged()
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // Perform live search or filtering as the text changes
                if (newText.isEmpty()) {
                    resetRecyclerView()
                }
                return true
            }
        })

        binding.searchView.setOnCloseListener {
            resetRecyclerView()
            false
        }

        /**
         * Handles the Gridview or Listview toggling of the recyclerview.
         */
        binding.toggleLayout.setOnClickListener {
            if (binding.imagesRecyclerView.layoutManager is GridLayoutManager) {
                binding.toggleLayout.setImageResource(R.drawable.ic_baseline_view_list_24)
                binding.imagesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
                adapter?.setViewType(Constants.VIEWTYPE_LIST)
            } else {
                binding.toggleLayout.setImageResource(R.drawable.ic_baseline_grid_view_24)
                binding.imagesRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
                adapter?.setViewType(Constants.VIEWTYPE_GRID)
            }
            binding.imagesRecyclerView.setAdapter(adapter)
        }

    }

    /**
     * Sets the observer and initializes the data to be fetched.
     * Observes the data and shows the status to the user.
     */
    private fun initData() {
        topWeekImagesObserver = Observer { response ->
            when (response.status) {
                Status.SUCCESS -> {
                    galleryTopWeekImages = response.data
                    filteredImageData = getFilteredImagesData(galleryTopWeekImages?.data)
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

    /**
     * Update the UI elements with the latest data available.
     */
    private fun updateUI() {
        initRecyclerView(getFilteredImagesData(galleryTopWeekImages?.data))
    }


    /**
     * Initializes the images recyclerview and instantiates the image adapter.
     * @param imagesData - The images data to be passed to the adapter to show it in the recycler view.
     */
    private fun initRecyclerView(imagesData: ArrayList<ImageData>) {
        if (imagesData.size > 0) {
            adapter = ImagesAdapter(requireContext(), imagesData)
            binding.imagesRecyclerView.setAdapter(adapter)
        }
    }

    /**
     * Used to filter out the ImageData ArrayList not containing any image.
     * @param imagesData - Images data list which is to be filtered
     * @return - A list of image data containing an image.
     */
    private fun getFilteredImagesData(imagesData: ArrayList<ImageData>?): ArrayList<ImageData> {
        val filteredImagesData = ArrayList<ImageData>()
        imagesData?.let {
            for (imageData in imagesData) {
                if (imageData.images.isNotEmpty()) {
                    if (imageData.images.first().link.toString().lowercase().endsWith("jpg")
                        || imageData.images.first().link.toString().lowercase().endsWith("png")
                    ) {
                        filteredImagesData.add(imageData)
                    }
                }
            }
        }
        return filteredImagesData
    }

    /**
     * Searches from the list of imagedata according to the query passed in the search.
     * It allows those image data which have a title which startsWith the query or contains the given query in order respectively.
     * @param query - Search query passed by the user.
     * @param imagesData - List of Images data which is to be queried.
     * @return - A filtered list of Images data according to the query entered by the user.
     */
    private fun queryImagesData(
        query: String,
        imagesData: ArrayList<ImageData>?,
    ): ArrayList<ImageData> {
        val filteredImagesData = ArrayList<ImageData>()
        imagesData?.let {
            for (imageData in imagesData) {
                if (imageData.images.isNotEmpty()) {
                    if (imageData.title.toString().lowercase().startsWith(query.lowercase())) {
                        filteredImagesData.add(imageData)
                    }
                }
            }
            for (imageData in imagesData) {
                if (imageData.images.isNotEmpty()) {
                    if (!imageData.title.toString().lowercase()
                            .startsWith(query.lowercase()) && imageData.title.toString().lowercase()
                            .contains(query.lowercase())
                    ) {
                        filteredImagesData.add(imageData)
                    }
                }
            }
        }
        return filteredImagesData
    }

    /**
     * Resets the recyclerview with the existing loaded data
     */
    private fun resetRecyclerView() {
        adapter?.setList(filteredImageData)
        adapter?.notifyDataSetChanged()
    }
}