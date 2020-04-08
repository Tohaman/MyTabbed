package com.example.mytabbed.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter2 (fragment: Fragment) : FragmentStateAdapter(fragment) {
    var list: List<Int> = listOf(0)

    fun refreshItems(l : List<Int>) {
        list = l
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return PlaceholderFragment.newInstance(list[position])
    }
}