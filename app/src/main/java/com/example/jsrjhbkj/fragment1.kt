import com.example.jsrjhbkj.R
import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.example.jsrjhbkj.MainActivity


class fragment1 : Fragment() {

    private lateinit var videoView: VideoView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragment1, container, false)

        videoView = view.findViewById(R.id.videoView)

        // Initialize the videoPath variable
        val videoPath = Uri.parse("android.resource://${requireActivity().packageName}/${R.raw.demoneet}")

        // Create a MediaController to control playback
        val mediaController = MediaController(requireContext())
        mediaController.setAnchorView(videoView)

        // Set the video URI and the MediaController for the VideoView
        videoView.setVideoURI(videoPath)
        videoView.setMediaController(mediaController)

        // Start playing the video
        videoView.start()

        return view
    }
}
