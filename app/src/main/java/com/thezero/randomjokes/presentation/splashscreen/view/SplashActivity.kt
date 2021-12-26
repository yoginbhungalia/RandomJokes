package com.thezero.randomjokes.presentation.splashscreen.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.thezero.randomjokes.app.RandomJokesApp
import com.thezero.randomjokes.databinding.ActivitySplashBinding
import com.thezero.randomjokes.presentation.mainscreen.view.MainActivity
import com.thezero.randomjokes.presentation.splashscreen.viewmodel.SplashViewModel
import android.animation.ValueAnimator
import android.animation.ValueAnimator.AnimatorUpdateListener


// This will require migrating to SplashScreen API for better experience on Android 12+.
// Compact version is still in alpha and also it does not support much customisation except for branding.
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    private lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // initialize view models
        initViewModels()

        // observe live data of view models
        observeLiveData()

        // start initializing application data
        splashViewModel.initializeApplication()

        // set views with data
        setupViews()
    }

    private fun initViewModels() {
        splashViewModel = ViewModelProvider(this)[SplashViewModel::class.java]
    }

    private fun observeLiveData() {
        splashViewModel.applicationInitialized.observe(this, { isInitialized ->
            isInitialized?.let {
                if (it) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        })
    }

    private fun setupViews() {
        binding.textViewCounter.text = RandomJokesApp.localPreference?.noOfTimesAppOpens.toString()
    }
}