package org.example.Barnes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseSummaryTest {

    private PurchaseSummary purchaseSummary;
    private Book bookOne;
    private Book bookTwo;
    @BeforeEach
    void setUp() {
        purchaseSummary = new PurchaseSummary();

        bookOne = new Book ("8910-GHI", 50, 10);
        bookTwo = new Book ("456-DEF", 10, 20);
    }

    @Test
    void addUnavailableEmptyTest(){
        purchaseSummary.addUnavailable(bookOne, 2);

        assertFalse(purchaseSummary.getUnavailable().isEmpty());
    }
    @Test
    void addUnavailableExpectedTest() {
        purchaseSummary.addUnavailable(bookOne, 2);

        assertTrue(purchaseSummary.getUnavailable().containsKey(bookOne));
    }

    @Test
    void addAvailableTwoOrMoreBookTest() {
        purchaseSummary.addUnavailable(bookOne, 2);
        purchaseSummary.addUnavailable(bookTwo, 4);

        assertTrue(purchaseSummary.getUnavailable().containsKey(bookOne) && purchaseSummary.getUnavailable().containsKey(bookTwo));
    }

    @Test
    void addToTotalPriceTest() {
        purchaseSummary.addToTotalPrice(bookOne.getPrice());

        assertEquals(bookOne.getPrice(), purchaseSummary.getTotalPrice());
    }

    @Test
    void addNegativeToTotalPriceTest() {
        purchaseSummary.addToTotalPrice(-40);

        assertEquals(-40, purchaseSummary.getTotalPrice());
    }

    @Test
    void getTotalPriceTest() {
        purchaseSummary.addToTotalPrice(bookTwo.getPrice());
        purchaseSummary.addToTotalPrice(bookOne.getPrice());

        assertEquals(60, purchaseSummary.getTotalPrice());
    }

    @Test
    void getUnavailableEmptyTest() {
        assertTrue(purchaseSummary.getUnavailable().isEmpty());
    }

    @Test
    void getUnavailableTest() {
        assertTrue(purchaseSummary.getUnavailable().isEmpty());
    }
}