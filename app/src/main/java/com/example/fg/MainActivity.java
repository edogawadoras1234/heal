package com.example.fg;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private DrawerLayout hienthi;
    private ActionBarDrawerToggle mToggle;
    Button bnthengio, Bntdunglai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hienthi = (DrawerLayout) findViewById(R.id.drawer);
//        Item Menu
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//        Menu
        mToggle = new ActionBarDrawerToggle(this,hienthi,R.string.open,R.string.close);
        hienthi.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        click item
        if (savedInstanceState == null){
        getSupportFragmentManager().beginTransaction().replace(R.id.Nen,
                new BaoThuc()).commit();
        navigationView.setCheckedItem(R.id.baothuc);}
//FragmentBaothuc

    }
//    Item list
        @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.baothuc:
                getSupportFragmentManager().beginTransaction().replace(R.id.Nen, new BaoThuc()).commit();
                break;
            case R.id.anuong:
                getSupportFragmentManager().beginTransaction().replace(R.id.Nen, new TinhBMI()).commit();
                break;
            case R.id.tinhbmi:
                getSupportFragmentManager().beginTransaction().replace(R.id.Nen, new AnUong()).commit();
                break;
            case R.id.note:
                getSupportFragmentManager().beginTransaction().replace(R.id.Nen, new Note()).commit();
                break;
        }
        hienthi.closeDrawer(GravityCompat.START);
        return true;
        }
//    Menu list

        public boolean onOptionsItemSelected (MenuItem item){
            if (mToggle.onOptionsItemSelected(item)) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }


}
