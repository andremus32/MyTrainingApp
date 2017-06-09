package space.musatov.mytraining.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import space.musatov.mytraining.R;

/**
 * Created by ANDREY MUSATOV on 17.05.2017.
 */

public class HisOfpActivity extends AppCompatActivity{

    private final static String CLICK_INDEX = "clickIndex";

    //===========================================Переменные текстовых полей
    private TextView runKmCountField;
    private TextView pressField;
    private TextView pushupsField;
    private TextView pullupsField;

    //===========================================Переменные кнопок
    private ImageButton runUpButton;
    private ImageButton runDownButton;
    private ImageButton pressUpButton;
    private ImageButton pressDownButton;
    private ImageButton pushupsUpButton;
    private ImageButton pushupsDownButton;
    private ImageButton pullupsUpButton;
    private ImageButton pullupsDownButton;
    private Button saveButton;

    //===========================================Переменные счетчиков упражнений
    private int runKmCount = 0;
    private int pressCount = 0;
    private int pushupsCount = 0;
    private int pullupsCount = 0;

    //===========================================Переменные секундомера
    private int tenthPartOfSecond = 0;
    private int seconds;
    private int minutes;
    private int hours;
    private boolean running ;
    private Button start;
    private Button stop;
    private Button reset;
    private TextView timeView;

    //===============================================================OnCreate
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_his_ofp);

        FragmentManager fm = getSupportFragmentManager();
        FragmentExsercizeActivity fea = new FragmentExsercizeActivity();
        fm.beginTransaction().replace(R.id.container, fea).commit();

        //========================================Подгружаем переменные при перезапуске активности
        if(savedInstanceState != null){
            runKmCount = savedInstanceState.getInt("runKmCount");
            pressCount = savedInstanceState.getInt("pressCount");
            pushupsCount = savedInstanceState.getInt("pushupsCount");
            pullupsCount = savedInstanceState.getInt("pullupsCount");
            tenthPartOfSecond = savedInstanceState.getInt("tenthPartOfSecond");
            seconds = savedInstanceState.getInt("seconds");
            minutes = savedInstanceState.getInt("minutes");
            hours = savedInstanceState.getInt("hours");
            running = savedInstanceState.getBoolean("running");
        }

        //===========================================Привязываем текстовые поля
        runKmCountField = (TextView)findViewById(R.id.run_text_field);
        runKmCountField.setText(Integer.toString(runKmCount));

        pressField = (TextView)findViewById(R.id.press_text_field);
        pressField.setText(Integer.toString(pressCount));

        pushupsField = (TextView)findViewById(R.id.pushups_text_field);
        pushupsField.setText(Integer.toString(pushupsCount));

        pullupsField = (TextView) findViewById(R.id.pullups_text_field);
        pullupsField.setText(Integer.toString(pullupsCount));


        //============================================================Привязываем кнопки
        runUpButton = (ImageButton)findViewById(R.id.run_count_up_button);
        runDownButton = (ImageButton)findViewById(R.id.run_count_down_button);
        pressUpButton = (ImageButton)findViewById(R.id.press_count_up_button);
        pressDownButton = (ImageButton)findViewById(R.id.press_count_down_button);
        pushupsUpButton = (ImageButton)findViewById(R.id.pushups_count_up_button);
        pushupsDownButton = (ImageButton)findViewById(R.id.pushups_count_down_button);
        pullupsUpButton = (ImageButton)findViewById(R.id.pullups_count_up_button);
        pullupsDownButton = (ImageButton)findViewById(R.id.pullupsn_count_down_button);
        saveButton = (Button)findViewById(R.id.workout_save_button);

        //============================================================Привязываем кнопки и поля секундомера
        start = (Button) findViewById(R.id.start_button);
        stop = (Button) findViewById(R.id.stop_button);
        reset = (Button)findViewById(R.id.reset_button);
        timeView = (TextView)findViewById(R.id.timeView);

        //===========================================Запуск методов отзывов на кнопки
        pushRunUpButton();
        pushRunDownButton();
        pushPressUpButton();
        pushPressDownButton();
        pushPushupsUpButton();
        pushPushupsDownButton();
        pushPullupsUpButton();
        pushPullupsDownButton();
        pushSaveButton();

        onStartPush();
        onStopPush();
        onResetPush();

        //================================================================Секундомер
        timerOn();

    }

    public static void startActivity(Context context, int index){
        Intent intent = new Intent(context, HisOfpActivity.class);
        intent.putExtra(CLICK_INDEX, index);
        context.startActivity(intent);
    }


    //===================================================================Методы откликов на кнопки
    private void pushRunUpButton(){
        runUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runKmCount++;
                runKmCountField.setText(Integer.toString(runKmCount));
            }
        });
    }

    private void pushRunDownButton(){
        runDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (runKmCount < 1){
                    Toast.makeText(HisOfpActivity.this, "Меньше нуля никак нельзя ;)", Toast.LENGTH_SHORT).show();
                }
                else {
                    runKmCount--;
                    runKmCountField.setText(Integer.toString(runKmCount));
                }
            }
        });
    }

    private void pushPressUpButton(){
        pressUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressCount++;
                pressField.setText(Integer.toString(pressCount));

            }
        });
    }

    private void pushPressDownButton(){
        pressDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pressCount < 1){
                    Toast.makeText(HisOfpActivity.this, "Меньше нуля никак нельзя ;)", Toast.LENGTH_SHORT).show();
                }
                else {
                    pressCount--;
                    pressField.setText(Integer.toString(pressCount));
                }
            }
        });
    }

    private void pushPushupsUpButton(){
        pushupsUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pushupsCount++;
                pushupsField.setText(Integer.toString(pushupsCount));
            }
        });
    }

    private void pushPushupsDownButton(){
        pushupsDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pushupsCount < 1){
                    Toast.makeText(HisOfpActivity.this, "Меньше нуля никак нельзя ;)", Toast.LENGTH_SHORT).show();
                }
                else {
                    pushupsCount--;
                    pushupsField.setText(Integer.toString(pushupsCount));
                }
            }
        });
    }

    private void pushPullupsUpButton(){
        pullupsUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pullupsCount++;
                pullupsField.setText(Integer.toString(pullupsCount));
            }
        });
    }

    private void pushPullupsDownButton(){
        pullupsDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pullupsCount < 1){
                    Toast.makeText(HisOfpActivity.this, "Меньше нуля никак нельзя ;)", Toast.LENGTH_SHORT).show();
                }
                else {
                    pullupsCount--;
                    pullupsField.setText(Integer.toString(pullupsCount));
                }
            }
        });
    }

    //============================================================Методы кнопок секундомера

    private void onStartPush(){
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = true;
            }
        });
    }

    private void onStopPush(){
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = false;
            }
        });
    }

    private void onResetPush(){
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tenthPartOfSecond = 0;
                seconds = 0;
                minutes = 0;
                hours = 0;
            }
        });
    }

    //=============================================================Секундомер
    private void timerOn(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                seconds = tenthPartOfSecond/10;
                if (seconds > 59) {
                    minutes++;
                    tenthPartOfSecond = 0;
                }
                if (minutes > 59){
                    minutes = 0;
                    hours++;
                }
                if(hours > 23){
                    tenthPartOfSecond = 0;
                    minutes = 0;
                    hours = 0;
                }

                String time = String.format("%02d:%02d:%02d:%d", hours, minutes, seconds, (tenthPartOfSecond%10));
                timeView.setText(time);
                if (running){
                    tenthPartOfSecond++;
                }
                handler.postDelayed(this, 100);
            }
        });
    }

    //=====================================================Сохранение данных в файле настроек
    private void pushSaveButton(){
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPrefPre = HisOfpActivity.this.getSharedPreferences(getString(R.string.MyTraining), Context.MODE_PRIVATE);
                runKmCount += sharedPrefPre.getInt(getString(R.string.Run_for_save), 0);
                pressCount += sharedPrefPre.getInt(getString(R.string.Press_for_save), 0);
                pushupsCount += sharedPrefPre.getInt(getString(R.string.Pushups_for_save), 0);
                pullupsCount += sharedPrefPre.getInt(getString(R.string.Pullups_for_save), 0);

                SharedPreferences sharedPrefPost = HisOfpActivity.this.getSharedPreferences(getString(R.string.MyTraining), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPrefPost.edit();
                editor.putInt(getString(R.string.Run_for_save), runKmCount);
                editor.putInt(getString(R.string.Press_for_save), pressCount);
                editor.putInt(getString(R.string.Pushups_for_save), pushupsCount);
                editor.putInt(getString(R.string.Pullups_for_save), pullupsCount);
                editor.commit();

                //================================================Метод создания интента и передачи данных в Журнал
                JournalActivity.startActivity(HisOfpActivity.this, runKmCount, pressCount, pushupsCount, pullupsCount);

                finish();
            }
        });

    }

    //============================================================Сохранение состояния активности
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("runKmCount", runKmCount);
        outState.putInt("pressCount", pressCount);
        outState.putInt("pushupsCount", pushupsCount);
        outState.putInt("pullupsCount", pullupsCount);

        outState.putInt("tenthPartOfSecond", tenthPartOfSecond);
        outState.putInt("seconds", seconds);
        outState.putInt("minutes", minutes);
        outState.putInt("hours", hours);
        outState.putBoolean("running", running);
        super.onSaveInstanceState(outState);
        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
