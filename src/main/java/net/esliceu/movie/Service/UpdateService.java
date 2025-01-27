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

@Service
public class UpdateService {
    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private CastRepo castRepo;
    @Autowired
    private AuthorizationRepo authorizationRepo;
    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private ProductionCountryRepo productionCountryRepo;
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

    protected <v> void updateObject(Object id, Object updated, JpaRepository repo) throws ObjectNotFoundException {
        v object = findService.getValue(id, repo);
        repo.save(updated);
    }

    public void updateAuthorization(int permissionId, int userId, String status) throws ObjectNotFoundException {
        Permission permission = findService.getPermission(permissionId);
        User user = findService.getUser(userId);
        AuthorizationId id = new AuthorizationId(permission, user);
        Authorization authorization = new Authorization(id, status);
        updateObject(id, authorization, authorizationRepo);
    }

    public void updateCast(int movieId, int personId, int genderId, String name, int order) throws ObjectNotFoundException {
        Movie movie = findService.getMovie(movieId);
        Person person = findService.getPerson(personId);
        Gender gender = findService.getGender(genderId);
        CastId id = new CastId(movie, person, gender);
        Cast cast = new Cast(id, name, order);
        updateObject(id, cast, castRepo);
    }

    public void updateCompany(int id, String name) throws ObjectNotFoundException {
        Company company = new Company(name);
        company.setId(id);
        updateObject(id, company, companyRepo);
    }

    public void updateCountry(int id, String isoCode, String name) throws ObjectNotFoundException {
        Country country = new Country(isoCode, name);
        country.setId(id);
        updateObject(id, country, countryRepo);
    }

    public void updateCrewMember(int departmentId, int movieId, int personId, String job) throws ObjectNotFoundException {
        Department department = findService.getDepartment(departmentId);
        Movie movie = findService.getMovie(movieId);
        Person person = findService.getPerson(personId);
        CrewMemberId id = new CrewMemberId(department, movie, person);
        CrewMember crewMember = new CrewMember(id, job);
        updateObject(id, crewMember, crewMemberRepo);
    }

    public void updateDepartment(int id, String name) throws ObjectNotFoundException {
        Department department = new Department(name);
        department.setId(id);
        updateObject(id, department, departmentRepo);
    }

    public void updateGender(int id, String name) throws ObjectNotFoundException {
        Gender gender = new Gender(id, name);
        updateObject(id, gender, genderRepo);
    }

    public void updateGenre(int id, String name) throws ObjectNotFoundException {
        Genre genre = new Genre(name);
        genre.setId(id);
        updateObject(id, genre, genreRepo);
    }

    public void updateKeyword(int id, String name) throws ObjectNotFoundException {
        Keyword keyword = new Keyword(name);
        keyword.setId(id);
        updateObject(id, keyword, keywordRepo);
    }

    public void updateLanguage(int id, String code, String name) throws ObjectNotFoundException {
        Language language = new Language(code, name);
        language.setId(id);
        updateObject(id, language, languageRepo);
    }

    public void updateLanguageRole(int id, String role) throws ObjectNotFoundException {
        LanguageRole languageRole = new LanguageRole(role);
        languageRole.setId(id);
        updateObject(id, languageRole, languageRoleRepo);
    }

    public void updateMovie(int id, String title, int budget, String homepage, String overview, double popularity, String releaseDate, long revenue, int runtime, String status, String tagline, double voteAverage, int voteCount) throws ObjectNotFoundException {
        Movie movie = new Movie(title, budget, homepage, overview, popularity, releaseDate, revenue, runtime, status, tagline, voteAverage, voteCount);
        movie.setId(id);
        updateObject(id, movie, movieRepo);
    }

    public void updatePermission(int id, String name) throws ObjectNotFoundException {
        Permission permission = new Permission(name);
        permission.setId(id);
        updateObject(id, permission, permissionRepo);
    }

    public void updatePerson(int id, String name) throws ObjectNotFoundException {
        Person person = new Person(name);
        person.setId(id);
        updateObject(id, person, permissionRepo);
    }

    public void updateUser(int id, String name, String password, String email, String status) throws ObjectNotFoundException, EmptyNameException, PasswordTooShortException, UserNameInUseException {
        String processedName = name.replace(" ", "");
        String hashedPassword = HashUtil.hash(password);
        if(name.isEmpty()) throw new EmptyNameException();
        if(password.length() <= 5) throw new PasswordTooShortException();
        try {
            User user = findService.getUserByName(processedName);
            throw new UserNameInUseException();
        }catch (ObjectNotFoundException e) {
            User user = new User(processedName, hashedPassword, email, status);
            user.setId(id);
            updateObject(id, user, userRepo);
        }
    }
}
