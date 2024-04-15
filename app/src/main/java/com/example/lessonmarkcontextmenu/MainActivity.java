package com.example.lessonmarkcontextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbarMainTB;
    TextView textTV;
    EditText markET;

    TextView randomTV;
    Button randomBTN;

    String appTitle = "Lesson mark color changer";
    String appSubTitle = "Task 6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        registerForContextMenu(markET);

        randomBTN.setOnClickListener(this);
    }

    @Override
    public void onCreateContextMenu(
            ContextMenu menu,
            View v,
            ContextMenu.ContextMenuInfo menuInfo
    ) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item_color_quality) {
            changeBackgroundColor(markET.getText().toString(), markET);
            Toast.makeText(this, "Color's changed", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.item_exit) {
            finish();
            Toast.makeText(this, "App closed", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int value = (int) (Math.random() * 50);
        String choice = String.valueOf((value - 1) / 10);
        changeBackgroundColor(choice, randomTV);
        randomTV.setText(String.valueOf(value));
    }

    private static void changeBackgroundColor(String value, View view) {
        switch (value) {
            case "0":
                view.setBackgroundColor(0xFFEA7004);
                break;
            case "1":
                view.setBackgroundColor(0xFFF3E600);
                break;
            case "2":
                view.setBackgroundColor(0xFF1DC500);
                break;
            case "3":
                view.setBackgroundColor(0xFF002BFF);
                break;
            case "4":
                view.setBackgroundColor(Color.RED);
                break;
            default:
                view.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    private void initUI() {
        toolbarMainTB = findViewById(R.id.toolbarMainTB);
        textTV = findViewById(R.id.textTV);
        markET = findViewById(R.id.markET);
        randomTV = findViewById(R.id.randomTV);
        randomBTN = findViewById(R.id.randomBTN);

        setSupportActionBar(toolbarMainTB);
        getSupportActionBar().setTitle(appTitle);
        getSupportActionBar().setSubtitle(appSubTitle);
        toolbarMainTB.setTitleTextColor(0xFFFFFFFF);
        toolbarMainTB.setSubtitleTextColor(0xFFFFFFFF);
    }
}