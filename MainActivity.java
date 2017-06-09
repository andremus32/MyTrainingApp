package space.musatov.mytraining.ui;

/**
 * Created by ANDREY MUSATOV on 17.05.2017.
 */


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import space.musatov.mytraining.R;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private TextView workout;
    private TextView journal;
    private TextView myProgress;
    private TextView workout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        onWorkoutClick();
        onJournalClick();
        onMyProgressClick();
        onWorkout2Click();

    }

    @Override
    public void onBackPressed() {
        System.exit(0);
    }

    private void initUI(){
    workout = (TextView) findViewById(R.id.textView1);
    journal = (TextView) findViewById(R.id.textView2);
    myProgress = (TextView) findViewById(R.id.textView3);
    workout2 = (TextView)findViewById(R.id.textView4);
}


private void onWorkoutClick(){
    workout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i(TAG, "Workout field clicked");
            Toast.makeText(MainActivity.this, "Workout clicked", Toast.LENGTH_SHORT).show();
            Intent workoutActivityIntent = new Intent(getApplicationContext(), HisOfpActivity.class);
            startActivity(workoutActivityIntent);
            finish();
        }
    });
}

    private void onWorkout2Click(){
        workout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Workout2 clicked", Toast.LENGTH_SHORT).show();
                Intent workout2ActivityIntent = new Intent(getApplicationContext(), HerSportzalActivity.class);
                startActivity(workout2ActivityIntent);
                finish();
            }
        });
    }

    private void onJournalClick(){
        journal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Journal field clicked");
                Toast.makeText(MainActivity.this, "Journal clicked", Toast.LENGTH_SHORT).show();
                Intent journalActivityIntent = new Intent(getApplicationContext(), JournalActivity.class);
                startActivity(journalActivityIntent);
                finish();
            }
        });
    }

    private void onMyProgressClick(){
        myProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "MyProgress field clicked");
                Toast.makeText(MainActivity.this, "MyProgress clicked", Toast.LENGTH_SHORT).show();
                Intent myProgressActivityIntent = new Intent(getApplicationContext(), MyProgressActivity.class);
                startActivity(myProgressActivityIntent);
                finish();
            }
        });
    }

}
