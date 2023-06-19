package com.example.lab6;

import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;
public class Sight {
    final private String name;
    final private String description;
    private String hours_of_work;
    final private Point coordinates;
    private float price;

    public Sight(String name, String description, Point coordinates){
        this.name = name;
        this.description = description;
        this.coordinates = coordinates;
    }
    public Sight(String name, String description, Point coordinates, String hours_of_work){
        this(name, description,coordinates);
        this.hours_of_work = hours_of_work;
    }
    public Sight(String name, String description, Point coordinates, String hours_of_work, float price){
        this(name, description,coordinates, hours_of_work);
        this.price = price;
    }
    public String get_name(){
        return  name;
    }
    public String get_description(){
        return description;
    }
    public String get_hours_of_work(){
        return hours_of_work;
    }
    public Point get_coordinates(){
        return coordinates;
    }
    public void set_hours_of_work(String hours_of_work){
        this.hours_of_work = hours_of_work;
    }

    public float getPrice() {
        return price;
    }
}
