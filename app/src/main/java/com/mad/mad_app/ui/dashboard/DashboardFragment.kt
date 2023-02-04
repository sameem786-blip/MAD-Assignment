package com.mad.mad_app.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mad.mad_app.databinding.FragmentDashboardBinding
import com.mad.mad_app.ui.myAdapter
import com.mad.mad_app.ui.recordDatabase
import kotlinx.coroutines.launch

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private var dashboardViewModel : DashboardViewModel? = null
    private val database by lazy { recordDatabase.getDatabase(requireContext()) }

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        val list : RecyclerView = binding.list
        lifecycleScope.launch {
            list.adapter = myAdapter(requireContext(),database.record_dao().getAllRecords(),1)
        }

        list.layoutManager = LinearLayoutManager(requireContext())

        return root
    }
}