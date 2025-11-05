package org.example.Barnes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookTest {

    private Book testBook;
    private Book bookOne;
    private Book bookTwo;

    @BeforeEach
    void setUp() {
        testBook = new Book ("123-ABC", 50, 10);
        bookOne = new Book ("8910-GHI", 50, 10);
        bookTwo = new Book ("456-DEF", 10, 20);
    }

    @Test
    void getPrice() {
        assertEquals(50, testBook.getPrice());
    }

    @Test
    void getQuantity() {
        assertEquals(10, testBook.getQuantity());
    }

    @Test
    void testEqualsNull() {
        assertFalse(testBook.equals(null));
    }

    @Test
    void testEqualsSameObject() {
        assertTrue(testBook.equals(testBook));
    }

    @Test
    void testEqualsDifferentClass(){
        String testString = "Test";
        assertFalse(testBook.equals(testString));
    }
    @Test
    void testEqualsTrue() {
        Book bookThree = new Book ("123-ABC", 50, 10);
        assertTrue(testBook.equals(bookThree));
    }

    @Test
    void testEqualsFalse() {
        assertFalse(bookOne.equals(bookTwo));
    }

    @Test
    void testHashCode() {
        assertEquals(2017969734, testBook.hashCode());
    }
}