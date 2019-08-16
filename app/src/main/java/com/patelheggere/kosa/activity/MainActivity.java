package com.patelheggere.kosa.activity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.patelheggere.kosa.R;
import com.patelheggere.kosa.base.BaseActivity;
import com.patelheggere.kosa.helper.SharedPrefsHelper;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static com.patelheggere.kosa.helper.AppUtils.Constants.EMAIL;
import static com.patelheggere.kosa.helper.AppUtils.Constants.MOBILE;
import static com.patelheggere.kosa.helper.AppUtils.Constants.NAME;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    private TextView mTextMessage;

    @Override
    protected int getContentView() {
        return R.layout.activity_main_2;
    }

    @Override
    protected void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);

       /* TextView name = (TextView) header.findViewById(R.id.tv_name);
        TextView email = (TextView) header.findViewById(R.id.tv_email);
        if (SharedPrefsHelper.getInstance().get(NAME, null) != null) {
            name.setText(SharedPrefsHelper.getInstance().get(NAME).toString());
        }
        if (SharedPrefsHelper.getInstance().get(EMAIL, null) != null) {
            email.setText(SharedPrefsHelper.getInstance().get(EMAIL).toString());
        } else if (SharedPrefsHelper.getInstance().get(EMAIL, null) == null) {
            email.setText(SharedPrefsHelper.getInstance().get(MOBILE).toString());
        }*/
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);
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
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected( MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_in_right);
            Fragment curFrag = fragmentManager.getPrimaryNavigationFragment();
            switch (item.getItemId())
            {
                /*case R.id.navigation_home:

                    Log.d(TAG, "onNavigationItemSelected: ");
                    if (curFrag != null) {
                        fragmentTransaction.detach(curFrag);
                    }
                    Fragment fragment = fragmentManager.findFragmentByTag("ABOUT");
                    if (fragment == null) {
                        fragment = new AboutFragment();
                        fragmentTransaction.add(R.id.contentFrame, fragment, "ABOUT");
                    } else {
                        fragmentTransaction.attach(fragment);
                    }
                    fragmentTransaction.setPrimaryNavigationFragment(fragment);
                    fragmentTransaction.setReorderingAllowed(true);
                    fragmentTransaction.commitNowAllowingStateLoss();

                    return true;

                case R.id.navigation_dashboard:
                    if (curFrag != null) {
                        fragmentTransaction.detach(curFrag);
                    }
                    fragment = fragmentManager.findFragmentByTag("CURRENT");
                    if (fragment == null) {
                        fragment = new CurrentAffairsFragment();
                        fragmentTransaction.add(R.id.contentFrame, fragment, "CURRENT");
                    } else {
                        fragmentTransaction.attach(fragment);
                    }
                    fragmentTransaction.setPrimaryNavigationFragment(fragment);
                    fragmentTransaction.setReorderingAllowed(true);
                    fragmentTransaction.commitNowAllowingStateLoss();
                    // mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    if (curFrag != null) {
                        fragmentTransaction.detach(curFrag);
                    }
                    fragment = fragmentManager.findFragmentByTag("JOB");
                    if (fragment == null) {
                        fragment = new JobUpdatesFragment();
                        fragmentTransaction.add(R.id.contentFrame, fragment, "JOB");
                    } else {
                        fragmentTransaction.attach(fragment);
                    }
                    fragmentTransaction.setPrimaryNavigationFragment(fragment);
                    fragmentTransaction.setReorderingAllowed(true);
                    fragmentTransaction.commitNowAllowingStateLoss();
                    //mTextMessage.setText(R.string.title_notifications);
                    return true;*/

            }
            return false;
        }
    };

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        return false;
    }
}
