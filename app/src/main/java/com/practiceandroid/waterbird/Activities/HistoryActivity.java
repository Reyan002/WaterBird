package com.practiceandroid.waterbird.Activities;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.practiceandroid.waterbird.Adapters.HistoryAdapter;
import com.practiceandroid.waterbird.Classes.History;
import com.practiceandroid.waterbird.R;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private ArrayList<History> list;
    private RecyclerView recyclerView;
    private HistoryAdapter adapter;
    private LinearLayoutManager layoutManager;
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("History");
        recyclerView= findViewById(R.id.recyclerviewHistory);
        list=new ArrayList<>();

        list.add(new History("RPT-1809","Marafeq General Service","4/7/2020"));
        list.add(new History("RPT-1810","Marafeq General Service","4/7/2020"));
        list.add(new History("RPT-1811","Marafeq General Service","4/7/2020"));
        list.add(new History("RPT-1812","Marafeq General Service","4/7/2020"));
        list.add(new History("RPT-1813","Marafeq General Service","4/7/2020"));
        list.add(new History("RPT-1814","Marafeq General Service","4/7/2020"));
        list.add(new History("RPT-1815","Marafeq General Service","4/7/2020"));
        list.add(new History("RPT-1816","Marafeq General Service","4/7/2020"));
        list.add(new History("RPT-1817","Marafeq General Service","4/7/2020"));
        list.add(new History("RPT-1818","Marafeq General Service","4/7/2020"));
        list.add(new History("RPT-1819","Marafeq General Service","4/7/2020"));
        list.add(new History("RPT-1820","Marafeq General Service","4/7/2020"));


        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        adapter=new HistoryAdapter( );
        adapter.setScheduleList(list,this
        );
         recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
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
