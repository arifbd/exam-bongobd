package xyz.arifz.myvideoplayer.view

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import xyz.arifz.myvideoplayer.R
import xyz.arifz.myvideoplayer.base.BaseActivity
import xyz.arifz.myvideoplayer.databinding.ActivityMainBinding
import xyz.arifz.myvideoplayer.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun onCreated(savedInstanceState: Bundle?) {
        (viewModel as MainViewModel).setContent(binding, this)
        binding.lifecycleOwner = this
        clickActions()
    }

    private fun clickActions() {
        btnPlayPause.setOnClickListener { (viewModel as MainViewModel).performPlayAction() }
        btnForward.setOnClickListener { (viewModel as MainViewModel).performForwardAction() }
        btnRewind.setOnClickListener { (viewModel as MainViewModel).performRewindAction() }
    }
}

