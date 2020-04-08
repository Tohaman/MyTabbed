package com.example.mytabbed

import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import com.example.mytabbed.ui.main.MainViewModel
import com.example.mytabbed.ui.main.SectionsPagerAdapter
import java.util.*
import kotlin.random.Random.Default.Companion

class MainActivity : AppCompatActivity() {
    private val TAG = "MyTAB"
    private val viewModel : MainViewModel by viewModels{
        MainViewModel.Companion.MainViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate")
        setContentView(R.layout.activity_main)
        viewModel.randomFill()

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)

        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        viewModel.dataList.observe(this, androidx.lifecycle.Observer {
            Log.d(TAG,"viewModel.dataList.observe")
            sectionsPagerAdapter.refreshItems(it)
        })

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
         //   Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
            Log.d(TAG,"FAB pressed")
            viewModel.randomFill()
        }
    }
}