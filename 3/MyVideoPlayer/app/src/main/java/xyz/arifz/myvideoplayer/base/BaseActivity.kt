package xyz.arifz.myvideoplayer.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import xyz.arifz.myvideoplayer.viewmodel.MainViewModel

abstract class BaseActivity<V : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {
    lateinit var binding : ViewDataBinding
    lateinit var viewModel: ViewModel
    @get:LayoutRes
    protected abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        onCreated(savedInstanceState)

    }

    protected abstract fun onCreated(savedInstanceState: Bundle?)
    protected abstract fun getViewModel(): Class<VM>

}