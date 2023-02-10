package com.example.cft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.cft.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)
        binding.button.setOnClickListener {
            getResult()
            Log.i("my", "Сработала кнопка")
        }
    }

    //Зпрос при нажатии на кнопку
    private fun getResult() {
        val inBin = binding.edBin.text.toString()
        //val inBin = 45717360
        val url = "https://lookup.binlist.net/$inBin"
        val queue = Volley.newRequestQueue(this) //Создается обычный экземпляр queue, который
        // передает в пул запрос и содержит метод запуска  RequestQueue.start()
        val stringRequest = StringRequest(Request.Method.GET,
            url, //Создает новый запрос с методом GET - получить данные.
            { response ->   //Реализация ответа
                val jsn = JSONObject(response)
                val i = Intent(this, Activity2::class.java)
                i.putExtra("json passed to Activity2", "$jsn")
                startActivity(i)
                return@StringRequest
            },
            Response.ErrorListener { "That didn't work!" })
        queue.add(stringRequest)
    }
}


