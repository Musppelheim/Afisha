package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
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


    @BeforeEach
    void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
        repository.save(eighth);
        repository.save(ninth);
        repository.save(tenth);
    }

    @Test
    void shouldFindAll() {
        assertArrayEquals(new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth}, repository.findAll());
    }

    @Test
    void shouldSave() {
        Movie eleventh = new Movie(11, "Joker", "drama/crime");
        repository.save(eleventh);
        assertArrayEquals(new Movie[]{first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh}, repository.findAll());
    }

    @Test
    void shouldFindById() {
        assertEquals(second, repository.findById(2));
        assertEquals(sixth, repository.findById(6));
        assertEquals(null, repository.findById(11));
    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 4;
        repository.removeById(idToRemove);
        assertArrayEquals(new Movie[]{first, second, third, fifth, sixth, seventh, eighth, ninth, tenth}, repository.findAll());

    }

    @Test
    void removeAll() {
        repository.removeAll();
        assertArrayEquals(new Movie[]{}, repository.findAll());
    }
}