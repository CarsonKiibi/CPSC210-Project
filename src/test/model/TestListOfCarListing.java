package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestListOfCarListing {
    private CarListing testListing0;
    private CarListing testListing1;
    private CarListing testListing1Clone;
    private ListOfCarListing testListings;

    @BeforeEach
    void runBefore() {
        testListing0 = new CarListing(0, "Ford", "Raptor", 2019, 1000);
        testListing1 = new CarListing(1, "Toyota", "Camry", 2020, 5000);
        testListing1Clone = new CarListing(1, "Toyota", "Camry", 2020, 5000);
        testListings = new ListOfCarListing();
    }

    @Test
    void addListingToListOneTest() {
        assertEquals(0, testListings.getSize());
        testListings.addListingToList(testListing0);
        assertEquals(1, testListings.getSize());
        List<CarListing> testList2 = new ArrayList<>();
        testList2.add(testListing0);
        assertEquals(testList2, testListings.getListings());
    }

    @Test
    void addListingToListTwoDiffTest() {
        assertEquals(0, testListings.getSize());
        testListings.addListingToList(testListing0);
        testListings.addListingToList(testListing1);
        assertEquals(2, testListings.getSize());
        assertNotEquals(testListing0.getModel(), testListing1.getModel());
        assertNotEquals(testListing0.getMileage(), testListing1.getMileage());
        assertNotEquals(testListing0.getYear(), testListing1.getYear());
    }

    @Test
    void addListingToListTwoSameTest() {
        testListings.addListingToList(testListing1);
        testListings.addListingToList(testListing1Clone);
        assertEquals(2, testListings.getSize());
        assertEquals(testListing1.getMake(), testListing1Clone.getMake());
        assertNotEquals(testListing1.getId(), testListing1Clone.getId());
    }

    @Test
    void loopListOfCarListingTest() {
        assertFalse(ListOfCarListing.loopListOfCarListing(testListings));
        testListings.addListingToList(testListing0);
        assertTrue(ListOfCarListing.loopListOfCarListing(testListings));
        testListings.addListingToList(testListing1);
        assertTrue(ListOfCarListing.loopListOfCarListing(testListings));
    }

}
