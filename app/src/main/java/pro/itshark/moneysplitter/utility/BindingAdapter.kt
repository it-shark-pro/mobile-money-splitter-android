package pro.itshark.moneysplitter.utility

import android.databinding.BindingAdapter
import android.widget.ImageView
import pro.itshark.moneysplitter.GlideApp

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("bind:src")
    fun loadImage(imageView: ImageView, url: String) = GlideApp
            .with(imageView.context)
            .load(url)
            .into(imageView)
}
