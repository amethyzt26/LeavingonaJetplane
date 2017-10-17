package com.gee.mel.leavingonajetplane;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.MalformedJsonException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gee.mel.leavingonajetplane.email.MailSender;
import com.gee.mel.leavingonajetplane.messages.SmsSender;
import com.gee.mel.leavingonajetplane.permissions.PermissionManager;

public class MainActivity extends AppCompatActivity {
    private static final String MESSAGE_RECEPIENT = "09989660768";
    private PermissionManager permissionManager;
    private SmsSender smsSender;
    private MailSender mailSender;
    private Button btnSms;
    private Button btnMail;
    private EditText txt_Message;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.smsSender = new SmsSender(getApplicationContext());
        this.mailSender = new MailSender(getApplicationContext());
        this.permissionManager = new PermissionManager(this);
        permissionManager.grantPermissions();

        btnSms = (Button) findViewById(R.id.smsBtn);
        btnMail = (Button) findViewById(R.id.emailBtn);
        txt_Message = (EditText) findViewById(R.id.messageText);

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSms();
            }
        });

        btnMail.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               sendMail();
           }
        });
    }

    private void sendMail() {
        mailSender.sendMail();
    }

    private void sendSms() {
        message = txt_Message.getText().toString();
        smsSender.sendSms(message, MESSAGE_RECEPIENT);
    }
}
