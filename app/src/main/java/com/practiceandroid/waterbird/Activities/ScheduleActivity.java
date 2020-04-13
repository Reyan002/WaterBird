package com.practiceandroid.waterbird.Activities;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.practiceandroid.waterbird.Adapters.SchduleAdapter;
import com.practiceandroid.waterbird.Classes.Schedule;
import com.practiceandroid.waterbird.R;

import java.util.ArrayList;

public class ScheduleActivity extends AppCompatActivity {
    private ArrayList<Schedule> list;
    private RecyclerView recyclerView;
    private SchduleAdapter adapter;
    private LinearLayoutManager layoutManager;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Schedule");

        recyclerView= findViewById(R.id.scheduleRecyclerview);
        list=new ArrayList<>();

        list.add(new Schedule("RPT-1809","Marafeq General Service","4/7/2020"));
        list.add(new Schedule("RPT-1810","Marafeq General Service","4/7/2020"));
        list.add(new Schedule("RPT-1811","Marafeq General Service","4/7/2020"));
        list.add(new Schedule("RPT-1812","Marafeq General Service","4/7/2020"));
        list.add(new Schedule("RPT-1813","Marafeq General Service","4/7/2020"));
        list.add(new Schedule("RPT-1814","Marafeq General Service","4/7/2020"));
        list.add(new Schedule("RPT-1815","Marafeq General Service","4/7/2020"));
        list.add(new Schedule("RPT-1816","Marafeq General Service","4/7/2020"));
        list.add(new Schedule("RPT-1817","Marafeq General Service","4/7/2020"));
        list.add(new Schedule("RPT-1818","Marafeq General Service","4/7/2020"));
        list.add(new Schedule("RPT-1819","Marafeq General Service","4/7/2020"));
        list.add(new Schedule("RPT-1820","Marafeq General Service","4/7/2020"));


        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

         adapter=new SchduleAdapter( );
         adapter.setScheduleList(list,this
         );
        Toast.makeText(this, String.valueOf(list.size()), Toast.LENGTH_SHORT).show();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

//        FragmentTransaction ft;
//        ScheduleListFragment fragmentHome = new ScheduleListFragment();
//        ft = getSupportFragmentManager().beginTransaction();
//        ft.add(R.id.frameLayoutSchedule, fragmentHome).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchmenu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.app_bar_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.app_bar_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
