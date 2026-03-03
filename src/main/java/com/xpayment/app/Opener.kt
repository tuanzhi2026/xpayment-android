package com.xpayment.app

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log

internal object Opener {
    fun openApp(
        context: Context,
        type: Type,
        params: Map<String, String>
    ): Boolean {
        val uri = Uri.Builder()
            .scheme(when (type) {
                Type.Pai -> "paipay"
                Type.Lanton -> "lanton"
            })
            .encodedOpaquePart("requestPay?${params.entries.joinToString("&") {
                (key, value) -> "${key}=${value}"
            }}")
            .build()

        Log.i("paiopener uri", uri.toString())
        val intent = Intent(Intent.ACTION_VIEW, uri).apply { flags = Intent.FLAG_ACTIVITY_NEW_TASK }

        return try {
            context.startActivity(intent)
            true
        } catch (e: Exception) {
            Log.e("paiopener exception", e.toString() )
            false
        }
    }
}