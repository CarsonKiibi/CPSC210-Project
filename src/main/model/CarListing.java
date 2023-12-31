package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;
import persistence.Writable;

import javax.swing.*;

// Code related to Json and corresponding tests inspired or directly used from:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// create a car listing
public class CarListing implements Writable {
    private static int nextPostId = 1;
    private int id;
    private String make;
    private String model;
    private int year;
    private int mileage;
    private int price;
    private String desc; // listing description
    private ImageIcon image;

    // MODIFIES: this
    // EFFECTS: creates car listing with post id (incremented after assigning), make, model,
    // year, and mileage
    public CarListing(int id, String make, String model, int year,
                      int mileage, int price, String desc) {
        this.id = nextPostId;
        nextPostId++;
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.desc = desc;
    }

    public int getId() {
        return this.id;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public int getMileage() {
        return this.mileage;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getPrice() {
        return this.price;
    }

    //public ImageIcon getImage() {
    //   return this.image;
    //}

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("make", make);
        json.put("model", model);
        json.put("year", year);
        json.put("mileage", mileage);
        json.put("price", price);
        json.put("desc", desc);
        return json;
    }
}

// for later maybe
    /*List<String> possibleCars = Arrays.asList("toyota","ford","chevrolet","honda",
            "nissan","jeep","hyundai","kia","ram","subaru","gmc","volkswagen", "bmw",
            "mazda","mercedes-benz","lexus","tesla","dodge","audi","buick","acura",
            "volvo","cadillac","chrysler","mitsubishi","land rover","lincoln","porsche",
            "infiniti","genesis","mini","maserati","alfa romeo","jaguar","bentley",
            "ferrari","lamborghini","aston martin","polestar","fiat","rolls-royce",
            "mclaren","lucid","bugatti","lotus","pontiac","rimac"); */
