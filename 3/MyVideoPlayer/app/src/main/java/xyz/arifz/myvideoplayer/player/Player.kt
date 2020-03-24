package xyz.arifz.myvideoplayer.player

import android.widget.VideoView

interface Player {
    fun initView(view: VideoView)
    fun playPause(): Boolean
    fun forward()
    fun rewind()
    fun getPlayerView():VideoView?
}