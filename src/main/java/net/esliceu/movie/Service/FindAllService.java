package net.esliceu.movie.Service;

import net.esliceu.movie.DAO.*;
import net.esliceu.movie.Model.Movie;
import net.esliceu.movie.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class FindAllService {
    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private CastRepo castRepo;
    @Autowired
    private AuthorizationRepo authorizationRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private CompanyCountryRepo companyCountryRepo;
    @Autowired
    private CountryRepo countryRepo;
    @Autowired
    private CrewMemberRepo crewMemberRepo;
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private GenderRepo genderRepo;
    @Autowired
    private GenreRepo genreRepo;
    @Autowired
    private KeywordRepo keywordRepo;
    @Autowired
    private LanguageRepo languageRepo;
    @Autowired
    private LanguageRoleRepo languageRoleRepo;
    @Autowired
    private MovieRepo movieRepo;
    @Autowired
    private MovieCompanyRepo movieCompanyRepo;
    @Autowired
    private MovieGenreRepo movieGenreRepo;
    @Autowired
    private MovieKeywordRepo movieKeywordRepo;
    @Autowired
    private MovieLanguageRepo movieLanguageRepo;
    @Autowired
    private PermissionRepo permissionRepo;
    @Autowired
    private UserRepo userRepo;

    public List<Person> getAllPersons(){
        return personRepo.findAll();
    }

    public List<Movie> getAllMovies(){
        return movieRepo.findAll();
    }
    public Page<Movie> getAllMoviesPage(int page){
        Pageable pageable = PageRequest.of(page, 10);
        return movieRepo.findAll(pageable);
    }
    public Page<Movie> getMoviesByName(String name, int page){
        Pageable pageable = PageRequest.of(page, 10);
        return movieRepo.findAllByTitleContainsIgnoreCase(name, pageable);
    }

    public Page<Person> getAllPersonsPage(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return personRepo.findAll(pageable);
    }
    public Page<Person> getPersonsByName(String name, int page){
        Pageable pageable = PageRequest.of(page, 10);
        return personRepo.findAllByNameContainsIgnoreCase(name, pageable);
    }
}
