package com.example.roshan.zappfood;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.roshan.zappfood.ModelClass.DbHandler;
import com.example.roshan.zappfood.Nav_Menu.About_Us;
import com.example.roshan.zappfood.Nav_Menu.Cart;
import com.example.roshan.zappfood.Nav_Menu.Contact_Us;
import com.example.roshan.zappfood.Nav_Menu.Home;
import com.example.roshan.zappfood.Nav_Menu.Online_Order;
import com.example.roshan.zappfood.Nav_Menu.Order_Now;

import static com.example.roshan.zappfood.ModelClass.DbHandler.table_name;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DbHandler myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setUiOptions(ActivityInfo.UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myDb=new DbHandler(getApplicationContext());


        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));
        FragmentManager fragmentManager = getSupportFragmentManager();
        {
            getSupportActionBar().setTitle("Home");
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new Home())
                    .commit();}

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close){

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("ZappFood");
            }
        };
        drawer.setDrawerListener(toggle);
        drawer.setScrimColor(getResources().getColor(android.R.color.transparent));
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

        disableNavigationViewScrollbars(navigationView);

    }

    private void disableNavigationViewScrollbars(NavigationView navigationView) {
        if (navigationView != null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
            if (navigationMenuView != null) {

            }
        }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            this.finishAffinity();
            myDb.deletedata(table_name);
        }
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_search) {
//            return true;
//        }else if (id == R.id.action_refresh){
//            return true;
//        }else if (id == R.id.action_help){
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.nav_home) {
          getSupportActionBar().setTitle("Home");
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new Home())
                    .commit();
            // Handle the attendance action
        } else if (id == R.id.nav_order_now) {
            getSupportActionBar().setTitle("Categorie");
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new Order_Now())
                    .commit();

        } else if (id == R.id.nav_order_online) {
            getSupportActionBar().setTitle("Online Order");
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new Online_Order())
                    .commit();
        }
       else if (id == R.id.nav_cart) {
            getSupportActionBar().setTitle("Cart");
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new Cart())
                    .commit();
        }
        else if (id == R.id.nav_contact_us) {
            getSupportActionBar().setTitle("Contact Us");
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new Contact_Us())
                    .commit();
        } else if (id == R.id.nav_about_us) {
            getSupportActionBar().setTitle("About Us");
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new About_Us())
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
