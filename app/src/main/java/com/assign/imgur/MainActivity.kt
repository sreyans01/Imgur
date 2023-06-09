package com.assign.imgur

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.assign.imgur.databinding.ActivityMainBinding
import com.assign.imgur.utils.AppDelegate
import com.assign.imgur.utils.Constants
import com.assign.imgur.fragments.TopImagesFragment
import com.assign.imgur.viewmodels.GalleryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewmodel: GalleryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //Storing the client id in App Delegate singleton for later use in the app.
        AppDelegate.getInstance().saveClientID(Constants.CLIENT_ID)

        //As its a single fragment here, so directly binding it by default.
        supportFragmentManager.beginTransaction()
            .replace(binding.container.id, TopImagesFragment())
            .commitNow()
    }
}