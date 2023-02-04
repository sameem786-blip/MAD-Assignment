package com.mad.mad_app.ui.Favourite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mad.mad_app.databinding.FragmentFavouriteBinding
import com.mad.mad_app.ui.myAdapter
import com.mad.mad_app.ui.recordDatabase
import kotlinx.coroutines.launch

class FavouriteFragment : Fragment() {
    private var binding : FragmentFavouriteBinding? = null
    private var viewmodel : FavouriteViewModel? = null
    private val database by lazy { recordDatabase.getDatabase(requireContext()) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavouriteBinding.inflate(layoutInflater,container,false)

        viewmodel = ViewModelProvider(this).get(FavouriteViewModel::class.java)

        lifecycleScope.launch {
            binding!!.list2.adapter = myAdapter(requireContext(),database.record_dao().getFavorites(),2)
        }
        binding!!.list2.layoutManager = LinearLayoutManager(requireContext())
        return binding!!.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}