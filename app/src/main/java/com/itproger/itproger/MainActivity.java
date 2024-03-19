package com.itproger.itproger;

import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn_second;
    TextView main_text;

/*    private TextView resultTextView;
    private EditText number_field_1;
    private EditText number_field_2;
    private Button add_button;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.main_text);
        findViewById(R.id.btn_second);
        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfo(main_text.getText().toString(), btn_second);
                showInfoAlert("Вы хотите закрыть приложение?");
            }
        });
        /* *//*       resultTextView = findViewById(R.id.resultTextView);
        number_field_1 = findViewById(R.id.number_field_1);
        number_field_2 = findViewById(R.id.number_field_2);
        add_button = findViewById(R.id.add_button);*//*

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float num1 = Float.parseFloat(number_field_1.getText().toString());
                float num2 = Float.parseFloat(number_field_2.getText().toString());
                float res = num1 + num2;
                resultTextView.setText(String.valueOf(res));
            }
        });*/

    }

    public void btnClick(View v) {
        showInfo(((Button) v).getText().toString(), ((Button) v));
    }

    private void showInfoAlert(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Большая подсказка")
                .setMessage(text)
                .setCancelable(false)
                .setPositiveButton("Конечно", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showInfo(String text, Button btn) {
        btn.setText("Уже нажали");
        btn.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }


}