package com.example.score4;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.score4.LocalDB.AthleteDB;
import com.example.score4.LocalDB.AthleteManageData;
import com.example.score4.LocalDB.FillDB;
import com.example.score4.LocalDB.LocalDatabase;
import com.example.score4.LocalDB.SportDB;
import com.example.score4.LocalDB.SportManageData;
import com.example.score4.LocalDB.TeamManageData;
import com.example.score4.RemoteDB.GetData;
import com.example.score4.RemoteDB.UpdateData;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    public static FirebaseFirestore db;
    public static LocalDatabase localDB;
    public static NotificationCompat.Builder builder;

    public static ArrayList<Map> Basketball = new ArrayList<>();
    public static ArrayList<Map> Boxing = new ArrayList<>();
    public static ArrayList<Map> Football = new ArrayList<>();
    public static ArrayList<Map> Volleyball = new ArrayList<>();
    public static ArrayList<Map> Wrestling = new ArrayList<>();

    public static ArrayList<String> idListBasketball = new ArrayList<>();
    public static ArrayList<String> idListVolleyball = new ArrayList<>();
    public static ArrayList<String> idListFootball = new ArrayList<>();
    public static ArrayList<String> idListBoxing = new ArrayList<>();
    public static ArrayList<String> idListWrestling = new ArrayList<>();

    public static String date;

    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;

    public static Stack<Fragment> fragmentStack = new Stack<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createNotificationChannel();

        builder = new NotificationCompat.Builder(this, getString(R.string.channel_id)).setSmallIcon(R.drawable.logo)
                .setContentTitle("title text")
                .setContentText("contenttext")
                .setPriority(NotificationCompat.PRIORITY_MAX)
        ;

        db = FirebaseFirestore.getInstance();
        localDB = Room.databaseBuilder(getApplicationContext(), LocalDatabase.class, "LocalDB").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        GetData.getSportData("Basketball", Basketball, this);
        GetData.getSportData("Boxing", Boxing, this);
        GetData.getSportData("Football", Football, this);
        GetData.getSportData("Volleyball", Volleyball, this);
        GetData.getSportData("Wrestling", Wrestling, this);

        UpdateData.getAllDocumentIds(idListBasketball, "Basketball");
        UpdateData.getAllDocumentIds(idListBoxing, "Boxing");
        UpdateData.getAllDocumentIds(idListFootball, "Football");
        UpdateData.getAllDocumentIds(idListWrestling, "Wrestling");
        UpdateData.getAllDocumentIds(idListVolleyball, "Volleyball");

        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = dateFormat.format(calendar.getTime());

        FillDB.filldb(this);

        setContentView(R.layout.activity_main);

        // Set a Toolbar to replace the ActionBar.
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // This will display an Up icon (<-), we will replace it with hamburger later
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Find our drawer view
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();

        // Setup toggle to display hamburger icon with nice animation
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();

        // Tie DrawerLayout events to the ActionBarToggle
        drawerLayout.addDrawerListener(drawerToggle);

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        // Setup drawer view
        setupDrawerContent(navigationView);

        Homescreen homescreen = new Homescreen();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, homescreen);
        fragmentTransaction.commit();

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }

    private void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.team_sports_button:
                fragmentClass = Team_Sports.class;
                break;
            case R.id.individual_sports_button:
                fragmentClass = Individual_Sports.class;
                break;
            case R.id.athletes_button:
                fragmentClass = Athlete_Selection.class;
                break;
            case R.id.teams_button:
                fragmentClass = Team_Selection.class;
                break;
            default:
                fragmentClass = Homescreen.class; //IDK IF THAT'S OK
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        drawerLayout.closeDrawers();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }

    private void createNotificationChannel() {
            CharSequence name = getString(R.string.channel_id);
            int importance = NotificationManager.IMPORTANCE_HIGH; // To IMPORTANCE_HIGH dhmiourgei popup notification
            NotificationChannel channel = new NotificationChannel(getString(R.string.channel_id), name, importance);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
    }

}