package day02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    @Test
    void moviesTest() {
        MovieService service = new MovieService();
        service.addMovie(new Movie("movie1",12, List.of("jani","peti","gabi")));
        service.addMovie(new Movie("movie2",14, List.of("jani","peti","gabi")));
        service.addMovie(new Movie("movie3",16, List.of("jani","peti")));
        service.addMovie(new Movie("movie4",18, List.of("jani","gabi")));
        service.addMovie(new Movie("movie5",12, List.of("peti","gabi")));
        assertEquals(4,service.moviesWithGivenActor("jani").size());
        assertEquals(18,service.longestMovieLength());
    }
}