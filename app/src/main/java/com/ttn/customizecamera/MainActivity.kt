package com.ttn.customizecamera

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.ttn.customizecamerakitsdk.CustomCameraActivity

class MainActivity : AppCompatActivity() {

    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            if (intent != null) {
                findViewById<ImageView>(R.id.preview).setImageURI(intent.getParcelableExtra("uri"))
            }

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startForResult.launch(Intent(this, CustomCameraActivity::class.java))
    }
}