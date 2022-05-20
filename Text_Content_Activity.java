package com.example.bsu_entant;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class Text_Content_Activity extends AppCompatActivity {
    Button button;
    TextView textView;

    private ActionBar actionBar;

    // Переменная для работы с БД
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    private SharedPreferences def_pref;

    private Typeface face1;
    private TextView text_content;
    private TextView text_bd;

    private int category = 0;
    private int position = 0;
    private int[] array_mmf = {R.string.mmf_1, R.string.mmf_2, R.string.mmf_3, R.string.mmf_4, R.string.mmf_5, R.string.mmf_6, R.string.mmf_7, R.string.mmf_8,R.string.mmf_9};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        init();
        reciveIntent();

        // Найдем компоненты в XML разметке
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        // Пропишем обработчик клика кнопки
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String product = "";

                Cursor cursor = mDb.rawQuery("SELECT * FROM balls", null);
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    product += cursor.getString(1) + "\n\n";
                    product += cursor.getString(2) + " | " ;
                    product += cursor.getString(3) +"\n"+"______________________________________________________"+ "\n\n\n";
                    cursor.moveToNext();
                }
                cursor.close();

                textView.setText(product);
            }
        });

        mDBHelper = new DatabaseHelper(this);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
    }
    private void reciveIntent(){
        Intent i = getIntent();
        if(i != null) {
            category = i.getIntExtra("category",0);
            position = i.getIntExtra("position",0);
        }
        switch (category) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                break;
            case 7:
                text_content.setText(array_mmf[position]);
        }
        }
        private void init(){
            def_pref = PreferenceManager.getDefaultSharedPreferences(this);
            text_content = findViewById(R.id.text_main_content);
            text_bd = findViewById(R.id.textView);
            face1 = Typeface.createFromAsset(this.getAssets(),"fonts/RobotoSlab-Regular.ttf");
            text_content.setTypeface(face1);

            actionBar = getSupportActionBar();
            assert actionBar != null;
            //actionBar.setDisplayHomeAsUpEnabled(true);

            String text = def_pref.getString("main_text_size", "Средний");
            if (text != null) {
                switch (text) {
                    case "Большой":
                        text_content.setTextSize(24);
                        text_bd.setTextSize(24);
                        break;
                    case "Средний":
                        text_content.setTextSize(18);
                        text_bd.setTextSize(18);
                        break;
                    case "Маленький":
                        text_content.setTextSize(14);
                        text_bd.setTextSize(14);
                        break;

                }
            }
    }
        }



