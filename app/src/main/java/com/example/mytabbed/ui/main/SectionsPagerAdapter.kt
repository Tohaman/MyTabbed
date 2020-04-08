package com.example.mytabbed.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    var list: List<Int> = listOf(0)

    fun refreshItems(l : List<Int>) {
        list = l
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment {
        return PlaceholderFragment.newInstance(list[position])
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return position.toString()
    }

    override fun getCount(): Int {
        return list.size
    }
}