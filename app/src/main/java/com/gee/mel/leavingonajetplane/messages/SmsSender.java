package com.gee.mel.leavingonajetplane.messages;

import android.content.Context;
import android.telephony.SmsManager;
import android.widget.Toast;

/**
 * Created by Melody on 10/16/2017.
 */

public class SmsSender {
    private Context AppContext;

    public SmsSender(Context appContext)
    {
        this.AppContext = appContext;
    }

    public void sendSms(String message, String recepient) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(recepient, null, message, null, null);
        Toast.makeText(AppContext, "SMS sent.",
                Toast.LENGTH_LONG).show();
    }
}
