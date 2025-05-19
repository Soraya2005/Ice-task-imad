package za.ac.iie.myweatherapp // Updated package name

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// import za.ac.iie.myweatherapp.R // Removed unnecessary import

class MainActivity : AppCompatActivity() {

    // Declare the parallel arrays for days and temperatures
    private val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    private val maxTemps = arrayOf(25, 29, 22, 24, 20, 18, 16)

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find UI elements
        val weatherInfoLayout: LinearLayout = findViewById(R.id.weatherInfoLayout)
        val averageTempTextView: TextView = findViewById(R.id.averageTempTextView)
        val backButton: Button = findViewById(R.id.backButton)

        // Display weather information using a loop
        // Iterate through the indices of the days array (which are the same as maxTemps array)
        for (i in days.indices) {
            // Create a new TextView for each day and temperature pair
            val dayTempTextView = TextView(this)
            // Set the text for the TextView using data from both arrays
            dayTempTextView.text = "${days[i]}: ${maxTemps[i]}°C"
            dayTempTextView.textSize = 18f // Set text size in sp (use 'f' for float)
            dayTempTextView.gravity = Gravity.CENTER_HORIZONTAL // Center the text
            // Add the newly created TextView to the LinearLayout
            weatherInfoLayout.addView(dayTempTextView)
        }

        // Calculate average temperature using a loop
        var sum = 0 // Initialize sum to 0
        // Iterate through the maxTemps array
        for (temp in maxTemps) {
            sum += temp // Add each temperature to the sum
        }

        // Calculate the average, handling the case where the array might be empty
        val average = if (maxTemps.isNotEmpty()) {
            sum.toDouble() / maxTemps.size // Calculate average as a double
        } else {
            0.0 // If array is empty, average is 0
        }

        // Display the calculated average temperature
        // Use String.format to format the average to two decimal places
        averageTempTextView.text = "Average Max Temperature: %.2f°C".format(average)
        averageTempTextView.textSize = 20f // Set text size
        averageTempTextView.gravity = Gravity.CENTER_HORIZONTAL // Center the text

        // Set a click listener for the back button
        backButton.setOnClickListener {
            // Finish the current activity (MainActivity) to return to the previous one (WelcomeActivity)
            finish()
        }
    }
}

