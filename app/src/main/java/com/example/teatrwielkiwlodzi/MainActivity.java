package com.example.teatrwielkiwlodzi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mlayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mlayout = (DrawerLayout) findViewById(R.id.main_activity);
        navigationView = (NavigationView)findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle mtoggle = new ActionBarDrawerToggle(this,mlayout,toolbar,R.string.open,R.string.close);
        mtoggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.MainWhite));
        mlayout.addDrawerListener(mtoggle);
        mtoggle.syncState();


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,
                    new glowna_fragment()).commit();
            navigationView.setCheckedItem(R.id.glowna);
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Menu menuTemp = navigationView.getMenu();

        switch (menuItem.getItemId()) {

            case R.id.glowna:

                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new glowna_fragment()).commit();
                break;

            case R.id.bilety:

                menuTemp.findItem(R.id.sprzedaz).setVisible(!menuTemp.findItem(R.id.sprzedaz).isVisible());
                menuTemp.findItem(R.id.cennik).setVisible(!menuTemp.findItem(R.id.cennik).isVisible());
                return true;


            case R.id.sprzedaz:

                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new sprzedaz_fragment()).commit();
                break;


            case R.id.cennik:

                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new cennik_fragment()).commit();
                break;


            case R.id.repertuar:

                menuTemp.findItem(R.id.kalendarium).setVisible(!menuTemp.findItem(R.id.kalendarium).isVisible());
                menuTemp.findItem(R.id.spektakle).setVisible(!menuTemp.findItem(R.id.spektakle).isVisible());
                return true;


            case R.id.kalendarium:

                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new kalendarium_fragment()).commit();
                break;


            case R.id.spektakle:

                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new spektakle_fragment()).commit();
                break;


            case R.id.o_teatrze:

                menuTemp.findItem(R.id.galeria_plakatu).setVisible(!menuTemp.findItem(R.id.galeria_plakatu).isVisible());
                menuTemp.findItem(R.id.zespoly).setVisible(!menuTemp.findItem(R.id.zespoly).isVisible());
                return true;


            case R.id.galeria_plakatu:

                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new galeria_fragment()).commit();
                break;


            case R.id.zespoly:

                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new zespoly_fragment()).commit();
                break;

            case R.id.kontakt:

                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new MapsActivity()).commit();
                break;

        }
        mlayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed(){

        if(mlayout.isDrawerOpen(GravityCompat.START)){

            mlayout.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }
    }
}