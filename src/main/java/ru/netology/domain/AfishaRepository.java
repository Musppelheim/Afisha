package ru.netology.domain;

public class AfishaRepository {
    private Movie[] items = new Movie[0];

    public Movie[] findAll() {
        return items;
    }

    public void save(Movie item) {
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];

        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    Movie findById(int id) {
        for (Movie item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public boolean removeById(int id) {
        int length = items.length - 1;
        Movie[] tmp = new Movie[length];
        int index = 0;
        boolean founded = false;
        for (Movie item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            } else {
                founded = true;
            }
        }
        items = tmp;
        return founded;
    }

    public void removeAll() {
        items = new Movie[0];
    }

}
