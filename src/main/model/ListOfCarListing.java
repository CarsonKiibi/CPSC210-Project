package model;

import org.json.JSONArray;
import org.json.JSONObject;
import ui.CarApp;

import java.util.ArrayList;
import java.util.List;

import persistence.Writable;

// Code related to Json and corresponding tests inspired or directly used from:
// https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// creates a new list of cars
public class ListOfCarListing implements Writable {
    private String name;
    private List<CarListing> listings;

    private int minPrice;
    private int maxPrice;

    // MODIFIES: this
    // EFFECTS: initializes new empty list of car listings
    public ListOfCarListing(String name) {
        this.name = name;
        listings = new ArrayList<>();
        minPrice = 0;
        maxPrice = 100000000;
    }

    public List<CarListing> getListings() {
        return this.listings;
    }

    // MODIFIES: this
    // EFFECTS: adds a given carListing to the current list of car listings
    public void addListingToList(CarListing carlisting) {
        listings.add(carlisting);
        EventLog.getInstance().logEvent(new Event("Added car listing to list of listings."));
    }

    // EFFECTS: returns size of list of car listings
    public int getSize() {
        return listings.size();
    }

    public String getName() {
        return this.name;
    }

    public int getMinPrice() {
        return this.minPrice;
    }

    public int getMaxPrice() {
        return this.maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    // REQUIRES: carListings != null
    // EFFECTS: if list of car listings is empty, displays noListings() message and returns false,
    // if the listing is too expensive or too cheap, displays noListings() message and returns false,
    // otherwise displays each car listing and returns true
    public static boolean loopListOfCarListing(ListOfCarListing carListings) {
        int allTrue = carListings.getSize();
        int count = 0;
        if (carListings.getSize() == 0) {
            //CarApp.noListings();
            EventLog.getInstance().logEvent(new Event("Looped car listings, no listings."));
            return false;
        } else {
            for (CarListing carlisting : carListings.getListings()) {
                if (carlisting.getPrice() <= carListings.getMaxPrice()
                        && carlisting.getPrice() >= carListings.getMinPrice()) {
                    //CarApp.displayListing(carlisting);
                    count++;
                    EventLog.getInstance().logEvent(new Event("Looped car listings, displayed a listing."));
                }
            }
            return checkLooped(allTrue, count);
        }
    }

    private static boolean checkLooped(int allTrue, int count) {
        if (count == allTrue) {
            EventLog.getInstance().logEvent(new Event("All listings were in price range."));
            return true;
        } else if (count >= 1) {
            EventLog.getInstance().logEvent(new Event(count + " listings were in price range."));
            return true;
        } else {
            EventLog.getInstance().logEvent(new Event("Looped car listings, "
                    + "all listings were outside of price range."));
            return false;
        }
    }

    // MODIFIES: listings
    // EFFECTS: removes given carlisting from listings
    public void removeListingFromList(CarListing carListing) {
        listings.remove(carListing);
        EventLog.getInstance().logEvent(new Event("Removed car listing from list."));
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("carListings", listingsToJson());
        return json;
    }

    // EFFECTS: returns carListings in this listOfCarListings as a JSON array
    private JSONArray listingsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (CarListing cl : listings) {
            jsonArray.put(cl.toJson());
        }

        return jsonArray;
    }
}
