package com.example.mykotlinapp.network.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mykotlinapp.network.daos.RemoteKeysDao
import com.example.mykotlinapp.network.daos.SportsCategoriesDao
import com.example.mykotlinapp.network.entities.SportsCategories
import com.example.mykotlinapp.network.entities.SportsCategoriesFts

@Database(entities = [SportsCategories::class,SportsCategoriesFts::class],version = 1,exportSchema = false)
 abstract class FlashDb :RoomDatabase(){
  abstract fun SportsCategoriesDao():SportsCategoriesDao?
  abstract fun RemoteKeysDao():RemoteKeysDao?

  companion object{
   var INSTANCE:FlashDb?=null
   @JvmStatic fun getDatabase(context: Context):FlashDb =
    INSTANCE ?: synchronized(this){
     INSTANCE
      ?:buildDatabase(context).also{ INSTANCE = it}
    }
   private fun buildDatabase(context: Context) =
    Room.databaseBuilder(
     context.applicationContext,
     FlashDb::class.java, "flashDb"
    ).addMigrations(MIGRATION_1_2)
     .build()

   val MIGRATION_1_2:Migration = object :Migration(1,2){
    override fun migrate(database: SupportSQLiteDatabase) {
     database.execSQL("CREATE TABLE 'SportsCategories' ('id' TEXT, "
      + "'name' INTEGER, PRIMARY KEY('id'))")
     database.execSQL("CREATE TABLE `RemoteKeys` (`id` TEXT, "
             + "`prevKey` INTEGER,`nextKey` INTEGER, PRIMARY KEY(`id`))")
    }
   }
  }

}