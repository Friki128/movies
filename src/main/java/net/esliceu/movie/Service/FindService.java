package net.esliceu.movie.Service;

import net.esliceu.movie.DAO.*;
import net.esliceu.movie.Exceptions.ObjectNotFoundException;
import net.esliceu.movie.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindService {
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

    public Authorization getAuthorization(AuthorizationId id) throws ObjectNotFoundException {
        Optional<Authorization> authorization = authorizationRepo.findById(id);
        if(authorization.isEmpty())throw new ObjectNotFoundException();
        return authorization.get();
    }
    public Cast getCast(CastId id) throws ObjectNotFoundException {
        Optional<Cast> cast = castRepo.findById(id);
        if(cast.isEmpty())throw new ObjectNotFoundException();
        return cast.get();
    }
    public Company getCompany(int id) throws ObjectNotFoundException {
        Optional<Company> company = companyRepo.findById(id);
        if(company.isEmpty())throw new ObjectNotFoundException();
        return company.get();
    }
    public CompanyCountry getCompanyCountry(CompanyCountryId id) throws ObjectNotFoundException {
        Optional<CompanyCountry> companyCountry = companyCountryRepo.findById(id);
        if(companyCountry.isEmpty())throw new ObjectNotFoundException();
        return companyCountry.get();
    }
    public Country getCountry(int id) throws ObjectNotFoundException {
        Optional<Country> country = countryRepo.findById(id);
        if(country.isEmpty())throw new ObjectNotFoundException();
        return country.get();
    }
    public CrewMember getCrewMember(CrewMemberId id) throws ObjectNotFoundException {
        Optional<CrewMember> crewMember = crewMemberRepo.findById(id);
        if(crewMember.isEmpty())throw new ObjectNotFoundException();
        return crewMember.get();
    }
    public Department getDepartment(int id) throws ObjectNotFoundException {
        Optional<Department> department = departmentRepo.findById(id);
        if(department.isEmpty())throw new ObjectNotFoundException();
        return department.get();
    }
    public Gender getGender(int id) throws ObjectNotFoundException {
        Optional<Gender> gender = genderRepo.findById(id);
        if(gender.isEmpty())throw new ObjectNotFoundException();
        return gender.get();
    }
    public Genre getGenre(int id) throws ObjectNotFoundException {
        Optional<Genre> genre = genreRepo.findById(id);
        if(genre.isEmpty())throw new ObjectNotFoundException();
        return genre.get();
    }
    public Keyword getKeyword(int id) throws ObjectNotFoundException {
        Optional<Keyword> keyword = keywordRepo.findById(id);
        if(keyword.isEmpty())throw new ObjectNotFoundException();
        return keyword.get();
    }
    public Language getLanguage(int id) throws ObjectNotFoundException {
        Optional<Language> language = languageRepo.findById(id);
        if(language.isEmpty())throw new ObjectNotFoundException();
        return language.get();
    }
    public LanguageRole getLanguageRole(int id) throws ObjectNotFoundException {
        Optional<LanguageRole> languageRole = languageRoleRepo.findById(id);
        if(languageRole.isEmpty())throw new ObjectNotFoundException();
        return languageRole.get();
    }
    public Movie getMovie(int id) throws ObjectNotFoundException {
        Optional<Movie> movie = movieRepo.findById(id);
        if(movie.isEmpty())throw new ObjectNotFoundException();
        return movie.get();
    }
    public MovieCompany getMovieCompany(MovieCompanyId id) throws ObjectNotFoundException {
        Optional<MovieCompany> movieCompany = movieCompanyRepo.findById(id);
        if(movieCompany.isEmpty())throw new ObjectNotFoundException();
        return movieCompany.get();
    }
    public MovieGenre getMovieGenre(MovieGenreId id) throws ObjectNotFoundException {
        Optional<MovieGenre> movieGenre = movieGenreRepo.findById(id);
        if(movieGenre.isEmpty())throw new ObjectNotFoundException();
        return movieGenre.get();
    }
    public MovieKeyword getMovieKeyword(MovieKeywordId id) throws ObjectNotFoundException {
        Optional<MovieKeyword> movieKeyword = movieKeywordRepo.findById(id);
        if(movieKeyword.isEmpty())throw new ObjectNotFoundException();
        return movieKeyword.get();
    }
    public MovieLanguage getMovieLanguage(MovieLanguageId id) throws ObjectNotFoundException {
        Optional<MovieLanguage> movieLanguage = movieLanguageRepo.findById(id);
        if(movieLanguage.isEmpty())throw new ObjectNotFoundException();
        return movieLanguage.get();
    }
    public Permission getPermission(int id) throws ObjectNotFoundException {
        Optional<Permission> permission = permissionRepo.findById(id);
        if(permission.isEmpty())throw new ObjectNotFoundException();
        return permission.get();
    }
    public Person getPerson(int id) throws ObjectNotFoundException {
        Optional<Person> person = personRepo.findById(id);
        if(person.isEmpty())throw new ObjectNotFoundException();
        return person.get();
    }
    public User getUser(int id) throws ObjectNotFoundException{
        Optional<User> user = userRepo.findById(id);
        if(user.isEmpty())throw new ObjectNotFoundException();
        return user.get();
    }
    public User login(String name, String password)throws ObjectNotFoundException{
        Optional<User> user = userRepo.findByNameAndPassword(name, password);
        if(user.isEmpty())throw new ObjectNotFoundException();
        return user.get();
    }
}
