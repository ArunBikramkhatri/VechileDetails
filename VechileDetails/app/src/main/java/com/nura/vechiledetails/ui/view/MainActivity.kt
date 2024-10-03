package com.nura.vechiledetails.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.microsoft.clarity.Clarity
import com.microsoft.clarity.ClarityConfig
import com.microsoft.clarity.models.ApplicationFramework
import com.microsoft.clarity.models.LogLevel
import com.nura.vechiledetails.R
import com.nura.vechiledetails.SecondActivity
import java.util.Collections

class MainActivity : AppCompatActivity() {
    private val p_id: String = "obnlssgodb"
    private lateinit var submit: Button
    private lateinit var switch_to_second: Button

    private lateinit var click: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initFields();

//        initMicrosoftClarity();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun initFields() {

        submit = findViewById(R.id.submit)
        switch_to_second = findViewById(R.id.switch_second_activity)
        click = findViewById(R.id.click)

        textView = findViewById(R.id.first_text_view)
        submit.setOnClickListener {
            textView.setText("Submit")
        }

        switch_to_second.setOnClickListener {
            val second = Intent(this, SecondActivity::class.java)
            startActivity(second)
        }
        click.setOnClickListener {
            textView.setText("Click")
        }

    }

    fun initMicrosoftClarity(){
        val config = ClarityConfig(projectId = p_id,null, // Default user id
            LogLevel.Verbose,
            true, // Disallow metered network usage
            true, // Enable web view capturing
            Collections.singletonList("*"), // Allowed domains
            ApplicationFramework.Native,
            Collections.emptyList(), // Allowed activities
            Collections.emptyList(), // Disallowed activities (ignore activities)
            false, // Disable on low-end devices
            null) // Maximum allowed daily network usage in MB (null = unlimited))

        Clarity.initialize(applicationContext , config);
    }

}