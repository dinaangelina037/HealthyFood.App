//package com.dina.resepmakanan.model.local.room
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.dina.resepmakanan.model.local.entity.BookmarkEntity
//
//
////cara nyambungin database ke tabel bookmark
//
//@Database(entities = [BookmarkEntity::class], version = 1)
//abstract class FavoriteDatabase: RoomDatabase(){
//
//    abstract fun bookmarkDao(): BookmarkDao
//
//    companion object{
//        @Volatile
//        var INSTANCE: FavoriteDatabase? = null
//
//        @JvmStatic
//        fun getDatabase(context: Context): FavoriteDatabase?{
//            if (INSTANCE == null){
//                synchronized(FavoriteDatabase::class){
//                    INSTANCE = Room.databaseBuilder(context.applicationContext, FavoriteDatabase::class.java, "favorite_database").build()
//                }
//            }
//            return INSTANCE
//        }
//    }
//
//
//}