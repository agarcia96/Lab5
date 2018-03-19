package com.example.angelicagarcia16.actionbarexperiment;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final String TAB_KEY_INDEX = "tab_key";
    private Fragment breakfastFragment;
    private Fragment lunchFragment;
    private Fragment dinnerFragment;
    private Fragment snackFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SET ACTIONBAR
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        //CREATE THE TABS AND BIND THEM TO ACTIONBAR
        ActionBar.Tab breakfastTab = actionBar.newTab().setText(getString(R.string.ui_tabname_breakfast));
        ActionBar.Tab lunchTab = actionBar.newTab().setText(getString(R.string.ui_tabname_lunch));
        ActionBar.Tab dinnerTab = actionBar.newTab().setText(getString(R.string.ui_tabname_dinner));
        ActionBar.Tab snackTab = actionBar.newTab().setText(getString(R.string.ui_tabname_snack));

        //CREATE EACH FRAGMENT AND BIND THEM TO THE ACTIONBAR
        breakfastFragment = new BreakfastFragment();
        snackFragment = new SnackFragment();
        lunchFragment = new LunchFragment();
        dinnerFragment = new DinnerFragment();

        //SET LISTENER EVENTS FOR EACH OF THE ACTIONBAR TABS
        breakfastTab.setTabListener(new MyTabsListener(breakfastFragment, getApplicationContext()));
        lunchTab.setTabListener(new MyTabsListener(lunchFragment, getApplicationContext()));
        dinnerTab.setTabListener(new MyTabsListener(dinnerFragment, getApplicationContext()));
        snackTab.setTabListener(new MyTabsListener(snackFragment, getApplicationContext()));

        //ADD EACH OF THESE ITEMS TO THE ACTIONBAR
        actionBar.addTab(breakfastTab);
        actionBar.addTab(lunchTab);
        actionBar.addTab(dinnerTab);
        actionBar.addTab(snackTab);

        //RESTORE NAVIGATION
        if (savedInstanceState != null) {
            actionBar.setSelectedNavigationItem(savedInstanceState.getInt(TAB_KEY_INDEX, 0));
        }
    }

    class MyTabsListener implements ActionBar.TabListener {
        public Fragment fragment;

        public MyTabsListener(Fragment f, Context context) {
            fragment = f;
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {}

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.replace(R.id.fragment_container, fragment);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.remove(fragment);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle action bar item clicks here. The action bar will automatically
        //  handle clicks on the Home/Up button, so long as you specify a parent
        //  activity in AndroidManifest.xml
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
