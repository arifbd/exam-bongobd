package xyz.arifz.myvideoplayer.player

import android.widget.VideoView

class VideoPlayer : Player {
    private lateinit var player: VideoView
    private var position: Int = 0

    override fun initView(view: VideoView) {
        player = view
    }

    override fun playPause(): Boolean {
        if (!(::player.isInitialized)) return false
        return if (player.isPlaying) {
            player.pause()
            setPausePosition(player.currentPosition)
            false
        } else {
            player.seekTo(getPausePosition())
            player.start()
            true
        }
    }

    override fun forward() {
        if (!(::player.isInitialized)) return
        var current = player.currentPosition
        current += 1000
        val duration = player.duration
        if (duration > (current + 1000))
            player.seekTo(current)
    }

    override fun rewind() {
        if (!(::player.isInitialized)) return
        player.seekTo(0)
    }

    override fun getPlayerView(): VideoView? {
        return player
    }

    private fun setPausePosition(currentPosition: Int) {
        position = currentPosition
    }

    private fun getPausePosition(): Int {
        return position
    }

    companion object {
        private var mInstance: Player? = null

        val instance: Player
            get() {
                if (mInstance == null) {
                    synchronized(VideoPlayer::class.java) {
                        mInstance = VideoPlayer()
                    }
                }
                return mInstance!!
            }
    }
}