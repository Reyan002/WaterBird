package com.practiceandroid.waterbird.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.practiceandroid.waterbird.Adapters.CustomerReviewAdapter;
import com.practiceandroid.waterbird.Classes.CustomerReview;
import com.practiceandroid.waterbird.R;

import java.util.ArrayList;

public class CustomerReviewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<CustomerReview> list;
    private CustomerReviewAdapter customerReviewAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_review);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Customer Review");
        recyclerView= findViewById(R.id.ratings);
        list=new ArrayList<>();
        list.add(new CustomerReview("Reyan Ahmed","","",""));
        list.add(new CustomerReview("M Rukhshan Sohail","","",""));
        list.add(new CustomerReview("Bilal Ahmed","","",""));
        list.add(new CustomerReview("Umer Nasir","","",""));
        list.add(new CustomerReview("M Aqib","","",""));
        list.add(new CustomerReview("Saqib Niaz","","",""));
        list.add(new CustomerReview("Faizan Ahmed","","",""));
        list.add(new CustomerReview("Ashwan ","","",""));

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        customerReviewAdapter=new CustomerReviewAdapter(list,this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customerReviewAdapter);

    }
}
