package com.noringerazancutyun.retrofit_new_example.UI;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.noringerazancutyun.retrofit_new_example.Adapter.MyRecyclerView;
import com.noringerazancutyun.retrofit_new_example.Model.Model;
import com.noringerazancutyun.retrofit_new_example.Model.UsersViewModel;
import com.noringerazancutyun.retrofit_new_example.R;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyRecyclerView adapter;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        textView =findViewById(R.id.text);

        UsersViewModel viewModel = ViewModelProviders.of(this).get(UsersViewModel.class);

        viewModel.getData().observe(this, new Observer<List<Model>>() {
            @Override
            public void onChanged(@Nullable List<Model> modelList) {
                adapter = new MyRecyclerView(MainActivity.this, modelList);
                textView.setText(modelList.get(1).getBody());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
    }
}

