package com.anggapambudi.nontonfilmgratis.bottomsheet

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anggapambudi.nontonfilmgratis.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.filter_fragment.*
import org.jetbrains.anko.sdk27.coroutines.onClick


class FilterBottomSheet: BottomSheetDialogFragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.filter_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClickListener()

    }

    private fun onClickListener() {

        btnComingSoon.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "comingsoon")
            startActivity(moveHome)
            dismiss()
        }

        btnTvSeries.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "tv")
            startActivity(moveHome)
            dismiss()
        }


    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }

}