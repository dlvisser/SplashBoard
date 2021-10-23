package com.daveleron.splashboard.presentation.photodisplay

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.daveleron.splashboard.R
import com.daveleron.splashboard.network.model.PhotoDto

class PhotoAdapter(context: Context) : PagingDataAdapter<PhotoDto,PhotoAdapter.PhotoViewHolder>(DiffUtilCallBack()) {

    private val mLayoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(mLayoutInflater.inflate(R.layout.item_unsplash_photo, parent, false))
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = getItem(position)

        // item
        holder.bind(photo!!)
    }

    /**
     * UnsplashPhoto view holder.
     */
    class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageViewPhoto: ImageView = view.findViewById(R.id.iv_item_unsplash_photo)
        private val imageViewUserPhoto : ImageView = view.findViewById(R.id.iv_item_user_photo)
        private val textViewUserName : TextView = view.findViewById(R.id.tv_item_user_name)

        fun bind(photo: PhotoDto){
            // loading the photo
            imageViewPhoto.load(photo.urls.regular)
            // loading the user photo
            imageViewUserPhoto.load(photo.user.profileImage.medium)
            // loading the user name
            textViewUserName.text = photo.user.username
        }
    }
}

class DiffUtilCallBack : DiffUtil.ItemCallback<PhotoDto>(){
    override fun areItemsTheSame(oldItem: PhotoDto, newItem: PhotoDto): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PhotoDto, newItem: PhotoDto): Boolean {
        return oldItem.id == newItem.id
    }
}