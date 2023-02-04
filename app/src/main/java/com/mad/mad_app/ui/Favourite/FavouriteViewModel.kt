package com.mad.mad_app.ui.Favourite

import androidx.lifecycle.ViewModel
import com.mad.mad_app.ui.userData

class FavouriteViewModel : ViewModel() {
    val userData : ArrayList<userData> = ArrayList()

    init {
        userData.add(userData(1,"Johnny","Doctor",2))
        userData.add(userData(2,"Ahmed","Scientist",2))
    }

    fun getData(): ArrayList<userData> {
        return userData
    }
}