package com.example.cft

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cft.databinding.Activity2Binding
import org.json.JSONObject

class Activity2() : AppCompatActivity() {
    private lateinit var binding: Activity2Binding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val json = intent.getStringExtra("json passed to Activity2")
        val obj = JSONObject(json)

        binding.txV1.setText(" length:"+ obj.getJSONObject("number").get("length"))
        binding.txV2.setText("luhn:"+  obj.getJSONObject("number").get("luhn"))
        binding.txV3.setText("scheme:"+ obj.getString("scheme"))
        binding.txV4.setText("type: "+ obj.getString("type"))
        binding.txV5.setText("brand: "+ obj.getString("brand"))
        binding.txV6.setText("prepaid: "+ obj.getString("prepaid"))
        binding.txV6.setText("prepaid: "+ obj.getString("prepaid"))
        binding.txV7.setText("country: \n"+  obj.getJSONObject("country").get("alpha2") +" "+ obj.getJSONObject("country").get("name"))
        binding.txV8.setText("bank:"+ obj.getJSONObject("bank").get("name"))
        binding.txV8.setText("bank:"+ obj.getJSONObject("bank").get("name") + "\n" +
                             "url:" + obj.getJSONObject("bank").get("url")  + "\n" +
                             "city:" + obj.getJSONObject("bank").get("city") + "\n" +
                             "phone:" + obj.getJSONObject("bank").get("phone"))
    }
}










