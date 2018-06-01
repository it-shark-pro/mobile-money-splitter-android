package pro.itshark.moneysplitter.common

import android.databinding.BindingAdapter
import android.net.Uri
import android.widget.ImageView
import pro.itshark.moneysplitter.GlideApp

object ImageViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("bind:src")
    fun loadImage(imageView: ImageView, url: String) = GlideApp
            .with(imageView.context)
            .load(url)
            .into(imageView)

    @JvmStatic
    @BindingAdapter("bind:imageUri")
    fun setImageUri(imageView: ImageView, uri: String) {
        if (uri.isEmpty()) {
            return
        }
        val image = Uri.parse(uri)
        imageView.setImageURI(image)
    }
}
