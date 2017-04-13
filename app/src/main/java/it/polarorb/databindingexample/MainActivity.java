package it.polarorb.databindingexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import it.polarorb.databindingexample.mvp.list.MvpListFragment;
import it.polarorb.databindingexample.mvvm.list.MvvmListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mvpButton = (Button) findViewById(R.id.mvp_button);
        Button mvvmButton = (Button) findViewById(R.id.mvvm_button);

        mvpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MvpListFragment mvpListFragment = new MvpListFragment();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_view, mvpListFragment)
                        .commit();
            }
        });

        mvvmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MvvmListFragment mvvmListFragment = new MvvmListFragment();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_view, mvvmListFragment)
                        .commit();
            }
        });
    }


}
