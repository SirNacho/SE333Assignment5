package org.example.Barnes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BarnesAndNobleTest {

    private BookDatabase mockBookDatabase;
    private BuyBookProcess mockBuyBookProcess;
    private PurchaseSummary purchaseSummary;
    private BarnesAndNoble barnesAndNobleTest;

    private Book bookOne;
    private Book bookTwo;

    @BeforeEach
    void setUp() {
        mockBookDatabase = mock(BookDatabase.class);
        mockBuyBookProcess = mock(BuyBookProcess.class);
        purchaseSummary = new PurchaseSummary();
        barnesAndNobleTest = new BarnesAndNoble(mockBookDatabase, mockBuyBookProcess);

        bookOne = new Book("123-ABC", 50, 10);
        bookTwo = new Book ("456-DEF", 10, 20);
    }

    @Test
    void getPriceForCartNullTest() {
        Map<String, Integer> nullMap = null;

        PurchaseSummary purchaseSummary = barnesAndNobleTest.getPriceForCart(nullMap);

        assertNull(purchaseSummary);
    }

    @Test
    void getPriceForCartExpectedOneBookTest() {
        Map<String, Integer> expectedMap = Map.of("123-ABC", 5);
        when(mockBookDatabase.findByISBN("123-ABC")).thenReturn(bookOne);

        barnesAndNobleTest.getPriceForCart(expectedMap);

        verify(mockBuyBookProcess).buyBook(bookOne, 5);
    }

    @Test
    void getPriceForCartMoreRequestedQuantityTest() {
        Map<String, Integer> expectedMap = Map.of("123-ABC", 15);
        when(mockBookDatabase.findByISBN("123-ABC")).thenReturn(bookOne);

        barnesAndNobleTest.getPriceForCart(expectedMap);

        verify(mockBuyBookProcess).buyBook(bookOne, 10);
    }
}