package it.polarorb.databindingexample;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import it.polarorb.databindingexample.mvvm.list.ListFragment;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mvpButton = (Button) findViewById(R.id.mvp_button);
        Button mvvmButton = (Button) findViewById(R.id.mvvm_button);

        mvpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it.polarorb.databindingexample.mvp.list.ListFragment listFragment = new it.polarorb.databindingexample.mvp.list.ListFragment();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_view, listFragment)
                        .addToBackStack("MVP")
                        .commit();
            }
        });

        mvvmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListFragment listFragment = new ListFragment();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_view, listFragment)
                        .addToBackStack("MVVM")
                        .commit();
            }
        });

        getSupportFragmentManager().addOnBackStackChangedListener(this);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onBackStackChanged() {
        shouldDisplayHomeUp();
    }

    public void shouldDisplayHomeUp(){
        //Enable Up button only  if there are entries in the back stack
        boolean canback = getSupportFragmentManager().getBackStackEntryCount()>0;
        getSupportActionBar().setDisplayHomeAsUpEnabled(canback);
    }

    @Override
    public boolean onSupportNavigateUp() {
        //This method is called when the up button is pressed. Just the pop back stack.
        getSupportFragmentManager().popBackStack();
        return true;
    }
}
