package com.example.knowledgeninja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.knowledgeninja.R;

import java.util.Random;

public class MainMenu extends AppCompatActivity
{
    //ParentPortal
    TextView tvParentPortal;
    ImageView logo, tvSpace, tvAnimals, tvNature, tvTechnology, tvHistory;

    private static final String PIN_PREFS = "PinPrefs";
    private static final String PIN_KEY = "pin";
    private SharedPreferences sharedPreferences;
    private Dialog pinDialog, pinEnterDialog;
    private EditText etPin, etEnterPin;
    private EditText etConfirmPin;

    private String[] facts;
    private static final String NOTIFICATION_CHANNEL_ID = "random_facts_channel";
    private static final int NOTIFICATION_ID = 1;
    private static final int TWELVE_HOURS_MS = 12*60*60*1000;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        //Notification permissions
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            if(ContextCompat.checkSelfPermission(MainMenu.this,
                    android.Manifest.permission.POST_NOTIFICATIONS) !=
                    PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(MainMenu.this,
                        new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }
        //Notification alarm manager (For daily facts)
        scheduleNotificationAlarm();
        //Parent portal pin
        sharedPreferences = getSharedPreferences(PIN_PREFS, MODE_PRIVATE);

        boolean isPinSet = sharedPreferences.contains(PIN_KEY);
        if(!isPinSet) {
            showAddPinDialog();
        }

        //Notification builder
        facts = getResources().getStringArray(R.array.random_facts);

        //Main menu buttons
        logo=findViewById(R.id.logo);
        tvSpace = findViewById(R.id.imageViewSpace);
        tvAnimals = findViewById(R.id.imageViewAnimals);
        tvNature = findViewById(R.id.imageViewNature);
        tvTechnology = findViewById(R.id.imageViewTechnology);
        tvHistory = findViewById(R.id.imageViewHistory);

        tvParentPortal = findViewById(R.id.tvKnowledgeNinja);

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeNotification();
            }
        });
        //ParentPortal access button
        tvParentPortal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showEnterPinDialog();
            }
        });
        tvSpace.setOnClickListener(view ->
        {
            String str = "Space";
            Intent intent = new Intent(MainMenu.this, Data.class);
            intent.putExtra("message_key", str);
            startActivity(intent);
        });

        tvAnimals.setOnClickListener(view ->
        {
            String str = "Animals";
            Intent intent = new Intent(MainMenu.this, Data.class);
            intent.putExtra("message_key", str);
            startActivity(intent);
        });

        tvNature.setOnClickListener(view ->
        {
            String str = "Nature";
            Intent intent = new Intent(MainMenu.this, Data.class);
            intent.putExtra("message_key", str);
            startActivity(intent);
        });

        tvTechnology.setOnClickListener(view ->
        {
            String str = "Technology";
            Intent intent = new Intent(MainMenu.this, Data.class);
            intent.putExtra("message_key", str);
            startActivity(intent);
        });

        tvHistory.setOnClickListener(view ->
        {
            String str = "History";
            Intent intent = new Intent(MainMenu.this, Data.class);
            intent.putExtra("message_key", str);
            startActivity(intent);
        });
    }

    private void scheduleNotificationAlarm() {
        // Set up the alarm to go off once a day (every 24 hours)
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent notificationIntent = new Intent(getApplicationContext(), NotificationBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        long notificationTime = System.currentTimeMillis() + AlarmManager.INTERVAL_DAY;
        if (alarmManager != null) {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, notificationTime, AlarmManager.INTERVAL_DAY, pendingIntent);
        }
    }

    private void makeNotification() {
        //TODO MAKE STRINGS ROTATE
        String[] facts = getResources().getStringArray(R.array.random_facts);

        //Generate random facts
        Random random = new Random();
        int randomIndex = random.nextInt(facts.length);
        String fact = facts[randomIndex];


        String channel_id= "CHANNEL_ID_NOTIFICATION";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),channel_id );
        builder.setSmallIcon(R.drawable.transfericon);
        builder.setContentTitle("Did you know...");
        builder.setContentTitle(fact);
        builder.setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        Intent intent = new Intent(getApplicationContext(), NotificationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("data", fact);


        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),
                0, intent, PendingIntent.FLAG_MUTABLE);
        builder.setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel =
                    notificationManager.getNotificationChannel(channel_id);
            if(notificationChannel == null){
                int importance = NotificationManager.IMPORTANCE_HIGH;
                notificationChannel = new NotificationChannel(channel_id, "Facts", importance);
                notificationChannel.setLightColor(Color.GREEN);
                notificationChannel.enableVibration(true);
                notificationManager.createNotificationChannel(notificationChannel);

            }

        }
        notificationManager.notify(0, builder.build());
    }


    private void showEnterPinDialog() {
        pinEnterDialog = new Dialog(this);
        View viewEnterDialog = LayoutInflater.from(this).inflate(R.layout.enter_pin_dialog, null);
        pinEnterDialog.setContentView(viewEnterDialog);

        etEnterPin = viewEnterDialog.findViewById(R.id.etPinEnter);
        Button btnEnterSavedPin = viewEnterDialog.findViewById(R.id.buttonEnterPin);
        Button btnCancelPin = viewEnterDialog.findViewById(R.id.buttonCancelPin1);


        btnEnterSavedPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredPin = etEnterPin.getText().toString();
                if(checkPin(enteredPin)){
                    Intent intent = new Intent(MainMenu.this, ParentPortalHome.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainMenu.this , "Please enter correct pin", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnCancelPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pinEnterDialog.dismiss();
            }
        });
        pinEnterDialog.show();
    }

    private void showAddPinDialog() {

        pinDialog = new Dialog(this);
        View view = LayoutInflater.from(this).inflate(R.layout.popup_pin, null);
        pinDialog.setContentView(view);

        etPin = view.findViewById(R.id.etPin);
        etConfirmPin = view.findViewById(R.id.etConfirmPin);
        Button btnSavePin = view.findViewById(R.id.buttonSavePin);
        Button btnCancelPin = view.findViewById(R.id.buttonCancelPin);
        btnSavePin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pin = etPin.getText().toString();
                String confirmPin = etConfirmPin.getText().toString();

                if(pin.equals(confirmPin)){
                    savePin(pin);
                    pinDialog.dismiss();
                }else{
                    Toast.makeText(MainMenu.this, "Please enter matching pin",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnCancelPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pinDialog.dismiss();
            }
        });
        pinDialog.show();
    }

    private void savePin(String pin) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PIN_KEY, pin);
        editor.apply();
        Toast.makeText(MainMenu.this , "Successfully saved pin", Toast.LENGTH_LONG).show();
    }

    private boolean checkPin(String pin) {
        String savedPin = sharedPreferences.getString(PIN_KEY, "");
        return savedPin.equals(pin);
    }

    private class NotificationBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            makeNotification();
        }
    }


    //public boolean onCreateOptionsMenu(Menu menu)
    //{
    //    getMenuInflater().inflate(R.menu.popout_menu, menu);
    //    return true;
    //}
    //public boolean onOptionsItemSelected(MenuItem item)
    //{
    //    int id = item.getItemId();
    //    if (id == R.id.action_setting)
    //    {
    //        return true;
    //    }
    //    else if (id == R.id.action_profile)
    //    {
    //        return true;
    //    }
    //    else if (id == R.id.action_parent)
    //    {
    //        return true;
    //    }
    //    return super.onOptionsItemSelected(item);
    //}
}