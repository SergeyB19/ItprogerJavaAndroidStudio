package com.itproger.itproger;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ContactsActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private String[] namesArr = new String[]{"John", "Josh", "George", "Bob", "ALex"};
    private ListView listView;
    private GestureDetectorCompat gestureDetectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contacts);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        gestureDetectorCompat = new GestureDetectorCompat(this,this);
        gestureDetectorCompat.setIsLongpressEnabled(true);
        gestureDetectorCompat.setOnDoubleTapListener(this);


        listView.findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.name_item, R.id.user_name, namesArr);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ContactsActivity.this, (String) listView.getItemAtPosition(position), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public void goContacts(View view) {
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onDown(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(@NonNull MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(@NonNull MotionEvent motionEvent) {
        Toast.makeText(this, motionEvent.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(@NonNull MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(@NonNull MotionEvent e) {
        return false;
    }
}