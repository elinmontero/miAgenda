package com.example.miagenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    SectionPagerAdapter adapter;

    SQLiteDatabase db;
    BaseDatos baseDatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabs);

        FragmentManager fm = getSupportFragmentManager();
        adapter = new SectionPagerAdapter(fm, getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("INICIO"));
        tabLayout.addTab(tabLayout.newTab().setText("LISTA ACTIVIDADES"));
        tabLayout.addTab(tabLayout.newTab().setText("EDITAR ACTIVIDAD"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
                Toast.makeText(MainActivity.this, "Has pasado a la sección de " + "" +
                        tab.getText(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }

        });

        baseDatos = new BaseDatos(MainActivity.this);
        db = baseDatos.getWritableDatabase();

        if(db != null){

            Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA",
                    Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(MainActivity.this, "ERROR AL CREAR BASE DE DATOS ",
                    Toast.LENGTH_LONG).show();
        }






    }


}