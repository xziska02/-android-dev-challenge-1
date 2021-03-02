package com.pziska.androiddevchallenge.ui.puppies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pziska.androiddevchallenge.data.model.Puppy
import com.pziska.androiddevchallenge.data.provider.PuppyProvider

class PuppyListViewModel : ViewModel() {

    private val _puppies: MutableLiveData<List<Puppy>> = MutableLiveData(emptyList())
    val puppies: LiveData<List<Puppy>> = _puppies

    init {
        _puppies.postValue(PuppyProvider.getPuppyList())
    }
}