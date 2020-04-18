package com.dan.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected {

    TextView tvDess;
    TextView ohBoy;
    ArrayList<String> descc;
    ArrayList<String> desBoy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDess = findViewById(R.id.tvDess);
        ohBoy = findViewById(R.id.ohBoy);


        descc = new ArrayList<String>();
        descc.add("Danish Shaikh");


        desBoy = new ArrayList<String>();
        desBoy.add("okay adding some xyz about me, okay? :P");




        if(findViewById(R.id.layout_portrait) != null){
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }

        if(findViewById(R.id.layout_land) != null){
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }


    }

    @Override
    public void onItemSelected(int index) {

        tvDess.setText(descc.get(index));
        ohBoy.setText(desBoy.get(index));

        if(findViewById(R.id.layout_portrait) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .addToBackStack(null)
                    .commit();
        }

    }
}
