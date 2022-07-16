//package com.dina.resepmakanan.fragment
//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.dina.resepmakanan.model.ResponseFood
//import com.dina.resepmakanan.model.local.entity.BookmarkEntity
//import com.dina.resepmakanan.model.local.room.BookmarkDao
//import com.dina.resepmakanan.model.local.room.FavoriteDatabase
//
//class HomeViewModel (application: Application) : AndroidViewModel(application){
//
//    private var  bookmarkDao: BookmarkDao?
//    private var favoriteDatabase: FavoriteDatabase? = FavoriteDatabase.getDatabase(application)
//
//    init {
//        bookmarkDao = favoriteDatabase?.bookmarkDao()
//    }
//    var listRecipe = MutableLiveData<List<ResponseFood>>()
//
////    fun getListRecipe(): LiveData<List<BookmarkEntity>>?{
////        return bookmarkDao
////    }
//
//    fun getAllBookmark(): LiveData<List<BookmarkEntity>>?{
//        return bookmarkDao?.getAllBookmark()
//    }
//}