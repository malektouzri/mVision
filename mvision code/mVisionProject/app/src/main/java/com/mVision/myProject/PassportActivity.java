package com.mVision.myProject;

import android.app.Activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mVision.myProject.Adapters.PassportAdapter;
import com.mVision.myProject.Entities.Info;
import com.mVision.myProject.Entities.Passport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PassportActivity extends Activity {
    private List<Passport> passports = new ArrayList<>();

    private RecyclerView recyclerView;
    private PassportAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Passport a = new Passport(1,"https://upload.wikimedia.org/wikipedia/commons/9/91/Passeport_Tunisie_2014.jpg",
                new Info("Oussama","Berrazaga","",""),new Date());

        passports.add(a);
        passports.add(a);
        passports.add(a);
        if(getIntent().getStringExtra("info")!=null){
            Passport b = new Passport(2,"https://upload.wikimedia.org/wikipedia/commons/9/91/Passeport_Tunisie_2014.jpg",
                    new Info("hi","hi","hi","hi"),new Date());
            passports.add(b);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passport);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new PassportAdapter(passports, PassportActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(PassportActivity.this, 1);
        mLayoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
}
