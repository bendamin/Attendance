package com.maleficcircles.attendance;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    boolean used = false;

    String Monday[] = {"Data Communications\nKevin Street\n4th Floor","Object Oriented Programming\nKevin Street\n4th Floor"};
    String MondayTimes[] = {"\n10:00\n\n11:00\n","\n11:00\n\n\n\n\n13:00\n"};

    String Tuesday[] = {"Legal And Professional Issues\nKevin Street\n4th Floor","Legal And Professional Issues\nKevin Street\n1st Floor","","Data Communications\nKevin Street\n4th Floor"};
    String TuesdayTimes[] = {"\n12:00\n\n13:00\n","\n13:00\n\n14:00\n","\n\n\n\n\n\n\n","\n16:00\n\n17:00\n"};

    String Wednesday[] = {"Legal And Professional Issues\nKevin Street\n4th Floor","","Software Engineering 2\nKevin Street\n2nd Floor","","Software Engineering 2\nAnnex Building\n1st Floor","Object Oriented Programming\nAnnex Building\n1st Floor"};
    String WednesdayTimes[] = {"\n10:00\n\n11:00\n","\n\n\n\n","\n12:00\n\n\n\n14:00\n","\n\n\n\n","\n15:00\n\n16:00\n","\n16:00\n\n18:00\n"};

    String Thursday[] = {"Object Oriented Programming\nnKevin Street\n4th Floor","Human Computer Interaction\nKevin Street\n4th Floor","Data Communication\nKevin Street\n3rd Floor","","Internship Program\nKevin Street\n4th Floor","Human Computer Interaction\nAungier Street\n1st Floor"};
    String ThursdayTime[] = {"\n09:00\n\n10:00\n","\n10:00\n\n11:00\n","\n11:00\n\n12:00\n","\n\n\n\n","\n13:00\n\n14:00\n","\n14:00\n\n\n\n16:00\n"};

    String Friday[] = {"Algorithms And Data Structures\nAnnex Building\n3rd Floor","Human Computer Interaction\nKevin Street\n2nd Floor","Data Communications\nKevin Street\n2nd Floor","Algorithms And Data Structures\nKevin Street\n2nd Floor","","Algorithms And Data Structures\nKevin Street\n1st Floor","Algorithms And Data Structures\nKevin Street\n1st Floor"};
    String FridayTime[] = {"\n09:00\n\n10:00\n","\n10:00\n\n11:00\n","\n11:00\n\n12:00\n","\n12:00\n\n13:00\n","\n\n\n\n","\n14:00\n\n15:00\n","\n15:00\n\n16:00\n"};




    int classViews[] = {R.id.class1,R.id.class2,R.id.class3,R.id.class4,R.id.class5,R.id.class6,R.id.class7};
    int timeViews[] = {R.id.time1,R.id.time2,R.id.time3,R.id.time4,R.id.time5,R.id.time6,R.id.time7};
    int lays[] = {R.id.lay1,R.id.lay2,R.id.lay3,R.id.lay4,R.id.lay5,R.id.lay6,R.id.lay6,R.id.lay7};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                role();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day) {
            case Calendar.MONDAY:
                // Current day is Monday
                setDay(0);
                break;
            case Calendar.TUESDAY:
                setDay(1);
                // etc.
                break;
            case Calendar.WEDNESDAY:
                setDay(2);
                // etc.
                break;
            case Calendar.THURSDAY:
                setDay(0);
                // etc.
                break;
            case Calendar.FRIDAY:

                sendNotification();
                setDay(4);
                // etc.
                break;
            default:
                //notification code
                //keep this too

                setDay(0);
                break;
        }

    }

    public void setDay(int day){

        ArrayList<String> currentDay = new ArrayList<String>();
        ArrayList<String> currentTime = new ArrayList<String>();

        int numClasses = 0;

        switch (day){
            case 0:
                for(int j = 0; j < Monday.length; j++) {
                    currentDay.add(Monday[j]);
                    currentTime.add(MondayTimes[j]);
                    numClasses = Monday.length;
                }

                break;
            case 1:
                for(int j = 0; j < Tuesday.length; j++) {
                    currentDay.add(Tuesday[j]);
                    currentTime.add(TuesdayTimes[j]);
                    numClasses = Tuesday.length;
                }
                // etc.
                break;
            case 2:for(int j = 0; j < Wednesday.length; j++) {
                currentDay.add(Wednesday[j]);
                currentTime.add(WednesdayTimes[j]);
                numClasses = Wednesday.length;
            }
                // etc.
                break;
            case 3:for(int j = 0; j < Thursday.length; j++) {
                currentDay.add(Thursday[j]);
                currentTime.add(ThursdayTime[j]);
                numClasses = Thursday.length;}

                // etc.
                break;
            case 4:for(int j = 0; j < Friday.length; j++) {
                currentDay.add(Friday[j]);
                currentTime.add(FridayTime[j]);
                numClasses = Friday.length;}

                // etc.
                break;
            default:
                break;
        }


        LinearLayout lay;
        for(int dayCount = 0; dayCount < 7; dayCount++) {

            if(dayCount<numClasses) {

                TextView time1 = (TextView) findViewById(timeViews[dayCount]);
                time1.setText(currentTime.get(dayCount));

                TextView class1 = (TextView) findViewById(classViews[dayCount]);
                class1.setText(currentDay.get(dayCount));

            } else{
                TextView time1 = (TextView) findViewById(timeViews[dayCount]);
                time1.setText("");

                TextView class1 = (TextView) findViewById(classViews[dayCount]);
                class1.setText("");

                lay = findViewById(lays[dayCount]);
                lay.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        }
        for(int dayCount = 1; dayCount < 7; dayCount=dayCount+2) {
            if(dayCount <= numClasses){
            lay = findViewById(lays[dayCount]);
            lay.setBackgroundColor(Color.parseColor("#CCCCCC"));
            }
        }
        currentDay.clear();
        currentTime.clear();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_mon) {
            setDay(0);

        } else if (id == R.id.nav_tues) {
            setDay(1);
        } else if (id == R.id.nav_wed) {
            setDay(2);

        } else if (id == R.id.nav_thurs) {
            setDay(3);

        } else if (id == R.id.nav_fri) {
            setDay(4);

        } else if (id == R.id.nav_check) {
            role();
        } else if (id == R.id.nav_record) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void submit(){
        Context context = getApplicationContext();
        CharSequence text = "Submitted!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    public void role(){
        Intent intent = new Intent(this, Rolecall.class);
        startActivity(intent);
    }

    public void sendNotification() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Weekend";
            String description = "No classes on today";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("Weekend", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);}


            Intent intent = new Intent(this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "Weekend")
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("It's The Weekend!")
                    .setContentText("Reminder: Data Communications at 10 AM")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    // Set the intent that will fire when the user taps the notification
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

// notificationId is a unique int for each notification that you must define
            notificationManager.notify(1, builder.build());
    }
}
