package com.itproger.itproger;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity5 extends AppCompatActivity {
    private Button btn_fragment1;
    private Button btn_fragment2;
    private FrameLayout frameLayout;
    private FirstFragment firstFragment = new FirstFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_fragment1 = findViewById(R.id.btn_fragment1);
        btn_fragment1 = findViewById(R.id.btn_fragment2);
        frameLayout = findViewById(R.id.frame_layout);


        setNewFragment(firstFragment);

        btn_fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNewFragment(firstFragment);
            }
        });
        btn_fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment secondFragment = new SecondFragment();
                setNewFragment(secondFragment);
            }
        });

    }

    private void setNewFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, firstFragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}