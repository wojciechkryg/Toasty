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

    override fun onReceive(context: Context, intent: Intent) {
        if (isToastEnabled(context))
            showMessages(context, Telephony.Sms.Intents.getMessagesFromIntent(intent))
    }

    private fun isToastEnabled(context: Context): Boolean = context.defaultSharedPreferences
            .getBoolean(context.getString(R.string.settings_show_toast_key),
                    context.resources.getBoolean(R.bool.settings_show_toast_default))

    private fun showMessages(context: Context, messages: Array<SmsMessage>) {
        messages.forEach {
            showMessage(context, it)
        }
    }

    private fun showMessage(context: Context, it: SmsMessage) {
        context.longToast(it.messageBody)
    }
}
