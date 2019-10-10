package com.sun_asterisk.moviedb_49.screen.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sun_asterisk.moviedb_49.R
import com.sun_asterisk.moviedb_49.screen.home.HomePageFragment
import kotlinx.android.synthetic.main.fragment_navigation_bottoms.view.*

class ContainerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_navigation_bottoms, container, false)
        view.bottom_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.actionHome -> {
                    addFragmantToItemMenu(HomePageFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.actionSearch -> return@setOnNavigationItemSelectedListener true
                R.id.actionFavourite -> return@setOnNavigationItemSelectedListener true
            }
            return@setOnNavigationItemSelectedListener false
        }
        addFragmantToItemMenu(HomePageFragment())
        return view
    }

    fun addFragmantToItemMenu(fragment: Fragment) {
        val checkFragment = childFragmentManager.findFragmentByTag(fragment.javaClass.simpleName)
        if (checkFragment != null) {
            childFragmentManager.fragments.forEach {
                childFragmentManager.beginTransaction().hide(it).commit()
            }
            childFragmentManager.beginTransaction()
                .show(checkFragment)
                .commit()
        }
        childFragmentManager.beginTransaction()
            .addToBackStack(null)
            .add(R.id.fragmentHome, fragment, fragment.javaClass.simpleName)
            .commit()
    }
}
