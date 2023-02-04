package com.mad.mad_app.ui.New

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.mad.mad_app.databinding.FragmentNewBinding
import com.mad.mad_app.ui.*
import kotlinx.coroutines.launch

class NewFragment : Fragment() {
    private var binding : FragmentNewBinding? = null
    private val database by lazy { recordDatabase.getDatabase(requireContext()) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Error in Data")
        builder.setMessage("Please fill out the form completely and properly")

        binding = FragmentNewBinding.inflate(layoutInflater,container,false)
        binding!!.button.setOnClickListener {
            val name : String = binding!!.editTextTextPersonName.text.toString()
            val profession : String = binding!!.editTextTextPersonName2.text.toString()
            if(name.isNotEmpty() && profession.isNotEmpty()){
                lifecycleScope.launch{
                    database.record_dao().insert(record(null,name,profession,false))
                    Toast.makeText(requireContext(),"Data Successfully Inserted",Toast.LENGTH_SHORT).show()
                }
                binding!!.editTextTextPersonName.text.clear()
                binding!!.editTextTextPersonName2.text.clear()
            }
            else {
                val alertDialog : AlertDialog = builder.create()
                alertDialog.setCancelable(true)
                alertDialog.show()
            }
        }
        return binding!!.root
    }

}