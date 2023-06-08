package com.assign.imgur

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.assign.imgur.databinding.ActivityMainBinding
import com.assign.imgur.utils.AppDelegate
import com.assign.imgur.utils.Constants
import com.assign.imgur.utils.Status
import com.assign.imgur.view.TopImagesFragment
import com.assign.imgur.viewmodels.GalleryViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewmodel: GalleryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        AppDelegate.getInstance().saveClientID(Constants.CLIENT_ID)

        supportFragmentManager.beginTransaction()
            .replace(binding.container.id, TopImagesFragment())
            .commitNow()
    }
}