package net.esliceu.movie.Service;

import net.esliceu.movie.DAO.*;
import net.esliceu.movie.Exceptions.EmptyNameException;
import net.esliceu.movie.Exceptions.ObjectNotFoundException;
import net.esliceu.movie.Exceptions.PasswordTooShortException;
import net.esliceu.movie.Exceptions.UserNameInUseException;
import net.esliceu.movie.Model.*;
import net.esliceu.movie.Utils.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddService {
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
    @Autowired
    private FindService findService;

    protected void addObject(Object object, JpaRepository repo){
        repo.save(object);
    }

    public void addAuthorization(int permissionId, int userId, String status) throws ObjectNotFoundException {
        Permission permission = findService.getPermission(permissionId);
        User user = findService.getUser(userId);
        AuthorizationId id = new AuthorizationId(permission, user);
        Authorization authorization = new Authorization(id, status);
        addObject(authorization, authorizationRepo);
    }

    public void addCast(int movieId, int personId, int genderId, String name, int order) throws ObjectNotFoundException {
        Movie movie = findService.getMovie(movieId);
        Person person = findService.getPerson(personId);
        Gender gender = findService.getGender(genderId);
        CastId id = new CastId(movie, person, gender);
        Cast cast = new Cast(id, name, order);
        addObject(cast, castRepo);
    }

    public void addCompany(String name){
        Company company = new Company(name);
        addObject(company, companyRepo);
    }

    public void addCompanyCountry(int movieId, int countryId) throws ObjectNotFoundException {
        Movie movie = findService.getMovie(movieId);
        Country country = findService.getCountry(countryId);
        CompanyCountryId id = new CompanyCountryId(movie, country);
        CompanyCountry companyCountry = new CompanyCountry(id);
        addObject(companyCountry, companyCountryRepo);
    }

    public void addCountry(String isoCode, String name){
        Country country = new Country(isoCode, name);
        addObject(country, countryRepo);
    }

    public void addCrewMember(int departmentId, int movieId, int personId, String job) throws ObjectNotFoundException {
        Department department = findService.getDepartment(departmentId);
        Movie movie = findService.getMovie(movieId);
        Person person = findService.getPerson(personId);
        CrewMemberId id = new CrewMemberId(department, movie, person);
        CrewMember crewMember = new CrewMember(id, job);
        addObject(crewMember, crewMemberRepo);
    }

    public void addDepartment(String name){
        Department department = new Department(name);
        addObject(department, departmentRepo);
    }

    public void addGender(int id, String name){
        Gender gender = new Gender(id, name);
        addObject(gender, genderRepo);
    }

    public void addGenre(String name){
        Genre genre = new Genre(name);
        addObject(genre, genreRepo);
    }

    public void addKeyword(String name){
        Keyword keyword = new Keyword(name);
        addObject(keyword, keywordRepo);
    }

    public void addLanguage(String code, String name){
        Language language = new Language(code, name);
        addObject(language, languageRepo);
    }

    public void addLanguageRole(String role){
        LanguageRole languageRole = new LanguageRole(role);
        addObject(languageRole, languageRoleRepo);
    }

    public void addMovie(String title, int budget, String homepage, String overview, double popularity, Date releaseDate, long revenue, int runtime, String status, String tagline, double voteAverage, int voteCount){
        Movie movie = new Movie(title, budget, homepage, overview, popularity, releaseDate, revenue, runtime, status, tagline, voteAverage, voteCount);
        addObject(movie, movieRepo);
    }

    public void addMovieCompany(int movieId, int companyId) throws ObjectNotFoundException {
        Movie movie = findService.getMovie(movieId);
        Company company = findService.getCompany(companyId);
        MovieCompanyId id = new MovieCompanyId(movie, company);
        MovieCompany movieCompany = new MovieCompany(id);
        addObject(movieCompany, movieCompanyRepo);
    }

    public void addMovieGenre(int movieId, int genreId) throws ObjectNotFoundException {
        Movie movie = findService.getMovie(movieId);
        Genre genre = findService.getGenre(genreId);
        MovieGenreId id = new MovieGenreId(movie, genre);
        MovieGenre movieGenre = new MovieGenre(id);
        addObject(movieGenre, movieGenreRepo);
    }

    public void addMovieKeyword(int movieId, int keywordId) throws ObjectNotFoundException {
        Movie movie = findService.getMovie(movieId);
        Keyword keyword = findService.getKeyword(keywordId);
        MovieKeywordId id = new MovieKeywordId(movie, keyword);
        MovieKeyword movieKeyword = new MovieKeyword(id);
        addObject(movieKeyword, movieKeywordRepo);
    }

    public void addMovieLanguage(int movieId, int languageId, int languageRoleId) throws ObjectNotFoundException {
        Movie movie = findService.getMovie(movieId);
        Language language = findService.getLanguage(languageId);
        LanguageRole languageRole = findService.getLanguageRole(languageRoleId);
        MovieLanguageId id = new MovieLanguageId(movie, language, languageRole);
        MovieLanguage movieLanguage = new MovieLanguage(id);
        addObject(movieLanguage, movieLanguageRepo);
    }

    public void addPermission(String name){
        Permission permission = new Permission(name);
        addObject(permission, permissionRepo);
    }

    public void addPerson(String name){
        Person person = new Person(name);
        addObject(person, personRepo);
    }

    public void addUser(String name, String password, String email, String status) throws EmptyNameException, PasswordTooShortException, UserNameInUseException {
        String processedName = name.replace(" ", "");
        if(name.isEmpty())throw new EmptyNameException();
        if(password.length() <= 5) throw new PasswordTooShortException();
        String hashedPassword = HashUtil.hash(password);
        try {
            User user = findService.login(processedName, hashedPassword);
            throw new UserNameInUseException();
        }catch (ObjectNotFoundException e){
            User user = new User(processedName, hashedPassword, email, status);
            addObject(user, userRepo);
        }
    }
}
