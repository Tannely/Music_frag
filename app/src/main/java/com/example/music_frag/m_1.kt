package com.example.music_frag
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_m1.*

class M1Fragment : Fragment() {

    private val songs = listOf(
        Song("Believer", "Imagine Dragons", "https://imageurl.com/believer.jpg", "Lyrics for Believer"),
        Song("Radioactive", "Imagine Dragons", "https://imageurl.com/radioactive.jpg", "Lyrics for Radioactive"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_m1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SongAdapter(songs) { song ->
            val action = M1FragmentDirections.actionM1FragmentToM2Fragment(song)
            findNavController().navigate(action)
        }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }
}



