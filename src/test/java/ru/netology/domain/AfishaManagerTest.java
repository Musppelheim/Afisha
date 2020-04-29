package ru.netology.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.manager.AfishaManager;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AfishaManagerTest {
    @Mock
    private AfishaRepository repository;
    @InjectMocks
    private AfishaManager manager;

    private Movie first = new Movie(1, "Номер один", "comedy");
    private Movie second = new Movie(2, "Trolls:World trip", "cartoon");
    private Movie third = new Movie(3, "Bloodshot", "action");
    private Movie fourth = new Movie(4, "Invisible Man", "horror");
    private Movie fifth = new Movie(5, "Отель Белград", "comedy");
    private Movie sixth = new Movie(6, "Onward", "cartoon");
    private Movie seventh = new Movie(7, "The Gentlemen", "action");
    private Movie eighth = new Movie(8, "Parasite", "triller/comedy");
    private  Movie ninth = new Movie(9, "Sonic The Hedgehog", "cartoon");
    private  Movie tenth = new Movie(10, "The Irishman", "drama/crime");
    private Movie eleventh = new Movie(11, "Joker", "drama/crime");

    @Test
    void shouldAdd() {
        Movie first = new Movie(1, "Фильм1", "comedy");
        Movie second = new Movie(2, "Фильм2", "drama");
        Movie third = new Movie(5, "Фильм3", "horrors");

        manager.add(first);
        manager.add(second);
        manager.add(third);

        Movie[] returned = new Movie[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(fourth);

        manager.add(fourth);
        Movie[] actual = manager.getLastItems();
        Movie[] expected = new Movie[]{third, second, first};

        assertArrayEquals(expected, actual);
        verify(repository).save(fourth);
    }

    @Test
    void shouldAddOverTenMovies() {

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

        Movie[] returned = new Movie[]{
                first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth
        };
        doReturn(returned).when(repository).findAll();

        Movie[] actual = manager.getLastItems();
        Movie[] expected = new Movie[]{tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second, first};

        assertArrayEquals(expected, actual);
        verify(repository, times(1)).save(eleventh);
    }

}


