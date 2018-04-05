package com.creative.myfragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements ListFragment.OnFragmentInteractionListener {

    ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFragment = new ListFragment();

        // Pass parameters to fragments using bundle
        Bundle bundle = new Bundle();
        bundle.putString("key_link", "http://www.google.com.sg");
        listFragment.setArguments(bundle);

        // Load list fragment
        FragmentManager fm = getFragmentManager();
        // Add
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.listContainer, listFragment);
        ft.commit();
    }

    @Override
    public void onFragmentInteraction(String string) {
        DetailFragment detailFragment = DetailFragment.newInstance("Details", "");

        // Replace list fragment with detail fragment
        FragmentManager fm = getFragmentManager();
        // Replace
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.detailsContainer, detailFragment);
        ft.remove(listFragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
