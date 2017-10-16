package com.gee.mel.leavingonajetplane;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gee.mel.leavingonajetplane.messages.SmsSender;
import com.gee.mel.leavingonajetplane.permissions.PermissionManager;

public class MainActivity extends AppCompatActivity {
    private static final String MESSAGE_RECEPIENT = "09989660768";
    private PermissionManager permissionManager;
    private SmsSender smsSender;
    private Button btn_Send;
    private EditText txt_Message;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.smsSender = new SmsSender(getApplicationContext());
        this.permissionManager = new PermissionManager(this);
        permissionManager.grantPermissions();

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
        smsSender.sendSms(message, MESSAGE_RECEPIENT);
    }
}
