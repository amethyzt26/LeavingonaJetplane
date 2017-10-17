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
    public void sendMail() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:melodygiuco.work@gmail.com"));
        AppContext.startActivity(emailIntent);
    }
}
