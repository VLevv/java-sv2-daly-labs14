package day02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {
    private List<Movie> movies=new ArrayList<>();

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public List<Movie> moviesWithGivenActor(String actor){
        return movies.stream().filter(movie -> movie.getActorNames().stream().anyMatch(name->name.equals(actor))).collect(Collectors.toList());
    }

    public int longestMovieLength(){
        return movies.stream().map(Movie::getLength).max(Integer::compareTo).get();
    }
}
