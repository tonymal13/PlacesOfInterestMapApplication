package com.example.lab6;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.ScreenPoint;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.BaseMapObjectCollection;
import com.yandex.mapkit.map.Callback;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.MapObject;
import com.yandex.mapkit.map.MapObjectDragListener;
import com.yandex.mapkit.map.MapObjectTapListener;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.mapkit.map.PlacemarkMapObject;

public class MapActivity extends Activity {
    private final String MAPKIT_API_KEY = "37d8e46b-93e5-40e2-95c5-914162639c76";
    private MapView mapView;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MapKitFactory.setApiKey(MAPKIT_API_KEY);
        setContentView(R.layout.activity_map);
        mapView = (MapView)findViewById(R.id.mapview);

        Bundle arguments = getIntent().getExtras();
        Sight sight = new Sight(arguments.getString("name"), arguments.getString("description"),
                new Point(arguments.getDouble("latitude"), arguments.getDouble("longitude")),
                arguments.getString("hours_of_work", null));
        if(sight.get_hours_of_work() == null)
            sight.set_hours_of_work("---");
        mapView.getMap().move(new CameraPosition(sight.get_coordinates(), 13.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0), null);

         //mapView.setFocusPoint(new ScreenPoint(Float.parseFloat(arguments.getString("latitude")), Float.parseFloat(arguments.getString("longitude"))));
         mapView.getMap().addMapObjectLayer("12345").addPlacemark(sight.get_coordinates());
        TextView description = findViewById(R.id.description);
        description.setText(sight.get_name() + "\nЧасы работы: " + sight.get_hours_of_work() + "\n" + sight.get_description());
    }
    @Override
    protected void onStop() {
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MapActivity.this, SightsActivity.class);
        startActivity(intent);
        finish();
    }
}

