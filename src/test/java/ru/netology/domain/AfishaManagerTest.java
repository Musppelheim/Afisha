package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AfishaManagerTest {
    AfishaManager manager = new AfishaManager(10);

    @Test
    void shouldAdd() {
        Movie first = new Movie(1, "Фильм1", "comedy");
        Movie second = new Movie(2, "Фильм2", "drama");
        Movie third = new Movie(5, "Фильм3", "horrors");

        manager.add(first);
        manager.add(second);
        manager.add(third);

        Movie[] actual = manager.getLastItems();
        Movie[] expected = new Movie[]{third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddOverTenMovies() {
        Movie first = new Movie(1, "Номер один", "comedy");
        Movie second = new Movie(2, "Trolls:World trip", "cartoon");
        Movie third = new Movie(3, "Bloodshot", "action");
        Movie fourth = new Movie(4, "Invisible Man", "horror");
        Movie fifth = new Movie(5, "Отель Белград", "comedy");
        Movie sixth = new Movie(6, "Onward", "cartoon");
        Movie seventh = new Movie(7, "The Gentlemen", "action");
        Movie eighth = new Movie(8, "Parasite", "triller/comedy");
        Movie ninth = new Movie(9, "Sonic The Hedgehog", "cartoon");
        Movie tenth = new Movie(10, "The Irishman", "drama/crime");
        Movie eleventh = new Movie(11, "Joker", "drama/crime");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        Movie[] actual = manager.getLastItems();
        Movie[] expected = new Movie[]{eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};

        assertArrayEquals(expected, actual);
    }

}