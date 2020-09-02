package com.fair.kotlin_network_test

import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.fair.kotlin_network_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var _binding : ActivityMainBinding
    private val viewBinding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)


            val connection = Connection(this)
            connection.observe(this, Observer { isConnected ->

                viewBinding.apply {

                    if (isConnected) {
                        connectedTrue.visibility = View.VISIBLE
                        connectedFalse.visibility = View.GONE

                    } else {
                        connectedTrue.visibility = View.GONE
                        connectedFalse.visibility = View.VISIBLE
                    }
                }


            })


    }

}