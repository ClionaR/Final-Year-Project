package com.example.cliona.backend;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.TabLayout;
import android.widget.TextView;

public class FosterActivity extends AppCompatActivity {

    private static final String TAG = "FosterActivity";

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_foster);
        Log.d(TAG, "onCreate: Starting.");
        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager)findViewById(R.id.container);
        Log.d("ClionaLog","printing mviewpager");
        Log.d("ClionaLog",mViewPager.toString());


        Log.d("ClionaLog","setting up mviewpager");

        setupViewPager(mViewPager); //HERE >:(
        Log.d("ClionaLog","gettingtablayout");

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        Log.d("ClionaLog","tableayout setupwithviee");

        tabLayout.setupWithViewPager(mViewPager);
        Log.d("ClionaLog","Finished fostering oncreate");

    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new FosterDogFrag(), "Dogs");
        adapter.addFragment(new FosterCatFrag(), "Cats");
        adapter.addFragment(new FosterOtherFrag(), "Other");
        viewPager.setAdapter(adapter);
    }
}
