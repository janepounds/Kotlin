package com.example.mykotlinapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.example.mykotlinapp.network.entities.SportsCategories
import com.example.mykotlinapp.network.pagingdata.Repository
import kotlinx.coroutines.flow.Flow

class SportsCategoriesViewModel(private val repository: Repository) : ViewModel() {
    private var currentQueryValue: String? = null

    private var currentSearchResult: Flow<PagingData<SportsCategories>>? = null

    fun searchCategories(queryString: String): Flow<PagingData<SportsCategories>> {
        val lastResult = currentSearchResult
        if (queryString == currentQueryValue && lastResult != null) {
            return lastResult
        }
        currentQueryValue = queryString
        val newResult: Flow<PagingData<SportsCategories>> = repository.getSportsCategoriesResultStream(queryString)
                .cachedIn(viewModelScope)
        currentSearchResult = newResult
        return newResult
    }

    class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SportsCategoriesViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return SportsCategoriesViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}