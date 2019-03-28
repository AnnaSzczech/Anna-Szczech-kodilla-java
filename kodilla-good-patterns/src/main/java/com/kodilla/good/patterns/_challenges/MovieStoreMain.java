package com.kodilla.good.patterns._challenges;

import java.util.stream.Collectors;

public class MovieStoreMain {

    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        String movieList = movieStore.getMovies().entrySet().stream()
                .flatMap(movie -> movie.getValue().stream()).collect(Collectors.joining(" ! "));
        System.out.println(movieList);
    }
}
