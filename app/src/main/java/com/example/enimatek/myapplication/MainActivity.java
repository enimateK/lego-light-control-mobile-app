package com.example.enimatek.myapplication;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private static final String APP_UUID = "00110000-0000-0001-7500-00514F8C11AC";

    BluetoothAdapter adapter;
    BluetoothSocket rfcommSocket;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            if (connectToEV3()) {

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            // Allumer
            case R.id.button3:
                break;
            //Eteindre
            case R.id.button4:
                break;
            // + Lampe
            case R.id.button7:
                break;
            // - Lampe
            case R.id.button8:
                break;
        }
    }



    public  boolean connectToEV3() throws InterruptedException{

        adapter=BluetoothAdapter.getDefaultAdapter();
        BluetoothDevice briqueEv3 = adapter.getRemoteDevice("00:16:53:5C:89:FD");
        try {
            rfcommSocket = briqueEv3.createRfcommSocketToServiceRecord(UUID.fromString(APP_UUID));
            rfcommSocket.connect();


        } catch (IOException e) {

            return false;
        }

        return true;
    }

}