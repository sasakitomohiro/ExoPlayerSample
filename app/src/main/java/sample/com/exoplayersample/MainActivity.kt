package sample.com.exoplayersample

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.extractor.ExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory

class MainActivity : AppCompatActivity() {

    private lateinit var uri: Uri
    private lateinit var playerView: PlayerView
    private lateinit var player: SimpleExoPlayer
    private lateinit var extractorsFactory: ExtractorsFactory
    private lateinit var mediaSource: MediaSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        uri = Uri.parse("https://www.radiantmediaplayer.com/media/bbb-360p.mp4")
        playerView = findViewById(R.id.playerView)
        player = ExoPlayerFactory.newSimpleInstance(
            DefaultRenderersFactory(this),
            DefaultTrackSelector(),
            DefaultLoadControl())
        extractorsFactory = DefaultExtractorsFactory()
        mediaSource = ExtractorMediaSource.Factory(DefaultHttpDataSourceFactory("ExoPlayerSample")).createMediaSource(uri)
        playerView.player = player
        player.prepare(mediaSource)
        player.playWhenReady = true
        player.seekTo(0)
    }
}