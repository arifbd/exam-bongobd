package xyz.arifz.myvideoplayer.base

import android.app.Activity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    lateinit var binding : ViewDataBinding
    lateinit var activity : Activity

    open fun setContent(binding: ViewDataBinding, activity: Activity){
        this.binding = binding
        this.activity = activity
    }
}