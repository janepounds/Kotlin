package com.example.mykotlinapp.network.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "SportsCategories")
data class SportsCategories (
    @PrimaryKey(autoGenerate = true) @field:SerializedName("id") var id: Int=0,
    @field:SerializedName("name") var name: String?=null,

    )
