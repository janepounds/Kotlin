package com.example.mykotlinapp.network.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "")
data class RemoteKeys (
    @PrimaryKey val id: String,
    val prevKey: Int?,
    val nextKey: Int?,
    @ColumnInfo(name = "category", defaultValue = "sports") val type: String = "sport"
        )
