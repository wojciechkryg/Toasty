package com.wojdor.toasty.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.telephony.SmsMessage
import com.wojdor.toasty.R
import org.jetbrains.anko.defaultSharedPreferences
import org.jetbrains.anko.longToast

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(ctx: Context, intent: Intent) {
        if (isToastEnabled(ctx))
            showMessages(ctx, Telephony.Sms.Intents.getMessagesFromIntent(intent))
    }

    private fun isToastEnabled(ctx: Context): Boolean = ctx.defaultSharedPreferences
            .getBoolean(ctx.getString(R.string.settings_show_toast_key),
                    ctx.resources.getBoolean(R.bool.settings_show_toast_default))

    private fun showMessages(ctx: Context, messages: Array<SmsMessage>) {
        messages.forEach {
            showMessage(ctx, it)
        }
    }

    private fun showMessage(ctx: Context, it: SmsMessage) {
        ctx.longToast(it.messageBody)
    }
}
