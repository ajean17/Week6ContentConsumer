package com.example.alvin.w6_hw_01;

import android.content.ContentProviderClient;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri = Uri.parse("content://com.example.alvin.w5_d3_ex01/genre");
        ContentProviderClient providerClient = getContentResolver().acquireContentProviderClient(uri);

        try {
            Cursor cursor = providerClient.query(uri, null, null, null, null);
            Log.d(TAG, "Success boi!!!");
        } catch (RemoteException e) {
            e.printStackTrace();

            Log.d(TAG, "Failure son!!!");
        }
    }
}
