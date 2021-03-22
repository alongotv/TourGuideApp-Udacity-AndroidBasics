package com.alongo.tourguideapp;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(R.drawable.mainscreen, R.string.name_mainscreen, R.string.desc_mainscreen, R.string.web_mainscreen));
        CardAdapter cardAdapter = new CardAdapter(this, cards);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(cardAdapter);
        navigationView.getMenu().getItem(0).setChecked(true);

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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case (R.id.nav_home): {
                this.recreate();
                break;
            }
            case (R.id.nav_restaurant): {
                ArrayList<Card> cardsRestaurant = new ArrayList<>();
                cardsRestaurant.add(new Card(R.drawable.bellevue, R.string.name_bellevue, R.string.desc_bellevue, R.string.web_bellevue));
                cardsRestaurant.add(new Card(R.drawable.danslenoir, R.string.name_danslenoir, R.string.desc_danslenoir, R.string.web_danslenoir));
                cardsRestaurant.add(new Card(R.drawable.sintoho, R.string.name_sintoho, R.string.desc_sintoho, R.string.web_sintoho));
                cardsRestaurant.add(new Card(R.drawable.percorso, R.string.name_percorso, R.string.desc_percorso, R.string.web_percorso));
                CardAdapter cardAdapter = new CardAdapter(this, cardsRestaurant);
                ListView listView = findViewById(R.id.list_view);
                listView.setAdapter(cardAdapter);
                break;

            }
            case (R.id.nav_museum): {
                ArrayList<Card> cardsMuseum = new ArrayList<>();
                cardsMuseum.add(new Card(R.drawable.hermitage, R.string.name_hermitage, R.string.desc_hermitage, R.string.web_hermitage));
                cardsMuseum.add(new Card(R.drawable.russianmuseum, R.string.name_russianmuseum, R.string.desc_russianmuseum, R.string.web_russianmuseum));
                cardsMuseum.add(new Card(R.drawable.peterhof, R.string.name_peterhof, R.string.desc_peterhof, R.string.web_peterhof));
                cardsMuseum.add(new Card(R.drawable.stisaac, R.string.name_stisaac, R.string.desc_stisaac, R.string.web_stisaac));
                CardAdapter cardAdapter = new CardAdapter(this, cardsMuseum);
                ListView listView = findViewById(R.id.list_view);
                listView.setAdapter(cardAdapter);
                break;
            }
            case (R.id.nav_theatre): {
                ArrayList<Card> cardsTheatre = new ArrayList<>();
                cardsTheatre.add(new Card(R.drawable.mariinsky, R.string.name_mariinsky, R.string.desc_mariinsky, R.string.web_mariinsky));
                cardsTheatre.add(new Card(R.drawable.alexandrinsky,  R.string.name_alexandrinsky, R.string.desc_alexandrinsky, R.string.web_alexandrinsky));
                cardsTheatre.add(new Card(R.drawable.mikhailovsky, R.string.name_mikhailovsky, R.string.desc_mikhaylovskiy, R.string.web_mikhaylovskiy));
                CardAdapter cardAdapter = new CardAdapter(this, cardsTheatre);
                ListView listView = findViewById(R.id.list_view);
                listView.setAdapter(cardAdapter);
                break;
            }
            case (R.id.nav_site): {
                ArrayList<Card> cardsSite = new ArrayList<>();
                cardsSite.add(new Card(R.drawable.alexcolumn, R.string.name_alexcolumn, R.string.desc_alexcolumn));
                cardsSite.add(new Card(R.drawable.peterandpaul, R.string.name_peterandpaul, R.string.desc_peterandpaul));
                cardsSite.add(new Card(R.drawable.bronzeman, R.string.name_bronzeman, R.string.desc_bronzeman));
                cardsSite.add(new Card(R.drawable.rostralcolumns, R.string.name_rostralcolumns, R.string.desc_rostralcolumns));
                cardsSite.add(new Card(R.drawable.palacebridge, R.string.name_palacebridge, R.string.desc_palacebridge));
                CardAdapter cardAdapter = new CardAdapter(this, cardsSite);
                ListView listView = findViewById(R.id.list_view);
                listView.setAdapter(cardAdapter);
                break;
            }
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }

}
