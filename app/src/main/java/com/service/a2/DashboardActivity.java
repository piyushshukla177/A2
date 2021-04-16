package com.service.a2;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.service.fragment.AccountFragment;
import com.service.fragment.CartFragment;
import com.service.fragment.HomeFragment;
import com.service.fragment.MyOrdersFragment;
import com.service.fragment.WishlistFragment;
import com.util.LocaleHelper;

public class DashboardActivity extends AppCompatActivity {

    BottomNavigationView bottom_navigation;
    Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dashboard);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
        bottom_navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(navListener);
    }

    //bottom menu click events
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {

                        case R.id.nav_dashboard:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_parties:
                            selectedFragment = new CartFragment();
                            break;
                        case R.id.nav_items:
                            selectedFragment = new AccountFragment();
                            break;
                        case R.id.nav_query:
                            selectedFragment = new WishlistFragment();
                            break;
                        case R.id.nav_more:
                            selectedFragment = new MyOrdersFragment();
                            break;
                    }
                    if (selectedFragment != null) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                selectedFragment).commit();
                    }
                    currentFragment = selectedFragment;
                    return true;
                }
            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base));
    }
}