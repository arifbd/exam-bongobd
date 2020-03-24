package xyz.arifz.myvideoplayer.viewmodel

import android.app.Activity
import android.net.Uri
import androidx.core.content.ContextCompat
import androidx.databinding.ViewDataBinding
import kotlinx.android.synthetic.main.activity_main.view.*
import xyz.arifz.myvideoplayer.R
import xyz.arifz.myvideoplayer.base.BaseViewModel
import xyz.arifz.myvideoplayer.databinding.ActivityMainBinding
import xyz.arifz.myvideoplayer.player.Player
import xyz.arifz.myvideoplayer.player.VideoPlayer

class MainViewModel : BaseViewModel() {
    private lateinit var uri: Uri
    private lateinit var player: Player

    override fun setContent(binding: ViewDataBinding, activity: Activity) {
        this.binding = binding
        this.activity = activity

        player = VideoPlayer.instance

        player.initView(binding.root.videoPlayer)
        uri = Uri.parse("android.resource://" + activity.applicationContext.packageName + "/" + R.raw.sample_video)
        player.getPlayerView()?.setVideoURI(uri)
        player.getPlayerView()?.requestFocus()
    }

    internal fun performPlayAction() {
        val isPlaying = player.playPause()
        if (isPlaying)
            (binding as ActivityMainBinding).btnPlayPause.setImageDrawable(ContextCompat.getDrawable(binding.root.context, R.drawable.ic_pause_circle_filled))
        else
            (binding as ActivityMainBinding).btnPlayPause.setImageDrawable(ContextCompat.getDrawable(binding.root.context, R.drawable.ic_play_circle_filled))
    }

    internal fun performForwardAction() = player.forward()

    internal fun performRewindAction() = player.rewind()
}

