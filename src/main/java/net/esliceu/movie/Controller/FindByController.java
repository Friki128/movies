package net.esliceu.movie.Controller;

import jakarta.servlet.http.HttpSession;
import net.esliceu.movie.Model.Movie;
import net.esliceu.movie.Model.Person;
import net.esliceu.movie.Service.FindAllService;
import net.esliceu.movie.Utils.JQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindByController {
    @Autowired
    HttpSession httpSession;
    @Autowired
    FindAllService findByService;
    @GetMapping("/findMoviesByName")
    public ResponseEntity<Page<Movie>> MoviesByName(String name, int page){
        Page<Movie> movies = findByService.getMoviesByName(name, page);
        return ResponseEntity.ok(movies);
    }
    @GetMapping("/findMovies")
    public ResponseEntity<Page<Movie>> Movies(int page){
        Page<Movie> movies = findByService.getAllMoviesPage(page);
        return ResponseEntity.ok(movies);
    }
    @GetMapping("/findAllMovies")
    public ResponseEntity<List<String>> Movies(){
        List<Movie> movies = findByService.getAllMovies();
        List<String> result = JQueryUtil.mapStrings(movies);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/findAllPersons")
    public ResponseEntity<List<String>> Persons(){
        List<Person> persons = findByService.getAllPersons();
        List<String> result = JQueryUtil.mapStrings(persons);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/findPersons")
    public ResponseEntity<Page<Person>> Persons(int page){
        Page<Person> persons = findByService.getAllPersonsPage(page);
        return ResponseEntity.ok(persons);
    }
    @GetMapping("/findPersonsByName")
    public ResponseEntity<Page<Person>> PersonsByName(String name, int page){
        Page<Person> persons = findByService.getPersonsByName(name, page);
        return ResponseEntity.ok(persons);
    }
}
