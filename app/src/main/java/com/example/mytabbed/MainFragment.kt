package com.example.mytabbed

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.mytabbed.databinding.FragmentWithViewPager2Binding
import com.example.mytabbed.ui.main.MainViewModel
import com.example.mytabbed.ui.main.SectionsPagerAdapter
import com.example.mytabbed.ui.main.SectionsPagerAdapter2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_with_view_pager2.*

class MainFragment: Fragment() {
    private val TAG = "MyTAB"
    private val viewModel : MainViewModel by viewModels{
        MainViewModel.Companion.MainViewModelFactory()
    }
    private lateinit var binding: FragmentWithViewPager2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreateFragment")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentWithViewPager2Binding.inflate(inflater, container,false)
            .apply {

                viewModel.randomFill()
                val sectionsPagerAdapter = SectionsPagerAdapter(requireContext(), childFragmentManager)

                viewModel.dataList.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                    Log.d(TAG,"viewModel.dataList.observe")
                    sectionsPagerAdapter.refreshItems(it)
                })

                viewPager2.adapter = sectionsPagerAdapter

                tab2.setupWithViewPager(viewPager2)

                val fab: FloatingActionButton = fab2
                fab.setOnClickListener { view ->
                    //   Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show()
                    Log.d(TAG,"FAB pressed")
                    viewModel.randomFill()
                }
            }

        return binding.root
    }

}