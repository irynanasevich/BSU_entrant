package com.example.bsu_entant;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.bsu_entant.databinding.ActivityMainBinding;
import com.example.bsu_entant.settings.SettingsActivity;
import com.example.bsu_entant.todo.ToDo_activity;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ListView list;
    private String[] array;
    private ArrayAdapter<String> adapter;
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private int category_index;

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        com.example.bsu_entant.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(((ActivityMainBinding) binding).getRoot());
        
        drawer = binding.drawerLayout;

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
               this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = binding.navView;
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // получаем элемент ListView
        list = findViewById(R.id.listView);
        array = getResources().getStringArray(R.array.bio_array);
        // создаем адаптер
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,new ArrayList<>(Arrays.asList(array)));
        // устанавливаем для списка адаптер
        list.setAdapter(adapter);

        setTitle(R.string.menu_bio);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(MainActivity.this,Text_Content_Activity.class);
                intent.putExtra("category", category_index);
                intent.putExtra("position", position);
                startActivity(intent);

            }
        });

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (item.getItemId())
        {

            case R.id.action_settings:
                Intent i = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(i);
                return true;
            case R.id.menu_navig:
                Intent intent = new Intent(MainActivity.this, ToDo_activity.class);
                startActivity(intent);
                return true;
                
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_bio) {
            setTitle(R.string.menu_bio);
            array = getResources().getStringArray(R.array.bio_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=0;
        } else if (id == R.id.nav_vf) {
            setTitle(R.string.menu_vf);
            array = getResources().getStringArray(R.array.vf_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=1;
        }
        else if (id == R.id.nav_soc) {
            setTitle(R.string.menu_soc);
            array = getResources().getStringArray(R.array.soc_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=2;
        }
        else if (id == R.id.nav_geo) {
            setTitle(R.string.menu_geo);
            array = getResources().getStringArray(R.array.geo_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=3;
        }
        else if (id == R.id.nav_his) {
            setTitle(R.string.menu_his);
            array = getResources().getStringArray(R.array.his_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=4;
        }
        else if (id == R.id.nav_zhur) {
            setTitle(R.string.menu_zhur);
            array = getResources().getStringArray(R.array.zhur_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=5;
        }else if (id == R.id.nav_fir) {
            setTitle(R.string.menu_fir);
            array = getResources().getStringArray(R.array.fir_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=6;
        } else if (id == R.id.nav_mmf) {
            setTitle(R.string.menu_mmf);
            array = getResources().getStringArray(R.array.mmf_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=7;
        } else if (id == R.id.nav_fpmi) {
            setTitle(R.string.menu_fpmi);
            array = getResources().getStringArray(R.array.fpmi_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=8;
        }else if (id == R.id.nav_fis) {
            setTitle(R.string.menu_fis);
            array = getResources().getStringArray(R.array.fis_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=9;
        }else if (id == R.id.nav_phil) {
            setTitle(R.string.menu_phil);
            array = getResources().getStringArray(R.array.phil_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=10;
        }else if (id == R.id.nav_fil) {
            setTitle(R.string.menu_fil);
            array = getResources().getStringArray(R.array.fil_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=11;
        }else if (id == R.id.nav_rad) {
            setTitle(R.string.menu_rad);
            array = getResources().getStringArray(R.array.rad_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=12;
        }else if (id == R.id.nav_him) {
            setTitle(R.string.menu_him);
            array = getResources().getStringArray(R.array.him_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=13;
        }else if (id == R.id.nav_econom) {
            setTitle(R.string.menu_econom);
            array = getResources().getStringArray(R.array.econ_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=14;
        }else if (id == R.id.nav_yur) {
            setTitle(R.string.menu_yur);
            array = getResources().getStringArray(R.array.yur_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=15;
        }else if (id == R.id.nav_bis) {
            setTitle(R.string.menu_bis);
            array = getResources().getStringArray(R.array.bis_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=16;
        }else if (id == R.id.nav_teo) {
            setTitle(R.string.menu_teo);
            array = getResources().getStringArray(R.array.teo_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=17;
        }else if (id == R.id.nav_ecol) {
            setTitle(R.string.menu_ecol);
            array = getResources().getStringArray(R.array.ecol_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            category_index=18;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}