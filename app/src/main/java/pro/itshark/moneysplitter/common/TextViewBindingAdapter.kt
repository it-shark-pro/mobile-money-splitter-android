package pro.itshark.moneysplitter.common

import android.databinding.BindingAdapter
import com.miguelcatalan.materialsearchview.MaterialSearchView
import io.reactivex.subjects.PublishSubject

object TextViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("bind:onQueryTextListener")
    fun setOnQueryTextListener(materialSearchView: MaterialSearchView, subject: PublishSubject<String>) {
        materialSearchView.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean {
                materialSearchView.clearFocus()

                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                subject.onNext(newText)

                return true
            }
        })
    }
}
