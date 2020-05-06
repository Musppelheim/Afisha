package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    private Movie first = new Movie(1, "Номер один", "comedy");
    private Movie second = new Movie(2, "Trolls:World trip", "cartoon");
    private Movie third = new Movie(3, "Bloodshot", "action");
    private Movie fourth = new Movie(4, "Invisible Man", "horror");
    private Movie fifth = new Movie(5, "Отель Белград", "comedy");
    private Movie sixth = new Movie(6, "Onward", "cartoon");
    private Movie seventh = new Movie(7, "The Gentlemen", "action");
    private Movie eighth = new Movie(8, "Parasite", "triller/comedy");
    private Movie ninth = new Movie(9, "Sonic The Hedgehog", "cartoon");
    private Movie tenth = new Movie(10, "The Irishman", "drama/crime");
    private Movie eleventh = new Movie(11, "Joker", "drama/crime");



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
    }

    @Test
    void shouldFindByIdOverTen() {
        repository.findById(96);
        assertNull(repository.findById(96));
    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 4;
        repository.removeById(idToRemove);
        assertArrayEquals(new Movie[]{first, second, third, fifth, sixth, seventh, eighth, ninth, tenth}, repository.findAll());

    }

    @Test
    void shouldNoRemoveByIdIfNotExist() {
        int idToRemove = 27;
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.removeById(idToRemove));
    }

    @Test
    void removeAll() {
        repository.removeAll();
        assertArrayEquals(new Movie[]{}, repository.findAll());
    }
}