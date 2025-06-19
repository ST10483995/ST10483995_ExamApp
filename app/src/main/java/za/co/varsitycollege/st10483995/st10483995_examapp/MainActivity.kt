package za.co.varsitycollege.st10483995.st10483995_examapp
//ST10483995 Lipalesa Lethole

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

data class SongVariables(
    var song: String? = null,
    var artist: String? = null,
    var rating: Int? = null,
    var comments: String? = null
)

//Parallel arrays
val songs = mutableListOf(
    SongVariables("", "", 0, ""),
    SongVariables("", "", 0, ""),
    SongVariables("", "", 0, ""),
    SongVariables("", "", 0, "")
)

//Counter(s) declarations
var currentIndex = 0
var ratingCounter = 0


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
        var songEdit = findViewById<EditText>(R.id.songEdit)
        var artistEdit = findViewById<EditText>(R.id.artistEdit)
        var ratingEdit = findViewById<EditText>(R.id.ratingEdit)
        var commentEdit = findViewById<EditText>(R.id.commentEdit)



        //Adding to the playlist
        addButton.setOnClickListener {
            Toast.makeText(this, "Please enter details above", Toast.LENGTH_SHORT).show()

            if(songEdit.text.isNotEmpty()) {
                songs[currentIndex].song = songEdit.text.toString()
            }
            if (artistEdit.text.isNotEmpty()) {
                songs[currentIndex].artist = artistEdit.text.toString()
            }
            if (ratingEdit.inputType.toString().isNotEmpty()) {
                songs[currentIndex].rating = ratingEdit.inputType
            }
            if (commentEdit.text.isNotEmpty()){
                songs[currentIndex].comments = commentEdit.text.toString()
            }
            currentIndex++
            return@setOnClickListener

        }

        //Calculating the average
        val total = 4
        ratingCounter = ratingEdit.inputType

        //Moving to the next page
        nextButton.setOnClickListener {
            val intent = Intent(this, DisplayPage::class.java)
            intent.putExtra("songDetails", songs.toString())
            startActivity(intent)
        }

        //Closing the app
        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}