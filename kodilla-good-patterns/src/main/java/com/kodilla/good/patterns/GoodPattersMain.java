package com.kodilla.good.patterns;

import com.kodilla.good.patterns.challenges.MovieStore;

public class GoodPattersMain {

    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        String movieList = movieStore.getMovies().entrySet().stream()
                .flatMap(movie -> movie.getValue().stream()).forEach(System.out::println);
        System.out.println(movieList);
    }
}
