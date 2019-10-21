package com.sun_asterisk.moviedb_49.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sun_asterisk.moviedb_49.R
import com.sun_asterisk.moviedb_49.screen.navigation.ContainerFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.layoutContainer, ContainerFragment())
            .commit()
    }
}
