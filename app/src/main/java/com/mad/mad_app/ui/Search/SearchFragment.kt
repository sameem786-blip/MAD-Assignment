package com.mad.mad_app.ui.Search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mad.mad_app.databinding.FragmentSearchBinding
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class SearchFragment : Fragment() {
    private  var binding : FragmentSearchBinding? = null
    private lateinit var list_data : ArrayList<apiData>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)

        list_data = ArrayList()


        RetrofitHelper.apiInterface.getQuotes().enqueue(object : Callback<QuoteList> {
            override fun onResponse(call : Call<QuoteList>, response : Response<QuoteList?>){
                if(response.isSuccessful){
                    val results = response.body()?.results
                    if (results != null) {
                        for(quote in results){
                            list_data.add(apiData(quote.author,quote.content))
                        }
                        binding!!.recyclerviewList.adapter = searchAdapter(requireContext(),list_data)
                    }
                }
            }
            override fun onFailure(call : Call<QuoteList>, t : Throwable){

            }
        })

        binding!!.recyclerviewList.adapter = searchAdapter(requireContext(),list_data)
        binding!!.recyclerviewList.layoutManager = LinearLayoutManager(requireContext())
        return binding!!.root
    }
}