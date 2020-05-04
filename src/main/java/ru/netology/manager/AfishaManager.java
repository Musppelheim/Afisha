package ru.netology.manager;

import ru.netology.repository.AfishaRepository;
import ru.netology.domain.Movie;

public class AfishaManager {
    private AfishaRepository repository;
    private int moviesToReturn;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
        this.moviesToReturn = 10;
    }

    public void add(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getLastAdded(int numberOfMoviesShown) {
        Movie[] movies = repository.findAll();
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
