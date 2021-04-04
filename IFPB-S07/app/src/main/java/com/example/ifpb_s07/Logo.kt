package com.example.ifpb_s07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class Logo : AppCompatActivity() {

    private lateinit var constraintLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val i = ImageView(this).apply {
            setImageResource(R.drawable.logo_ifpb)

            adjustViewBounds = true
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

        constraintLayout = ConstraintLayout(this).apply {
            addView(i)
        }

        setContentView(constraintLayout)
    }

}
