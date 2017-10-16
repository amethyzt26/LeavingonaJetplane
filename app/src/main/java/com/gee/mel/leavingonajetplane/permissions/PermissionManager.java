package com.gee.mel.leavingonajetplane.permissions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Melody on 10/17/2017.
 */

public class PermissionManager {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0 ;
    private static final int MY_PERMISSIONS_REQUEST_READ_SMS = 0 ;
    private AppCompatActivity compatActivity;

    public PermissionManager(AppCompatActivity compatActivity) {
        this.compatActivity = compatActivity;
    }

    public void grantPermissions() {
        grantReadSmsPermission();
        grantSendSmsPermission();
    }

    private void grantSendSmsPermission() {
        if(ContextCompat.checkSelfPermission(compatActivity,
                Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(
                    compatActivity, Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(compatActivity,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
    }

    private void grantReadSmsPermission()  {
        if(ContextCompat.checkSelfPermission(compatActivity,
                Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(
                    compatActivity, Manifest.permission.READ_SMS)) {
            } else {
                ActivityCompat.requestPermissions(compatActivity,
                        new String[]{Manifest.permission.READ_SMS},
                        MY_PERMISSIONS_REQUEST_READ_SMS);
            }
        }
    }
}