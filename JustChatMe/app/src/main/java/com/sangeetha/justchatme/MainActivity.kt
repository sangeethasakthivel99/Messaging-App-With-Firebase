package com.sangeetha.justchatme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val chatsFragment = ChatsFragment()

    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addChatsFragment()
        setupBottomNavigation()
    }

    private fun addChatsFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.flFragment, chatsFragment, "ChatsFragment")
            .commit()
    }

    private fun setupBottomNavigation() {
        bottomNavigationView.selectedItemId = R.id.chatsFragment
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.chatsFragment -> {
                    replaceFragment(chatsFragment)
                    true
                }
                R.id.profileFragment -> {
                    replaceFragment(profileFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.flFragment, fragment, fragment.tag)
            .commit()
    }
}