package com.example.simpleimagechanger

import android.animation.ObjectAnimator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views by ID
        val imageView: ImageView = findViewById(R.id.imageView)
        val buttonRed: Button = findViewById(R.id.buttonOrange) // Streaky
        val buttonBlue: Button = findViewById(R.id.buttonBlue) // Luna
        val buttonGreen: Button = findViewById(R.id.buttonGreen) // Doggo

        // Set click listeners
        buttonRed.setOnClickListener {
            crossFadeImage(imageView, R.drawable.streaky) // Replace with your streaky drawable
        }

        buttonBlue.setOnClickListener {
            crossFadeImage(imageView, R.drawable.luna) // Replace with your luna drawable
        }

        buttonGreen.setOnClickListener {
            crossFadeImage(imageView, R.drawable.doggo) // Replace with your doggo drawable
        }
    }

    // Function for crossfading images
    private fun crossFadeImage(imageView: ImageView, newImageRes: Int) {
        val fadeOut = ObjectAnimator.ofFloat(imageView, "alpha", 1f, 0f).apply {
            duration = 300 // Fade-out duration in milliseconds
        }
        val fadeIn = ObjectAnimator.ofFloat(imageView, "alpha", 0f, 1f).apply {
            duration = 300 // Fade-in duration in milliseconds
        }

        fadeOut.start()
        fadeOut.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: android.animation.Animator) {
                imageView.setImageResource(newImageRes) // Update the image resource
                fadeIn.start()
            }
        })
    }
}
