package za.co.varsitycollege.st10483995.st10483995_examapp
//ST10483995 Lipalesa Lethole

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

data class SongVariables(
    val song: String? = null,
    val artist: String? = null,
    val rating: Int? = null,
    val comments: String? = null
)

val songs = mutableListOf(
    SongVariables("", "", 0, ""),
    SongVariables("", "", 0, ""),
    SongVariables("", "", 0, ""),
    SongVariables("", "", 0, "")
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Declarations
        val addButton = findViewById<Button>(R.id.addButton)
        val nextButton = findViewById<Button>(R.id.nextButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        //Adding to the playlist
        addButton.setOnClickListener {  }

        //Moving to the next page
        nextButton.setOnClickListener {
            val intent = Intent(this, DisplayPage::class.java)
            startActivity(intent)
        }

        //Closing the app
        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}