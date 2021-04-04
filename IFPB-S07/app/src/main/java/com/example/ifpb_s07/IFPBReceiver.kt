package com.example.ifpb_s07

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.provider.MediaStore
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.res.ResourcesCompat


class IFPBReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context, intent: Intent) {

        Intent.FLAG_ACTIVITY_NEW_TASK
        val service = Intent(context, Logo::class.java)
        context.startActivity(service);



    }
}