package com.example.roshan.zappfood.Login;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roshan.zappfood.R;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class QR_Scan extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 0;
    private ZXingScannerView mScannerView;
    private TextView txt_view;
    private Activity activity;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mScannerView = new ZXingScannerView(this);
        Toast.makeText(this, "Scan table code", Toast.LENGTH_SHORT).show();
//        txt_view = (TextView)findViewById(R.id.txt_view);
        // Set the scanner view as the content view
        setContentView(mScannerView);


        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CAMERA)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMERA);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
        }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
        @Override
        public void onResume() {
            super.onResume();

            // Register ourselves as a handler for scan results.
            mScannerView.setResultHandler(this);
            // Start camera on resume
            mScannerView.startCamera();
        }

        @Override
        public void onPause() {
            super.onPause();
            mScannerView.stopCamera();
        }

        @Override
        public void onBackPressed() {
            this.finishAffinity();

        }

        @Override
        public void handleResult(Result result) {


            Log.v("result", result.getText());
            // Prints the scan format (qrcode, pdf417 etc.)
            Log.v("result", result.getBarcodeFormat().toString());
            //If you would like to resume scanning, call this method below:
            mScannerView.resumeCameraPreview(this);

            Intent i = new Intent(getApplicationContext(), Login_Screen.class);
            i.putExtra("table_id", result.getText());
            startActivity(i);
        }
    }
