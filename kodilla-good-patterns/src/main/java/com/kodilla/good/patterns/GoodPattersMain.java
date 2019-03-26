package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.MovieStore;

import java.util.stream.Collectors;

public class GoodPattersMain {

    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        String movieList = movieStore.getMovies().entrySet().stream()
                .flatMap(movie -> movie.getValue().stream()).collect(Collectors.joining(" ! "));
        System.out.println(movieList);
    }
}
