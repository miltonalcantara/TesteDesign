package com.cargox.teste;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cargox.teste.fragment.ColetasFragment;
import com.cargox.teste.fragment.ComoUsarFragment;
import com.cargox.teste.fragment.DadosContaFragment;
import com.cargox.teste.utils.Utils;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;
    public TextView mTitle;
    public FloatingActionButton fab;
    private boolean primeiraVez = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        mTitle = toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Utils(MainActivity.this).showDialogContato();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_prox_coletas) {
            ColetasFragment coletasFragment = new ColetasFragment();
            atualizarFragment(getString(R.string.menu_coletas), coletasFragment);
        } else if (id == R.id.nav_dados_conta) {
            DadosContaFragment dadosContaFragment = new DadosContaFragment();
            atualizarFragment(getString(R.string.menu_dados), dadosContaFragment);
        } else if (id == R.id.nav_como_usar) {
            ComoUsarFragment comoUsarFragment = new ComoUsarFragment();
            atualizarFragment(getString(R.string.menu_como_usar), comoUsarFragment);
        } else if (id == R.id.nav_ligar_carbox) {
            Toast.makeText(getApplicationContext(), "Ligar CargoX", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_chat) {
            Toast.makeText(getApplicationContext(), R.string.texto_chat, Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_termos) {
            Toast.makeText(getApplicationContext(), R.string.menu_termos, Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_privacidade) {
            Toast.makeText(getApplicationContext(), R.string.menu_privacidade, Toast.LENGTH_SHORT).show();
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void atualizarFragment(String titulo, Fragment fragment) {
        mTitle.setText(titulo);
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }

    /**
     * Para o app começar já na tela Principal e com o menu selecionado
     */
    @Override
    protected void onResume() {
        super.onResume();

        if (primeiraVez) {
            navigationView = findViewById(R.id.nav_view);
            Menu menu = navigationView.getMenu();
            menu.getItem(0).setChecked(true);
            ColetasFragment fragment = new ColetasFragment();
            atualizarFragment(getString(R.string.menu_coletas), fragment);
            primeiraVez = false;
        }
    }
}
