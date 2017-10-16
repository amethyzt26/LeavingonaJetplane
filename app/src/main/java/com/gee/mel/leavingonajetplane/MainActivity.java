package com.gee.mel.leavingonajetplane;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gee.mel.leavingonajetplane.messages.SmsSender;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    private static final String MESSAGE_RECEPIENT = "09989660768";

    SmsSender smsSender;
    Button btn_Send;
    EditText txt_Message;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.smsSender = new SmsSender(getApplicationContext());

        btn_Send = (Button) findViewById(R.id.button);
        txt_Message = (EditText) findViewById(R.id.editText2);

        btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSMSMessage();
            }
        });
    }

    private void sendSMSMessage() {
        message = txt_Message.getText().toString();

        /* check permission */
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(
                    this, Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }

        /* send message */
        smsSender.sendSms(message, MESSAGE_RECEPIENT);
    }
}
