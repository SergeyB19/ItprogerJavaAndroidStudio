package com.itproger.itproger;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {

    private ImageButton car_image, police_image;
    private MediaPlayer carSound, policeSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        car_image = findViewById(R.id.car_image);
        police_image = findViewById(R.id.police_image);

        carSound = MediaPlayer.create(this, R.raw.engine);
        policeSound = MediaPlayer.create(this, R.raw.police);

        car_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayButton(carSound, policeSound);
            }
        });

        police_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPlayButton(policeSound, carSound);
            }
        });
    }

    private void soundPlayButton(MediaPlayer sound1, MediaPlayer sound2) {
        if (sound1.isPlaying()) {
            sound1.pause();
            sound2.seekTo(0);
            sound1.setLooping(false);
//            sound.pause();
        }
        if (sound2.isPlaying()) {
            sound2.pause();
            sound2.seekTo(0);
            sound2.setLooping(false);
        }
        sound1.start();
        sound1.setLooping(true);
//        sound.seekTo(1000);
    }
}