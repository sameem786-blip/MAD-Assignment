package com.mad.mad_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.mad.mad_app.databinding.ActivityMainBinding
import com.mad.mad_app.ui.Favourite.FavouriteFragment
import com.mad.mad_app.ui.New.NewFragment
import com.mad.mad_app.ui.Search.SearchFragment
import com.mad.mad_app.ui.dashboard.DashboardFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.dashboard -> {
                    replaceFragment(DashboardFragment())
                    true
                }
                R.id.starred -> {
                    replaceFragment(FavouriteFragment())
                    true
                }
                R.id.add_new -> {
                    replaceFragment(NewFragment())
                    true
                }
                R.id.search -> {
                    replaceFragment(SearchFragment())
                    true
                }


                else -> {
                    replaceFragment(DashboardFragment())
                    true
                }
            }
        }
    }
    private fun replaceFragment(fragment : Fragment){
        val fragment_transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        fragment_transaction.replace(R.id.nav_host_fragment_activity_main,fragment)
        fragment_transaction.commit()
    }
}