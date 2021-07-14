package com.example.mykotlinapp.network.pagingdata

import androidx.paging.*
import com.example.mykotlinapp.network.api.ApiService
import com.example.mykotlinapp.network.daos.SportsCategoriesDao
import com.example.mykotlinapp.network.db.FlashDb
import com.example.mykotlinapp.network.entities.SportsCategories
import kotlinx.coroutines.flow.Flow

class Repository(private val wallet_id: Int, private val database: FlashDb) {

    private val sportsCategoriesDao: SportsCategoriesDao? = database.SportsCategoriesDao()


    fun getSportsCategoriesResultStream(query: String): Flow<PagingData<SportsCategories>> {

        // appending '%' so we can allow other characters to be before and after the query string
        ///val dbQuery = "%${query.replace(' ', '%')}%"
        val pagingSourceFactory = { if(query.isEmpty() || query==null) database.SportsCategoriesDao()?.getCategoriesList() else database.SportsCategoriesDao()?.searchCategories(query) }

        @OptIn(ExperimentalPagingApi::class)
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
            remoteMediator = SportsCategoriesRemoteMediator(
                wallet_id,
                ApiService.create(),
                database
            ),
            pagingSourceFactory = pagingSourceFactory as () -> PagingSource<Int, SportsCategories>
        ).flow
    }
    companion object {
        const val NETWORK_PAGE_SIZE = 20

    }
}