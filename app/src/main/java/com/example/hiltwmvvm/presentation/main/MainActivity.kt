package com.example.hiltwmvvm.presentation.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.paging.LoadState
import com.example.hiltwmvvm.R
import com.example.hiltwmvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var testClass: TestClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        println("activity: ${testClass.provideString()}")

        val adapter = MovieAdapter()

        viewModel.movies.observe(this) {
            adapter.submitData(lifecycle, it)
        }

        binding.apply {
            recyclerview.setHasFixedSize(true)
            recyclerview.adapter = adapter.withLoadStateFooter(
                footer = MovieLoadingStateAdapter { adapter.retry() }
            )
        }

        adapter.addLoadStateListener { loadState ->
            if (loadState.refresh is LoadState.Loading) {
                binding.progressbar.visibility = View.VISIBLE
            } else {
                binding.progressbar.visibility = View.INVISIBLE

                val errorState = when {
                    loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                    loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                    loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
                    else -> null
                }
                errorState?.let {
                    Toast.makeText(this, it.error.toString(), Toast.LENGTH_LONG).show()
                }
            }
        }

        val fragmentTrx = supportFragmentManager.beginTransaction()
        fragmentTrx.replace(R.id.container, MyFragment()).commit()

        binding.testBtn.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}

@AndroidEntryPoint
class MyFragment: Fragment(){
    @Inject lateinit var testClass: TestClass

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        println("fragment: ${testClass.provideString()}")
    }
}
