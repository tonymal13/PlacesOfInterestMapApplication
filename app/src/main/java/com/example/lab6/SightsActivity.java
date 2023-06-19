package com.example.lab6;

import static android.app.PendingIntent.getActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.yandex.mapkit.geometry.Point;

import java.util.List;

public class SightsActivity extends FragmentActivity {


    @SuppressLint({"SetTextI18n", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sights);

        TextView greeting = findViewById(R.id.greeting);
        Bundle arguments = getIntent().getExtras();
        String txtName = arguments.getString("user_name");
        String txtSurname = arguments.getString("user_surname");
        String txtEmail = arguments.getString("user_email");
        String str = getResources().getString(R.string.greeting) + " " + txtName + " " + txtSurname + " " + txtEmail;
        greeting.setText(str);
        ListView listView = findViewById(R.id.sightList);
        ArrayAdapter<Sight> adapter = new CustomAdapter(this, R.layout.adapter_layout, Base.sights);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) ->
                {
                    Sight sight = (Sight) listView.getAdapter().getItem(position);
                    loadSight(sight);
                }
                    );

        }

        private void loadSight(Sight sight)
        {
            Intent intent = new Intent(this, MapActivity.class);
            intent.putExtra("name", sight.get_name());
            intent.putExtra("description", sight.get_description());
            intent.putExtra("latitude", sight.get_coordinates().getLatitude());
            intent.putExtra("longitude", sight.get_coordinates().getLongitude());
            intent.putExtra("hours_of_work", sight.get_hours_of_work());
            startActivity(intent);
        }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SightsActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void showDialog(View view)
    {
        CreateTravelDialog dialog = new CreateTravelDialog(Base.sights);
        FragmentManager manager = getSupportFragmentManager();
        dialog.show(manager, "dialog");
    }

    public void createRoute(List<String> strings)
    {
        Intent intent = new Intent(this, Route.class);
        intent.putExtra("sights", strings.toArray(new String[0]));
        startActivity(intent);
    }
}
