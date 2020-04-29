package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.AfishaManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AfishaManagerTest {
    private AfishaManager manager = new AfishaManager();

    private Movie tenth = new Movie(10, "The Irishman", "drama/crime");
    private Movie ninth = new Movie(9, "Sonic The Hedgehog", "cartoon");
    private Movie eighth = new Movie(8, "Parasite", "triller/comedy");
    private Movie seventh = new Movie(7, "The Gentlemen", "action");
    private Movie sixth = new Movie(6, "Onward", "cartoon");
    private Movie fifth = new Movie(5, "Отель Белград", "comedy");
    private Movie fourth = new Movie(4, "Invisible Man", "horror");
    private Movie third = new Movie(3, "Bloodshot", "action");
    private Movie second = new Movie(2, "Trolls:World trip", "cartoon");
    private Movie first = new Movie(1, "Номер один", "comedy");


    @BeforeEach
    void setUp() {
        manager.add(tenth);
        manager.add(ninth);
        manager.add(eighth);
        manager.add(seventh);
        manager.add(sixth);
        manager.add(fifth);
        manager.add(fourth);
        manager.add(third);
        manager.add(second);
        manager.add(first);

    }

    @Test
    void shouldGetTenMovies() {
        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        Movie[] actual = manager.getLastAdded(10);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetFiveMovies() {
        Movie[] expected = {first, second, third, fourth, fifth};
        Movie[] actual = manager.getLastAdded(5);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowOverTenMovies() {
        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        Movie[] actual = manager.getLastAdded(100);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowNothing() {
        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        Movie[] actual = manager.getLastAdded(0);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowUnderMinimum() {
        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth};
        Movie[] actual = manager.getLastAdded(-10);
        assertArrayEquals(expected, actual);
    }

}