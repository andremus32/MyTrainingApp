package space.musatov.mytraining.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import space.musatov.mytraining.R;

/**
 * Created by ANDREY MUSATOV on 17.05.2017.
 */

public class JournalActivity extends AppCompatActivity {

    //===========================================Переменные текстовых полей
    private TextView runKmCountField;
    private TextView pressField;
    private TextView pushupsField;
    private TextView pullupsField;
    private ImageButton backToMainMenu;
    private Button resetJournal;

    //===========================================Переменные счетчиков упражнений
    private int runKmCount;
    private int pressCount;
    private int pushupsCount;
    private int pullupsCount;

    //===========================================Стринговые константы ключей для Интента
    private static final String RUN_COUNTER = "RunCounter";
    private static final String PRESS_COUNTER = "PressCounter";
    private static final String PUSHUPS_COUNTER = "PushupsCounter";
    private static final String PULLUPS_COUNTER = "PullupsCounter";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        //=================================================Получаем значения переменных из интента
        /*
        runKmCount = getIntent().getIntExtra(RUN_COUNTER, 0);
        pressCount = getIntent().getIntExtra(PRESS_COUNTER, 0);
        pushupsCount = getIntent().getIntExtra(PUSHUPS_COUNTER, 0);
        pullupsCount = getIntent().getIntExtra(PULLUPS_COUNTER, 0);
        */

        //====================================Подгрузка сохраненных переменных при перезапуске активности
        SharedPreferences sharedPref = JournalActivity.this.getSharedPreferences(getString(R.string.MyTraining), Context.MODE_PRIVATE);
        runKmCount = sharedPref.getInt(getString(R.string.Run_for_save), 0);
        pressCount = sharedPref.getInt(getString(R.string.Press_for_save), 0);
        pushupsCount = sharedPref.getInt(getString(R.string.Pushups_for_save), 0);
        pullupsCount = sharedPref.getInt(getString(R.string.Pullups_for_save), 0);



        //==========================================================Подгрузка данных при перезапуске активности
        if(savedInstanceState != null){
            runKmCount = savedInstanceState.getInt("runKmCount");
            pressCount = savedInstanceState.getInt("pressCount");
            pushupsCount = savedInstanceState.getInt("pushupsCount");
            pullupsCount = savedInstanceState.getInt("pullupsCount");
        }

        //============================Привязываем текстовые поля и отображаем значения переменных
        runKmCountField = (TextView)findViewById(R.id.journal_run_text_field);
        runKmCountField.setText(Integer.toString(runKmCount));

        pressField = (TextView)findViewById(R.id.journal_press_text_field);
        pressField.setText(Integer.toString(pressCount));

        pushupsField = (TextView)findViewById(R.id.journal_pushups_text_field);
        pushupsField.setText(Integer.toString(pushupsCount));

        pullupsField = (TextView)findViewById(R.id.journal_pullups_text_field);
        pullupsField.setText(Integer.toString(pullupsCount));

        //=======================================================Привязываем кнопку возврата в меню и запускаем ее метод
        backToMainMenu = (ImageButton)findViewById(R.id.back_to_main_menu_button);
        backtoMenuButton();

        resetJournal = (Button) findViewById(R.id.reset_journal);
        resetJournal();
    }

    //=============================================Метод StartActivity()
    public static void startActivity(Context context, int runKm, int press, int pushups, int pullups){
        Intent intent = new Intent(context, JournalActivity.class);
        intent.putExtra(RUN_COUNTER, runKm);
        intent.putExtra(PRESS_COUNTER, press);
        intent.putExtra(PUSHUPS_COUNTER, pushups);
        intent.putExtra(PULLUPS_COUNTER, pullups);
        context.startActivity(intent);
    }

    //================================================Метод отзыва на кнопку - Возврат в главное меню
    private void backtoMenuButton(){
        backToMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(JournalActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    //================================================Метод отзыва на кнопку Сброс журнала
    private void resetJournal(){
        resetJournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runKmCount = 0;
                pressCount = 0;
                pushupsCount = 0;
                pullupsCount = 0;
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
        super.onSaveInstanceState(outState);
    }

}
