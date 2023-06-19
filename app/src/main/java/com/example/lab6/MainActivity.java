package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onNextClick(View view) {
        EditText surname = findViewById(R.id.editSurname);
        EditText name = findViewById(R.id.editName);
        EditText email = findViewById(R.id.editEmail);
        User user = new User(name.getText().toString(), surname.getText().toString(), email.getText().toString());
        Intent intent = new Intent(MainActivity.this, SightsActivity.class);
        intent.putExtra("user_name", user.get_name());
        intent.putExtra("user_surname", user.get_surname());
        intent.putExtra("user_email", user.get_email());
        startActivity(intent);
        finish();
    }
}