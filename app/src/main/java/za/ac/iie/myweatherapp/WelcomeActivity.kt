package za.ac.iie.myweatherapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // Find UI elements by their IDs
        // Assigned appNameTextView to a variable
        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val studentNumberTextView: TextView = findViewById(R.id.studentNumberTextView)
        val proceedButton: Button = findViewById(R.id.proceedButton)

        // Set the text for your name and student number
        // *** IMPORTANT: Replace "Your Name Here" and "Your Student Number Here" with your actual details ***
        nameTextView.text = "Iness Pechera"
        studentNumberTextView.text = "st10493837"

        // You can set a specific image resource for the logoImageView here if you have one
        // For now, we are using a simple placeholder in the XML layout.
        // Example: logoImageView.setImageResource(R.drawable.your_logo_image)

        // Set a click listener for the proceed button
        proceedButton.setOnClickListener {
            // Create an Intent to start the MainActivity
            val intent = Intent(this, MainActivity::class.java)
            // Start the MainActivity
            startActivity(intent)
        }
    }
}
