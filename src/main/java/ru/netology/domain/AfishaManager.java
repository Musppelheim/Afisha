package ru.netology.domain;

public class AfishaManager {
    private Movie[] items = new Movie[0];
    private int itemsToReturn;

    public AfishaManager(int itemsToReturn) {
        this.itemsToReturn = itemsToReturn;
    }

    Movie[] movies = {
            new Movie(1,"Номер один", "comedy"),
            new Movie(2, "Trolls:World trip","cartoon"),
            new Movie(3, "Bloodshot", "action"),
            new Movie(4, "Invisible Man", "horror"),
            new Movie(5, "Отель Белград", "comedy"),
            new Movie(6, "Onward", "cartoon"),
            new Movie(7, "The Gentlemen", "action"),
            new Movie(8, "Parasite", "triller/comedy"),
            new Movie(9, "Sonic The Hedgehog", "cartoon"),
            new Movie(10, "The Irishman","drama/crime")
    };

    public void add(Movie item) {
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];

        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie[] getLastItems() {
        int length = itemsToReturn;
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
