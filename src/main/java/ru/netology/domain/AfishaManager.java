package ru.netology.domain;

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

    Movie[] movies = {
            new Movie(1, "Номер один", "comedy"),
            new Movie(2, "Trolls:World trip", "cartoon"),
            new Movie(3, "Bloodshot", "action"),
            new Movie(4, "Invisible Man", "horror"),
            new Movie(5, "Отель Белград", "comedy"),
            new Movie(6, "Onward", "cartoon"),
            new Movie(7, "The Gentlemen", "action"),
            new Movie(8, "Parasite", "triller/comedy"),
            new Movie(9, "Sonic The Hedgehog", "cartoon"),
            new Movie(10, "The Irishman", "drama/crime")
    };

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
