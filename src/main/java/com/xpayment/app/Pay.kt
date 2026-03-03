package com.xpayment.app

import android.content.Context
import com.xpayment.app.Opener.openApp

fun pay(
    context: Context,
    type: Type,
    orderId: String,
    symbol: String,
    amount: String,
    to: String,
    appReturnUrl: String?,
): Boolean {
    val params = buildMap {
        put("orderId", orderId)
        put("symbol", symbol)
        put("amount", amount)
        put("to", to)
        appReturnUrl?.let { put("appReturnUrl", it) }
    }

    return openApp(context, type, params)
}