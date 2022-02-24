package com.revature.collections;

import net.jakemorris.collections.ArrayList;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    private ArrayList<String> list = new ArrayList<>(2);

    @Test
    void arrayShouldAcceptAnyValidObject() {
        ArrayList<Integer> intList = new ArrayList<>(1);
        intList.add(1);
        intList.printElements();
        assertNotNull(intList.get(0));
    }

//    @Test
//    void containsShouldWorkWithCustomObjects() {
//        ArrayList<Pojo> myList = new ArrayList<>(1);
//        Pojo myObj = new Pojo("testObj");
//        myList.add(myObj);
//        Pojo myNewObj = new Pojo("testObj");
//        assertTrue(myList.contains(myNewObj));
//    }

    @Test
    void fullArrayListShouldDoubleInSizeWhenNewElementIsAdded() {
        int initialLength = list.getElements().length;
        this.list.add("Test");
        this.list.add("Test");
        this.list.add("Test");
        int finalLength = list.getElements().length;

        assertEquals(finalLength, initialLength * 2);
    }

    @Test
    void setElementShouldUpdateTheElementAtTheGivenIndex() {
        String testString = "new string";
        this.list.setElement(0, testString);
        assertEquals(this.list.get(0), testString);
    }

    @Test
    void setElementShouldThrowExceptionWithNegativeIndexArgument() {
        assertThrows(
                IllegalArgumentException.class,
                () -> list.setElement(-1, "This shouldn't work")
        );
    }

    @Test
    void getElementShouldReturnElementAtGivenIndex() {
        list.add("Test string");
        String firstEl = list.get(0);
        assertNotNull(firstEl);
    }

    @Test
    void getElementShouldThrowExceptionIfElementDoesNotExist() {
        assertThrows(
                NoSuchElementException.class,
                () -> list.get(-1)
        );
    }

    @Test
    void containsShouldReturnTrueIfObjectIsPresentInList() {
        list.add("this string should exist");
        assertTrue(list.contains("this string should exist"));
    }

    @Test
    void containsShouldReturnFalseIfObjectIsNotPresentInList() {
        list.add("this is a string");
        assertFalse(list.contains("my string"));
    }

    @Test
    void isIdenticalShouldReturnTrueIfTheArraysContainSameValues() {
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");

        ArrayList<String> newList = new ArrayList<>(1);
        newList.add("Test1");
        newList.add("Test2");
        newList.add("Test3");

        assertTrue(list.isIdentical(newList));
    }

    @Test
    void isIdenticalShouldReturnFalseIfTheArraysContainDifferentValues() {
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");

        ArrayList<String> newList = new ArrayList<>(1);
        newList.add("Test");
        newList.add("Test2");
        newList.add("Test3");

        assertFalse(list.isIdentical(newList));
    }
}
