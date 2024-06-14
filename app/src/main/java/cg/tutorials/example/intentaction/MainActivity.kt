package cg.tutorials.example.intentaction

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var messages : Button ? = null
        var emails : Button?= null


        messages = findViewById(R.id.sms)
        emails = findViewById(R.id.emails)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

try {
    messages?.setOnClickListener {
        val intent= Intent(Intent.ACTION_SENDTO)
        intent.setData(Uri.parse("sms:9781356230"))
        intent.putExtra("sms_body", "Hello! This is a test SMS message.")
        startActivity(intent)
    }
    emails?.setOnClickListener {
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.setData(Uri.parse("mailto:chaitnyaghai2004@gmail.com"))
        intent.putExtra(Intent.EXTRA_EMAIL, "Hello! This is a test email message")
        intent.putExtra(Intent.EXTRA_SUBJECT," subject")
        startActivity(intent)
    }

}
catch (e:Exception){
    Log.e("TAG", "onCreate: " )
}

    }
}