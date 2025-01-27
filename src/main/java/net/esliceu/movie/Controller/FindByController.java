package net.esliceu.movie.Controller;

import jakarta.servlet.http.HttpSession;
import net.esliceu.movie.Model.*;
import net.esliceu.movie.Service.FindAllService;
import net.esliceu.movie.Utils.JQueryElement;
import net.esliceu.movie.Utils.JQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/findAllActors")
    public ResponseEntity<List<JQueryElement>> Actors(){
        List<Person> actors = findByService.getAllActors();
        List<JQueryElement> result = JQueryUtil.map(actors);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/findMoviesByActor")
    public ResponseEntity<Page<Movie>> MoviesByActor(int actor, int page){
        Page<Movie> movies = findByService.getMoviesByActor(actor, page);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/findMoviesByCharacter")
    public ResponseEntity<Page<Movie>> MoviesByCharacter(String character, int page){
        Page<Movie> movies = findByService.getMoviesByCharacter(character, page);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/findMoviesByDirector")
    public ResponseEntity<Page<Movie>> MoviesByDirector(int director, int page){
        Page<Movie> movies = findByService.getMoviesByDirector(director, page);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/findMoviesByGenre")
    public ResponseEntity<Page<Movie>> MoviesByGenre(int genre, int page){
        Page<Movie> movies = findByService.getMoviesByGenre(genre, page);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/findAllDirectors")
    public ResponseEntity<List<JQueryElement>> Directors(){
        List<Person> directors = findByService.getAllDirectors();
        List<JQueryElement> result = JQueryUtil.map(directors);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/findAllCharacters")
    public ResponseEntity<List<String>> Characters(){
        List<Cast> characters = findByService.getAllCharacters();
        List<String> result = JQueryUtil.mapStrings(characters);
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

    @GetMapping("/findAllUsers")
    public ResponseEntity<List<String>> Users(){
        List<User> users = findByService.getAllUsers();
        List<String> result = JQueryUtil.mapStrings(users);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/findUsers")
    public ResponseEntity<Page<User>> Users(int page){
        Page<User> users = findByService.getAllUsersPage(page);
        return ResponseEntity.ok(users);
    }
    @GetMapping("/findUsersByName")
    public ResponseEntity<Page<User>> UsersByName(String name, int page){
        Page<User> users = findByService.getUsersByName(name, page);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/findAllPermissions")
    public ResponseEntity<List<String>> Permissions(){
        List<Permission> permissions = findByService.getAllPermissions();
        List<String> result = JQueryUtil.mapStrings(permissions);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/findPermissions")
    public ResponseEntity<Page<Permission>> Permissions(int page){
        Page<Permission> permissions = findByService.getAllPermissionsPage(page);
        return ResponseEntity.ok(permissions);
    }
    @GetMapping("/findPermissionsByName")
    public ResponseEntity<Page<Permission>> PermissionsByName(String name, int page){
        Page<Permission> permissions = findByService.getPermissionsByName(name, page);
        return ResponseEntity.ok(permissions);
    }

    @GetMapping("/findAllLanguages")
    public ResponseEntity<List<String>> Languages(){
        List<Language> languages = findByService.getAllLanguages();
        List<String> result = JQueryUtil.mapStrings(languages);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/findLanguages")
    public ResponseEntity<Page<Language>> Languages(int page){
        Page<Language> languages = findByService.getAllLanguagesPage(page);
        return ResponseEntity.ok(languages);
    }
    @GetMapping("/findLanguagesByName")
    public ResponseEntity<Page<Language>> LanguagesByName(String name, int page){
        Page<Language> languages = findByService.getLanguagesByName(name, page);
        return ResponseEntity.ok(languages);
    }

    @GetMapping("/findAllLanguageRoles")
    public ResponseEntity<List<String>> LanguageRoles(){
        List<LanguageRole> languageRoles = findByService.getAllLanguageRoles();
        List<String> result = JQueryUtil.mapStrings(languageRoles);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/findLanguageRoles")
    public ResponseEntity<Page<LanguageRole>> LanguageRoles(int page){
        Page<LanguageRole> languageRoles = findByService.getAllLanguageRolesPage(page);
        return ResponseEntity.ok(languageRoles);
    }
    @GetMapping("/findLanguageRolesByName")
    public ResponseEntity<Page<LanguageRole>> LanguageRolesByName(String name, int page){
        Page<LanguageRole> languageRoles = findByService.getLanguageRolesByName(name, page);
        return ResponseEntity.ok(languageRoles);
    }

    @GetMapping("/findAllCountrys")
    public ResponseEntity<List<String>> Countries(){
        List<Country> countries = findByService.getAllCountries();
        List<String> result = JQueryUtil.mapStrings(countries);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/findCountrys")
    public ResponseEntity<Page<Country>> Countries(int page){
        Page<Country> countries = findByService.getAllCountriesPage(page);
        return ResponseEntity.ok(countries);
    }
    @GetMapping("/findCountrysByName")
    public ResponseEntity<Page<Country>> CountriesByName(String name, int page){
        Page<Country> countries = findByService.getCountriesByName(name, page);
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/findAllCompanys")
    public ResponseEntity<List<String>> Companies(){
        List<Company> companies = findByService.getAllCompanies();
        List<String> result = JQueryUtil.mapStrings(companies);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/findCompanys")
    public ResponseEntity<Page<Company>> Companies(int page){
        Page<Company> companies = findByService.getAllCompaniesPage(page);
        return ResponseEntity.ok(companies);
    }
    @GetMapping("/findCompanysByName")
    public ResponseEntity<Page<Company>> CompaniesByName(String name, int page){
        Page<Company> companies = findByService.getCompaniesByName(name, page);
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/findAllKeywords")
    public ResponseEntity<List<String>> Keywords(){
        List<Keyword> keywords = findByService.getAllKeywords();
        List<String> result = JQueryUtil.mapStrings(keywords);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/findKeywords")
    public ResponseEntity<Page<Keyword>> Keywords(int page){
        Page<Keyword> keywords = findByService.getAllKeywordsPage(page);
        return ResponseEntity.ok(keywords);
    }
    @GetMapping("/findKeywordsByName")
    public ResponseEntity<Page<Keyword>> KeywordsByName(String name, int page){
        Page<Keyword> keywords = findByService.getKeywordsByName(name, page);
        return ResponseEntity.ok(keywords);
    }

    @GetMapping("/findAllGenders")
    public ResponseEntity<List<String>> Genders(){
        List<Gender> genders = findByService.getAllGenders();
        List<String> result = JQueryUtil.mapStrings(genders);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/findGenders")
    public ResponseEntity<Page<Gender>> Genders(int page){
        Page<Gender> genders = findByService.getAllGendersPage(page);
        return ResponseEntity.ok(genders);
    }
    @GetMapping("/findGendersByName")
    public ResponseEntity<Page<Gender>> GendersByName(String name, int page){
        Page<Gender> genders = findByService.getGendersByName(name, page);
        return ResponseEntity.ok(genders);
    }

    @GetMapping("/findAllGenres")
    public ResponseEntity<List<JQueryElement>> Genres(){
        List<Genre> genres = findByService.getAllGenres();
        List<JQueryElement> result = JQueryUtil.map(genres);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/findGenres")
    public ResponseEntity<Page<Genre>> Genres(int page){
        Page<Genre> genres = findByService.getAllGenresPage(page);
        return ResponseEntity.ok(genres);
    }
    @GetMapping("/findGenresByName")
    public ResponseEntity<Page<Genre>> GenresByName(String name, int page){
        Page<Genre> genres = findByService.getGenresByName(name, page);
        return ResponseEntity.ok(genres);
    }

    @GetMapping("/findAllDepartments")
    public ResponseEntity<List<String>> Departments(){
        List<Department> departments = findByService.getAllDepartments();
        List<String> result = JQueryUtil.mapStrings(departments);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/findDepartments")
    public ResponseEntity<Page<Department>> Departments(int page){
        Page<Department> departments = findByService.getAllDepartmentsPage(page);
        return ResponseEntity.ok(departments);
    }
    @GetMapping("/findDepartmentsByName")
    public ResponseEntity<Page<Department>> DepartmentsByName(String name, int page){
        Page<Department> departments = findByService.getDepartmentsByName(name, page);
        return ResponseEntity.ok(departments);
    }
}
