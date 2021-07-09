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



        //tahun
        btn2015.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "2015")
            startActivity(moveHome)
            dismiss()
        }
        btn2016.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "2016")
            startActivity(moveHome)
            dismiss()
        }
        btn2017.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "2017")
            startActivity(moveHome)
            dismiss()
        }
        btn2018.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "2018")
            startActivity(moveHome)
            dismiss()
        }
        btn2019.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "2019")
            startActivity(moveHome)
            dismiss()
        }
        btn2020.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "2020")
            startActivity(moveHome)
            dismiss()
        }
        btnSearchTahun.onClick {
            if (editTahunFiter.text.trim().toString().isEmpty()) {
                editTahunFiter.error = "Tahun tidak boleh kosong"
            } else {
                val tahun = editTahunFiter.text.trim()
                val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
                moveHome.putExtra("KEY_FILM_FILTER", "$tahun")
                startActivity(moveHome)
                dismiss()
            }
        }



        //genre
        btnAnimation.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "animation")
            startActivity(moveHome)
            dismiss()
        }
        btnHorror.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "horror")
            startActivity(moveHome)
            dismiss()
        }
        btnAction.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "action")
            startActivity(moveHome)
            dismiss()
        }
        btnRomance.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "romance")
            startActivity(moveHome)
            dismiss()
        }
        btnAdventure.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "adventure")
            startActivity(moveHome)
            dismiss()
        }
        btnFamily.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "family")
            startActivity(moveHome)
            dismiss()
        }
        btnFantasy.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "fantasy")
            startActivity(moveHome)
            dismiss()
        }
        btnDrama.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "drama")
            startActivity(moveHome)
            dismiss()
        }
        btnHistory.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "history")
            startActivity(moveHome)
            dismiss()
        }
        btnThriller.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "thriller")
            startActivity(moveHome)
            dismiss()
        }


        //negara
        btnIndonesia.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "indonesia")
            startActivity(moveHome)
            dismiss()
        }
        btnJapan.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "japan")
            startActivity(moveHome)
            dismiss()
        }
        btnKorea.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "korea")
            startActivity(moveHome)
            dismiss()
        }
        btnThailand.onClick {
            val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
            moveHome.putExtra("KEY_FILM_FILTER", "thailand")
            startActivity(moveHome)
            dismiss()
        }
        btnSearchNegara.onClick {
            if (editNegara.text.trim().toString().isEmpty()) {
                editNegara.error = "Negara tidak boleh kosong"
            } else {
                val negara = editNegara.text.trim()
                val moveHome = Intent(requireContext(), this@FilterBottomSheet.requireContext()::class.java)
                moveHome.putExtra("KEY_FILM_FILTER", "$negara")
                startActivity(moveHome)
                dismiss()
            }
        }

    }

    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }

}