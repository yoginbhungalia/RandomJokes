package com.thezero.randomjokes.presentation.mainscreen.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.thezero.randomjokes.core.resources.Status
import com.thezero.randomjokes.data.models.Joke
import com.thezero.randomjokes.data.remotedatasource.JokesApiBuilder
import com.thezero.randomjokes.data.remotedatasource.JokesApiHelper
import com.thezero.randomjokes.data.repository.JokesRepositoryImp
import com.thezero.randomjokes.databinding.ActivityMainBinding
import com.thezero.randomjokes.di.DaggerViewModelComponent
import com.thezero.randomjokes.domain.usecases.GetRandomTenJokesUseCase
import com.thezero.randomjokes.presentation.mainscreen.viewmodel.MainViewModel
import com.thezero.randomjokes.presentation.mainscreen.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private val jokesListAdapter = JokesListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        DaggerViewModelComponent.builder().build().inject(this)

        // inti & setup views
        initViews()

        // initialize view models
        initViewModels()

        // views event listeners
        viewEventListeners()

        // load initial jokes
        refreshRandomJokes()
    }

    private fun initViews() {
        binding.recyclerViewJokes.apply {
            adapter = jokesListAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun initViewModels() {
        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]
    }

    private fun viewEventListeners() {
        binding.swipeRefreshLayoutJokesList.setOnRefreshListener {
            refreshRandomJokes()
        }

        jokesListAdapter.onItemClick = { joke: Joke ->
            JokesDetail.show(joke, this)
        }
    }

    private fun refreshRandomJokes() {
        mainViewModel.fetchRandomTenJokes().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        // we first hide loader and loading message
                        binding.textViewJokesStatusMessage.visibility = View.GONE
                        binding.recyclerViewJokes.visibility = View.VISIBLE
                        binding.swipeRefreshLayoutJokesList.isRefreshing = false

                        // refresh jokes list if data is not null
                        if (resource.data != null) {
                            jokesListAdapter.refreshJokesList(resource.data)
                        }
                    }

                    Status.LOADING -> {
                        binding.textViewJokesStatusMessage.visibility = View.GONE
                        binding.swipeRefreshLayoutJokesList.isRefreshing = true
                    }

                    Status.ERROR -> {
                        binding.swipeRefreshLayoutJokesList.isRefreshing = false
                        binding.textViewJokesStatusMessage.visibility = View.VISIBLE
                        binding.textViewJokesStatusMessage.text = resource.errorMessage
                        binding.recyclerViewJokes.visibility = View.GONE
                    }
                }
            }
        })
    }
}