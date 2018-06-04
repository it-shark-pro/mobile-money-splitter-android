package pro.itshark.moneysplitter.common

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import pro.itshark.moneysplitter.GlideApp

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("bind:src")
    fun loadImage(imageView: ImageView, url: String) = GlideApp
            .with(imageView.context)
            .load(url)
            .into(imageView)

/*    @JvmStatic
    @BindingAdapter("app:showIfError")
    fun showIfError(errorView: View, show: Boolean) {
        errorView.visibility = if (show) View.VISIBLE else View.VISIBLE
    }*/
}
