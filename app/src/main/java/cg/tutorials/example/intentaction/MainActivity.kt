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
        val emSub : String="Leave Request for Summer Training Program"
        val emBody :String="I hope this message finds you well. I am writing to request a leave of absence from the summer training program for Today, due to personal reasons.\n" +
                "\n" +
                "I understand the importance of the training program and the commitment required, and I assure you that I will make every effort to catch up on any missed material upon my return. I am willing to put in extra time and effort to ensure I stay on track with the program's objectives.\n" +
                "\n" +
                "I kindly request your understanding and approval of this leave.\n" +
                "\n" +
                "Thank you for your consideration. I look forward to your response.\n" +
                "\n" +
                "Best regards, \n" +
                "Chaitnya Ghai\n" +
                "Trainee, Summer Training Program"

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
        intent.setData(Uri.parse("mailto:"))
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("chaitnyaghai2004@gmail.com","o7services017@gmail.com"))
        intent.putExtra("subject",emSub)
        intent.putExtra("body",emBody)
        startActivity(intent)
    }

}
catch (e:Exception){
    Log.e("TAG", "onCreate: " )
}

    }
}