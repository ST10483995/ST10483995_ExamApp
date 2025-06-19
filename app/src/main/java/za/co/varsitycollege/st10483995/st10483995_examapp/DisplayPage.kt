package za.co.varsitycollege.st10483995.st10483995_examapp
//ST10483995 Lipalesa Lethole

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DisplayPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_display_page2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Declarations
        val displayView = findViewById<TextView>(R.id.displayView)
        val displayButton = findViewById<Button>(R.id.displayButton)
        val averageButton = findViewById<Button>(R.id.averageButton)
        val returnButton = findViewById<Button>(R.id.returnButton)
        val bundle: Bundle? = intent.extras
        val songInfo: String? = bundle?.getString("songDetails")

        //Show the list and details
        displayButton.setOnClickListener {
            
        }

        //Show average ratings
        averageButton.setOnClickListener {  }

        //Return to the main page
        returnButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}