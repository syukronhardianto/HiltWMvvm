package com.example.hiltwmvvm.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.hiltwmvvm.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var testClass: TestClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        println("activityb: ${testClass.provideString()}")

        val fragmentTrx = supportFragmentManager.beginTransaction()
        fragmentTrx.replace(R.id.container2, MySecondFragment()).commit()
    }
}

@AndroidEntryPoint
class MySecondFragment: Fragment(){
    @Inject lateinit var testClass: TestClass

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        println("fragment: ${testClass.provideString()}")
    }
}