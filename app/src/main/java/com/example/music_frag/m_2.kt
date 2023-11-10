package com.example.music_frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_m2.*

class M2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_m2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val song = arguments?.let { M2FragmentArgs.fromBundle(it).song }


        song?.let {
            Glide.with(requireContext())
                .load(it.imageUrl)
                .into(detailImageView)

            detailTitleTextView.text = it.title
            detailArtistTextView.text = it.artist


        }
    }
}
