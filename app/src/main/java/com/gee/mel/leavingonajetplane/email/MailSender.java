package com.gee.mel.leavingonajetplane.email;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Melody on 10/17/2017.
 */

public class MailSender {
    private Context AppContext;

    public MailSender(android.content.Context appContext) {
        this.AppContext = appContext;
    }
    public void sendMail(String recipient, String subject, String body) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{recipient});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEMPLATE, body);
        AppContext.startActivity(Intent.createChooser(emailIntent, "Choose an email client:"));
    }
}
