package com.dina.resepmakanan.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dina.resepmakanan.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookmarkFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        return inflater.inflate(R.layout.bookmark_fragment, container, false)

//        fun addBookmark(name: String, slug: String, image: String, categori: String, id: Int){
//            CoroutineScope(Dispatchers.IO).launch {
//                val favorite = BookmarkEntity(
//                    name = name,
//                    slug = slug,
//                    image = image,
//                    categori = categori,
//                    id = id
//                )
//                bookmarkDao?.insertBookmark(favorite)
//            }
//        }
//
//        suspend fun checkBookmark(id: String) = bookmarkDao?.checkBookmark(id)
//
//        fun deleteBookmark(id : Int){
//            CoroutineScope(Dispatchers.IO).launch {
//                bookmarkDao?.delete(id)
//            }
//        }
    }


}