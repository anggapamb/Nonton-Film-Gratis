package com.anggapambudi.nontonfilmgratis

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anggapambudi.nontonfilmgratis.Retrofit.ApiService
import com.anggapambudi.nontonfilmgratis.adapter.ItemFilmAdapter
import com.anggapambudi.nontonfilmgratis.bottomsheet.FilterBottomSheet
import com.anggapambudi.nontonfilmgratis.response.ItemFilmResponse
import com.anggapambudi.nontonfilmgratis.response.ResultItem
import com.anggapambudi.nontonfilmgratis.session.MyApplication
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.filter_fragment.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnHelp: ImageView
    private lateinit var btnFilter: ImageView
    private lateinit var editJudul: EditText
    private lateinit var tvRecyclerView: RecyclerView
    private lateinit var iconSearch: ImageView
    private lateinit var gambarIcon: ImageView
    private val data = ArrayList<ResultItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnHelp = findViewById(R.id.btnHelp)
        btnFilter = findViewById(R.id.btnFilter)
        tvRecyclerView = findViewById(R.id.tvRecyclerview)
        editJudul = findViewById(R.id.editTextJudul)
        iconSearch = findViewById(R.id.iconSearch)
        gambarIcon = findViewById(R.id.gambarIcon)

        setViewHome()


    }

    private fun setViewHome() {
        val getFilm = intent.getStringExtra("KEY_FILM_FILTER")

        if (getFilm == null) {
            newUpload()
        } else {
            setFilm()
        }
    }

    private fun setFilm() {
        val getFilm = intent.getStringExtra("KEY_FILM_FILTER")

        //progressdialog
        val progressDialog = ProgressDialog(this@HomeActivity)
        progressDialog.setCancelable(false)
        progressDialog.setMessage("$getFilm...")
        progressDialog.show()

        ApiService.instance.getFilmFilter("$getFilm").enqueue(object : Callback<ItemFilmResponse> {
            override fun onResponse(call: Call<ItemFilmResponse>, response: Response<ItemFilmResponse>) {
                progressDialog.dismiss()
                data.clear()

                val result = response.body()?.result
                result?.let { data.addAll(it) }

                tvRecyclerView.layoutManager = GridLayoutManager(this@HomeActivity, 3)
                tvRecyclerView.adapter = ItemFilmAdapter(data)
                longToast("$getFilm")

                if (data.isEmpty()) {
                    toast("No data")
                    viewNoData.visibility = View.VISIBLE
                    tvRecyclerView.visibility = View.GONE
                }

            }

            override fun onFailure(call: Call<ItemFilmResponse>, t: Throwable) {
                toast("Oops, internet anda bermasalah!")
                progressDialog.dismiss()
            }

        })
    }

    private fun newUpload() {
        //progressdialog
        val progressDialog = ProgressDialog(this@HomeActivity)
        progressDialog.setCancelable(false)
        progressDialog.setMessage("New Upload...")
        progressDialog.show()

        ApiService.instance.getNewUpload().enqueue(object : Callback<ItemFilmResponse> {
            override fun onResponse(call: Call<ItemFilmResponse>, response: Response<ItemFilmResponse>) {
                progressDialog.dismiss()
                data.clear()

                val result = response.body()?.result
                result?.let { data.addAll(it) }

                tvRecyclerView.layoutManager = GridLayoutManager(this@HomeActivity, 3)
                tvRecyclerView.adapter = ItemFilmAdapter(data)
                longToast("New Upload")

                if (data.isEmpty()) {
                    toast("No data")
                    viewNoData.visibility = View.VISIBLE
                    tvRecyclerView.visibility = View.GONE
                }

            }

            override fun onFailure(call: Call<ItemFilmResponse>, t: Throwable) {
                toast("Oops, internet anda bermasalah!")
                progressDialog.dismiss()
            }

        })
    }

    private fun searchFilm() {
        //progressdialog
        val progressDialog = ProgressDialog(this@HomeActivity)
        progressDialog.setCancelable(false)
        progressDialog.setMessage("Sedang mencari data...")
        progressDialog.show()

        val searchFilmResponse = editJudul.text.trim()

        ApiService.instance.getSearch("$searchFilmResponse").enqueue(object : Callback<ItemFilmResponse> {
            override fun onResponse(
                    call: Call<ItemFilmResponse>,
                    response: Response<ItemFilmResponse>
            ) {
                progressDialog.dismiss()
                data.clear()

                val result = response.body()?.result
                result?.let { data.addAll(it) }

                tvRecyclerView.layoutManager = GridLayoutManager(this@HomeActivity, 3)
                tvRecyclerView.adapter = ItemFilmAdapter(data)

                if (data.isEmpty()) {
                    toast("Film dengan judul $searchFilmResponse tidak tersedia !!!")
                    viewNoData.visibility = View.VISIBLE
                    tvRecyclerView.visibility = View.GONE
                }

            }

            override fun onFailure(call: Call<ItemFilmResponse>, t: Throwable) {
                toast("Oops, internet anda bermasalah!")
                progressDialog.dismiss()
            }

        })
    }

    override fun onClick(view: View?) {
        when (view) {
            iconSearch -> {
                searchFilm()
            }
            gambarIcon -> {
                newUpload()
            }
            btnHelp -> {
                startActivity<HelpActivity>()
            }
            btnFilter -> {
                val bottomSheetFilter = FilterBottomSheet()
                bottomSheetFilter.show(supportFragmentManager, "BottomSheetDialog")
            }
        }
    }
}