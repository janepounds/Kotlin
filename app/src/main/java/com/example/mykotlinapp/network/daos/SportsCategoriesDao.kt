package com.example.mykotlinapp.network.daos

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mykotlinapp.network.entities.SportsCategories

@Dao
interface SportsCategoriesDao {
    @Query("SELECT * FROM SportsCategories ORDER BY id DESC")
    fun getCategoriesList(): PagingSource< Int, SportsCategories>

    @Query("SELECT SportsCategories.* FROM SportsCategories JOIN SportsCategoriesFts ON (SportsCategoriesFts.id=SportsCategories.id) WHERE SportsCategoriesFts MATCH :searchKey ORDER BY SportsCategories.id DESC")
    fun searchCategories(searchKey : String): PagingSource<Int, SportsCategories>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(orderList: List<SportsCategories>)


    @Query("DELETE  FROM SportsCategories")
    suspend fun clearCategories()
}