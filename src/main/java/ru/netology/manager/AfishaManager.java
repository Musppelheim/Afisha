package ru.netology.manager;

import ru.netology.domain.Movie;

public class AfishaManager {

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
            new Movie(10, "The Irishman", "drama/crime"),
           new  Movie(11, "Joker", "drama/crime")
    };

    public AfishaManager() {
    }

    public void add(Movie movie) {
        int moviesLength = movies.length;
        Movie[] tmpArray = new Movie[moviesLength + 1];
        System.arraycopy(movies, 0, tmpArray, 0, moviesLength);
        int lastIndex = tmpArray.length - 1;
        tmpArray[lastIndex] = movie;
        movies = tmpArray;
    }


    public Movie[] getLastAdded(int numberOfMoviesShown) {
        int moviesLength = movies.length;
        int maxMovies = 10;
        if (numberOfMoviesShown <= 0 || numberOfMoviesShown > maxMovies) {
            numberOfMoviesShown = maxMovies;
        }
        if (maxMovies > moviesLength) {
            maxMovies = moviesLength;
        }
        if (numberOfMoviesShown <= maxMovies) {
            maxMovies = numberOfMoviesShown;
        } else {
            maxMovies = moviesLength;
        }
        Movie[] chosenMovie = new Movie[maxMovies];
        for (int current = 0; current < chosenMovie.length; current++) {
            int result = moviesLength - current - 1;
            chosenMovie[current] = movies[result];
        }
        return chosenMovie;
    }

}
