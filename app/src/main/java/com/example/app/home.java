package com.example.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class home extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar=findViewById(R.id.toolbar);

       drawerLayout=findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

                switch ((item.getItemId())){
                    case R.id.applyforleaves:
                        loadFragment(new Applyforleavesfragment());
                        /*getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                new Applyforleavesfragment()).commit();*/
                        break;
                    case R.id.attendancerecord:

                        loadFragment(new attendance_record_fragment());
                        break;
                    case R.id.invite_people:
                        loadFragment(new people_invite_fragment());

                        break;
                    case R.id.Profile:
                        loadFragment(new profile_fragment());

                        break;
                    case R.id.File_organization:
                        loadFragment(new fileorganizationfragment());

                        break;
                    case R.id.Schedule_meeting:
                        loadFragment(new Schedule_Meeting());

                        break;


                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        loadFragment(new f1());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        menu.clear();
        inflater.inflate(R.menu.option, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {  //It is used for handling item selection. //IIly, for ContextMenu change onContextItemSelected
        switch (item.getItemId()) {
            case R.id.a: /*Perform function*/  return true;
            default:    return super.onOptionsItemSelected(item);
        }
    }





    @Override
    public boolean onNavigationItemSelected( MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.nf1: fragment = new f1(); break;
            case R.id.nf2: fragment = new f2(); break;
            case R.id.nf3: fragment = new f3(); break;
            case R.id.nf4: fragment = new f4(); break;
            case R.id.nf5: fragment = new f5(); break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}