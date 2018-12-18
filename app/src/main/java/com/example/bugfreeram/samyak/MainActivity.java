package com.example.bugfreeram.samyak;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.bugfreeram.samyak.Activity.AddPost;
import com.example.bugfreeram.samyak.Custom.IconTextView;
import com.example.bugfreeram.samyak.Fragments.GroupFragment;
import com.example.bugfreeram.samyak.Fragments.HomeFragment;
import com.example.bugfreeram.samyak.Fragments.ProfileFragment;
import com.example.bugfreeram.samyak.Fragments.QRScannerFragment;
import com.example.bugfreeram.samyak.Fragments.Transaction_History;

public class MainActivity extends AppCompatActivity {
    private static final String SELECTED_ITEM = "arg_selected_item";
    FloatingActionButton fab;
    IconTextView search_view;
    FrameLayout frmLytNotification;
    IconTextView itv_menu;
    private BottomNavigationView mBottomNav;
    private int mSelectedItem;
    private Context mCtx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spannable expired = new SpannableString(" expired");
        expired.setSpan(new ForegroundColorSpan(Color.RED), 0, expired.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        expired.setSpan(new RelativeSizeSpan(.5f), 0, expired.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
/*
        nameTextView.setText(goalsName + expired);
*/

        itv_menu = (IconTextView) findViewById(R.id.itv_menu);
        itv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Working", Toast.LENGTH_SHORT).show();
            }
        });
        frmLytNotification = (FrameLayout) findViewById(R.id.frmLytNotification);
        frmLytNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Under Working ", Toast.LENGTH_SHORT).show();
            }
        });
        search_view = (IconTextView) findViewById(R.id.search_view);
        search_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Under Working ", Toast.LENGTH_SHORT).show();
            }
        });
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFab = new Intent(MainActivity.this, AddPost.class);
                startActivity(intentFab);
            }
        });

        mBottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectFragment(item);
                return true;
            }
        });
        MenuItem selectedItem;
        if (savedInstanceState != null) {
            mSelectedItem = savedInstanceState.getInt(SELECTED_ITEM, 0);
            selectedItem = mBottomNav.getMenu().findItem(mSelectedItem);
        } else {
            selectedItem = mBottomNav.getMenu().getItem(0);
        }
        selectFragment(selectedItem);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SELECTED_ITEM, mSelectedItem);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        MenuItem homeItem = mBottomNav.getMenu().getItem(0);
        if (mSelectedItem != homeItem.getItemId()) {
            selectFragment(homeItem);
        } else {
            super.onBackPressed();
        }
    }
    private void selectFragment(MenuItem item) {
        Fragment selectedFragment = null;
        switch (item.getItemId()) {
            case R.id.menu_home:
                selectedFragment = new HomeFragment();

                break;
            case R.id.menu_group:
                selectedFragment = new GroupFragment();
                break;
            case R.id.menu_history:

                selectedFragment = new Transaction_History();
                break;
            case R.id.menu_profile:
                selectedFragment = new ProfileFragment();
                break;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.detach(selectedFragment);
        transaction.attach(selectedFragment);

        transaction.replace(R.id.container, selectedFragment);
        transaction.commit();
        mSelectedItem = item.getItemId();
        for (int i = 0; i < mBottomNav.getMenu().size(); i++) {
            MenuItem menuItem = mBottomNav.getMenu().getItem(0).setChecked(true);
            menuItem.setChecked(menuItem.getItemId() == item.getItemId());
        }
        updateToolbarText(item.getTitle());
    }

    private void updateToolbarText(CharSequence text) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(text);
        }
    }

    private int getColorFromRes(@ColorRes int resId) {
        return ContextCompat.getColor(this, resId);
    }
}
