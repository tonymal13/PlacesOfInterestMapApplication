package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Route extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

       ListView view =  (ListView)findViewById(R.id.routelist);
        List<Sight> selectedSights = new ArrayList<>();
        for(String i : getIntent().getStringArrayExtra("sights"))
        {
            Sight s  =Base.sights.stream().filter(it -> it.get_name().equals(i)).findFirst().get();
            selectedSights.add(s);
        }
        List<Sight> orderedList = new ArrayList<>();
        orderedList.add(selectedSights.get(0));
        selectedSights.remove(0);
        while(selectedSights.size() > 0)
        {
            Sight lastSight =orderedList.get(orderedList.size()-1);
            Location l = new Location("");
            l.setLatitude(lastSight.get_coordinates().getLatitude());
            l.setLongitude(lastSight.get_coordinates().getLongitude());
            Sight min = null;
            float minDistance = Float.MAX_VALUE;
            for(int i =0 ; i < selectedSights.size(); i++)
            {
                Location l2 = new Location("");
                l2.setLongitude(selectedSights.get(i).get_coordinates().getLongitude());
                l2.setLatitude(selectedSights.get(i).get_coordinates().getLatitude());
                float distance = l.distanceTo(l2);
                if(minDistance > distance )
                {
                    minDistance = distance;
                    min = selectedSights.get(i);
                }
            }
            selectedSights.remove(min);
            orderedList.add(min);
        }

        double totalPrice = orderedList.stream().flatMapToDouble(it -> DoubleStream.of(it.getPrice())).sum();
        float totalDistance = 0;
        for(int i =0; i< orderedList.size()-1; i++)
        {
            Location l = new Location("");
            l.setLatitude(orderedList.get(i).get_coordinates().getLatitude());
            l.setLongitude(orderedList.get(i).get_coordinates().getLongitude());
            Location l2 = new Location("");
            l2.setLatitude(orderedList.get(i+1).get_coordinates().getLatitude());
            l2.setLongitude(orderedList.get(i+1).get_coordinates().getLongitude());
            totalDistance += l.distanceTo(l2);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                orderedList.stream().map(it -> it.get_name() +"\n" + (it.get_hours_of_work() == null?"Круглосуточно":it.get_hours_of_work())+ "\n" + it.getPrice()).collect(Collectors.toList()));

        view.setAdapter(adapter);

        ((TextView)findViewById(R.id.price)).setText("Суммарная стоимость: " +String.valueOf(totalPrice));
        ((TextView)findViewById(R.id.totalDistance)).setText("Суммарное расстрояние: " +String.valueOf(totalDistance/1000)+"км");

    }
}