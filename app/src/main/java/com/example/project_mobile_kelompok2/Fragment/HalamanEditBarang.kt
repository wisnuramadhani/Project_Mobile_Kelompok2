package com.example.project_mobile_kelompok2.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project_mobile_kelompok2.R


/**
 * A simple [Fragment] subclass.
 * Use the [HalamanHelp.newInstance] factory method to
 * create an instance of this fragment.
 */
class HalamanEditBarang : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_halaman_edit_barang, container, false)
    }
}