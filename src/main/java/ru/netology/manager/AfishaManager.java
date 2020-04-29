package ru.netology.manager;

import ru.netology.repository.AfishaRepository;
import ru.netology.domain.Movie;

public class AfishaManager {
    private AfishaRepository repository;
    private int itemsToReturn;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
        this.itemsToReturn = 10;
    }

    public void add(Movie item) {
        repository.save(item);
    }

    public Movie[] getLastItems() {
        int length = itemsToReturn;
        Movie[] items = repository.findAll();
        if (length > items.length) {
            length = items.length;
        }

        Movie[] result = new Movie[length];

        for (int i = 0; i < length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
