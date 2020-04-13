package com.practiceandroid.waterbird.Activities;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.practiceandroid.waterbird.Adapters.ExpandableListAdapter;
import com.practiceandroid.waterbird.Classes.DemoClass;
import com.practiceandroid.waterbird.Classes.MenuItems;
import com.practiceandroid.waterbird.Fragments.HomeFragment;
import com.practiceandroid.waterbird.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout dl;
    private String value;


    private ActionBarDrawerToggle t;
    private NavigationView nv;
    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuItems> headerList = new ArrayList<>();
    HashMap<MenuItems, List<MenuItems>> childList = new HashMap<>();
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setContentView(R.layout.activity_home);
         dl = (DrawerLayout) findViewById(R.id.drawer_trading);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,dl,toolbar,R.string.drawerOpen, R.string.drawerClose){

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        if (DemoClass.check) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = LayoutInflater.from(this);
            final View view = inflater.inflate(R.layout.popup, null);
            builder.setView(view);
            final AlertDialog alertDialog = builder.create();
            TextView textView = view.findViewById(R.id.closepopup);
            Button got = view.findViewById(R.id.goweb);
            got.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("https://www.ictsystems.com.pk/"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                    DemoClass.check=false;
                }
            });
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                    DemoClass.check=false;
                }
            });
            alertDialog.show();

        }
        dl.setDrawerListener(actionBarDrawerToggle);

         actionBarDrawerToggle.syncState();

        ImageView menuRight =  findViewById(R.id.menuRightHome);
        final TextView start =  findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(HomeActivity.this,StartJourneyActivity.class));
                showAlertDialog();
            }
        });
        menuRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dl.isDrawerOpen(GravityCompat.START)) {
                    dl.closeDrawer(GravityCompat.START);
                } else {
                    dl.openDrawer(GravityCompat.START);
                }
            }
        });

        FragmentTransaction ft;
        HomeFragment fragmentHome = new HomeFragment();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frameLayoutHome, fragmentHome).commit();


//        getSupportActionBar().setDisplayShowTitleEnabled(true);
//         this.getSupportActionBar().setTitle("Trading");
//        this.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff005C97));
//         getSupportActionBar().setDisplayShowTitleEnabled(true);
        expandableListView = findViewById(R.id.expandableListView);
//        expandableListView.setIndicatorBounds();
        prepareMenuData();
        populateExpandableList();



        NavigationView navigationView = findViewById(R.id.navigationViewTradding);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_trading);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_trading);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void prepareMenuData() {



        MenuItems menuModel = new MenuItems("Dashboard", "",true, true, R.drawable.ic_dashboard_black_24dp); //Menu of Java Tutorials
        headerList.add(menuModel);
//        List<MenuItems> childModelsList = new ArrayList<>();
//        MenuModel childModel = new MenuModel("Purchase Requisicion", false, false, "https://www.journaldev.com/7153/core-java-tutorial");
//        childModelsList.add(childModel);
//
//        childModel = new MenuModel("Purchase Quotation", false, false, "https://www.journaldev.com/19187/java-fileinputstream");
//        childModelsList.add(childModel);
//
//        childModel = new MenuModel("Purchase Order", false, false, "https://www.journaldev.com/19115/java-filereader");
//        childModelsList.add(childModel);
//
//        childModel = new MenuModel("Good Recieve Notes", false, false, "https://www.journaldev.com/19115/java-filereader");
//        childModelsList.add(childModel);
//
//        childModel = new MenuModel("Purchase Invoice", false, false, "https://www.journaldev.com/19115/java-filereader");
//        childModelsList.add(childModel);
//
//
//        childModel = new MenuModel("Purchase Return", false, false, "https://www.journaldev.com/19115/java-filereader");
//        childModelsList.add(childModel);
//
//        childModel = new MenuModel("Debit Note", false, false, "https://www.journaldev.com/19115/java-filereader");
//        childModelsList.add(childModel);
//        if (menuModel.hasChildren) {
//            Log.d("API123","here");
//            childList.put(menuModel, childModelsList);
//        }
//
//        childModelsList = new ArrayList<>();
        menuModel = new MenuItems("Your Schedules ", "",true, true, R.drawable.schedule); //Menu of Python Tutorials
        headerList.add(menuModel);
        menuModel = new MenuItems("Create Custom Test ", "",true, true, R.drawable.test); //Menu of Python Tutorials
        headerList.add(menuModel);
        menuModel = new MenuItems("Customer Review ", "",true, true, R.drawable.ic_rate_review_black_24dp); //Menu of Python Tutorials
        headerList.add(menuModel);
        menuModel = new MenuItems("Trip History ", "",true, true, R.drawable.ic_history_black_24dp); //Menu of Python Tutorials
        headerList.add(menuModel);
        menuModel = new MenuItems("Settings  ", "",true, true, R.drawable.ic_settings_black_24dp); //Menu of Python Tutorials
        headerList.add(menuModel);
        menuModel = new MenuItems("Logout", "",true, true, R.drawable.logout); //Menu of Python Tutorials
        headerList.add(menuModel);
//        childModel = new MenuModel("Sales Requisicion ", false, false, "https://www.journaldev.com/19243/python-ast-abstract-syntax-tree");
//        childModelsList.add(childModel);
//
//        childModel = new MenuModel("Sales Quotation", false, false, "https://www.journaldev.com/19226/python-fractions");
//        childModelsList.add(childModel);
//        childModel = new MenuModel("Perform Invoices", false, false, "https://www.journaldev.com/19226/python-fractions");
//        childModelsList.add(childModel);
//        childModel = new MenuModel("Deivery Invoices", false, false, "https://www.journaldev.com/19226/python-fractions");
//        childModelsList.add(childModel);
//        childModel = new MenuModel("Sales Invoices", false, false, "https://www.journaldev.com/19226/python-fractions");
//        childModelsList.add(childModel);
//        childModel = new MenuModel("Sales Return", false, false, "https://www.journaldev.com/19226/python-fractions");
//        childModelsList.add(childModel);
//        childModel = new MenuModel("Credit Notes", false, false, "https://www.journaldev.com/19226/python-fractions");
//        childModelsList.add(childModel);
//        if (menuModel.hasChildren) {
//            childList.put(menuModel, childModelsList);
//        }
    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder( this);
        alertDialog.setTitle("Select Test");
        String[] items = {"Start New Test","Resume Test 1","Resume Test 2","Resume test 3","Resume Test 4"};
        int checkedItem = 1;
         alertDialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        startActivity(new Intent(HomeActivity.this,StartJourneyActivity.class));
                        //Toast.makeText( HomeActivity.this, "Clicked on java", Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        startActivity(new Intent(HomeActivity.this, TestActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(HomeActivity.this, TestActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(HomeActivity.this, TestActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(HomeActivity.this, TestActivity.class));
                        break;
                }
            }
        });
        AlertDialog alert = alertDialog.create();
        alert.setCanceledOnTouchOutside(false);
        alert.show();
    }
    private void populateExpandableList() {

        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(expandableListAdapter);
         expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
             @Override
             public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                 if(groupPosition==0){
                     startActivity(new Intent(HomeActivity.this,DashBoardActivity.class));
                     if (dl.isDrawerOpen(GravityCompat.START)) {
                         dl.closeDrawer(GravityCompat.START);
                     } else {
                         dl.openDrawer(GravityCompat.START);
                     }
                 }
                 if(groupPosition==1){
                     startActivity(new Intent(HomeActivity.this,ScheduleActivity.class));
                     if (dl.isDrawerOpen(GravityCompat.START)) {
                         dl.closeDrawer(GravityCompat.START);
                     } else {
                         dl.openDrawer(GravityCompat.START);
                     }
                 }
                 if(groupPosition==2){
                     startActivity(new Intent(HomeActivity.this,TestActivity.class));
                     if (dl.isDrawerOpen(GravityCompat.START)) {
                         dl.closeDrawer(GravityCompat.START);
                     } else {
                         dl.openDrawer(GravityCompat.START);
                     }
                 }
                 if(groupPosition==3){
                     startActivity(new Intent(HomeActivity.this, CustomerReviewActivity.class));
                     if (dl.isDrawerOpen(GravityCompat.START)) {
                         dl.closeDrawer(GravityCompat.START);
                     } else {
                         dl.openDrawer(GravityCompat.START);
                     }
                 }
                 if(groupPosition==4){
                     startActivity(new Intent(HomeActivity.this,TripHistoryActivity.class));
                     if (dl.isDrawerOpen(GravityCompat.START)) {
                         dl.closeDrawer(GravityCompat.START);
                     } else {
                         dl.openDrawer(GravityCompat.START);
                     }
                 }
                 return false;
             }
         });

//        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//            @Override
//            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
//
//
//                ImageView imageView=v.findViewById(R.id.expend);
//                if(showPass){
//                    showPass = false;
//                    imageView.setImageResource(R.drawable.ic_expand_less_black_24dp);
////                    et_password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
//                }else{
//                    showPass = true;
//                    imageView.setImageResource(R.drawable.ic_expand_more_black_24dp);
////                    et_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//                }
//
//                return false;
//            }
//        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {



                return false;
            }
        });
    }


}
