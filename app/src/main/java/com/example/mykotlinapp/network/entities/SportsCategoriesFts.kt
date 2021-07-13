package com.example.mykotlinapp.network.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "SportsCategoriesFts")
@Fts4(contentEntity = SportsCategories::class)
data class SportsCategoriesFts (
    @PrimaryKey @NonNull @field:SerializedName("id") var id:Int,
    @field:SerializedName("name") val name:String?=null
)