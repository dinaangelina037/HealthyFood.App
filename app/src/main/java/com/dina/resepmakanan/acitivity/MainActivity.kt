package com.dina.resepmakanan.acitivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.dina.resepmakanan.R
import com.dina.resepmakanan.fragment.BookmarkFragment
import com.dina.resepmakanan.fragment.HomeFragment2
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    val fragmentHome: Fragment = HomeFragment2()
    val fragmentBookmark : Fragment = BookmarkFragment()
    val fragmentManager: FragmentManager = supportFragmentManager
    var active :  Fragment = fragmentHome

    lateinit var menu: Menu
    lateinit var menuItem: MenuItem
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        setUpBottomNavigations()
    }

    private fun setUpBottomNavigations() {
        fragmentManager.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fragmentManager.beginTransaction().add(R.id.container, fragmentBookmark).hide(fragmentBookmark).commit()

        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener {it ->
            when(it.itemId){
                R.id.navigation_home ->{
                    callFragment(0,fragmentHome)
                    onRestart()
                }
                R.id.navigation_bookmark ->{
                    callFragment(1 ,fragmentBookmark)
                    onRestart()
                }
                else ->{
                    startActivity(Intent(this, HomeFragment2::class.java))
                }
            }
            false
        }
    }

    private fun callFragment(index: Int, fragment: Fragment){
        menuItem = menu.getItem(index)
        menuItem.isChecked =true
        supportFragmentManager.beginTransaction().hide(active).show(fragment).commit()
        active = fragment

    }

}