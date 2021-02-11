package com.workshopkotlin.myapplication.feature

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.workshopkotlin.myapplication.R
import com.workshopkotlin.myapplication.data.sharedpref.SharedprefUtil
import kotlinx.android.synthetic.main.activity_profile_fragment.*
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.newTask
import org.jetbrains.anko.support.v4.intentFor

class ProfileFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_profile_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindView()
        onClickListener()
    }

    private fun onClickListener() {
        btn_logout.setOnClickListener {
            SharedprefUtil.clearSharedPref()
            startActivity(intentFor<LoginActivity>().newTask().clearTask())
        }
    }

    @SuppressLint("SetTextI18n")
    private fun bindView() {
        tv_bio.text = "Saat ini anda login sebagai ${SharedprefUtil.nameUser}"
    }
}
