package net.esliceu.movie.Service;

import net.esliceu.movie.DAO.*;
import net.esliceu.movie.Exceptions.ObjectNotFoundException;
import net.esliceu.movie.Model.*;
import net.esliceu.movie.Utils.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
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

    protected  <v> v getValue(Object id, JpaRepository repo) throws ObjectNotFoundException {
        Optional<v> value = repo.findById(id);
        if(value.isEmpty()) throw new ObjectNotFoundException();
        return value.get();
    }

    public Authorization getAuthorization(AuthorizationId id) throws ObjectNotFoundException {
        return getValue(id, authorizationRepo);
    }

    public Cast getCast(CastId id) throws ObjectNotFoundException {
        return getValue(id, castRepo);
    }

    public Company getCompany(int id) throws ObjectNotFoundException {
        return getValue(id, companyRepo);
    }

    public ProductionCountry getProductionCountry(ProductionCountryId id) throws ObjectNotFoundException {
        return getValue(id, productionCountryRepo);
    }

    public Country getCountry(int id) throws ObjectNotFoundException {
        return getValue(id, countryRepo);
    }

    public CrewMember getCrewMember(CrewMemberId id) throws ObjectNotFoundException {
        return getValue(id, crewMemberRepo);
    }

    public Department getDepartment(int id) throws ObjectNotFoundException {
        return getValue(id, departmentRepo);
    }

    public Gender getGender(int id) throws ObjectNotFoundException {
        return getValue(id, genderRepo);
    }

    public Genre getGenre(int id) throws ObjectNotFoundException {
        return getValue(id, genreRepo);
    }

    public Keyword getKeyword(int id) throws ObjectNotFoundException {
        return getValue(id, keywordRepo);
    }

    public Language getLanguage(int id) throws ObjectNotFoundException {
        return getValue(id, languageRepo);
    }

    public LanguageRole getLanguageRole(int id) throws ObjectNotFoundException {
        return getValue(id, languageRoleRepo);
    }

    public Movie getMovie(int id) throws ObjectNotFoundException {
        return getValue(id, movieRepo);
    }

    public MovieCompany getMovieCompany(MovieCompanyId id) throws ObjectNotFoundException {
        return getValue(id, movieCompanyRepo);
    }

    public MovieGenre getMovieGenre(MovieGenreId id) throws ObjectNotFoundException {
        return getValue(id, movieGenreRepo);
    }

    public MovieKeyword getMovieKeyword(MovieKeywordId id) throws ObjectNotFoundException {
        return getValue(id, movieKeywordRepo);
    }

    public MovieLanguage getMovieLanguage(MovieLanguageId id) throws ObjectNotFoundException {
        return getValue(id, movieLanguageRepo);
    }

    public Permission getPermission(int id) throws ObjectNotFoundException {
        return getValue(id, permissionRepo);
    }

    public Person getPerson(int id) throws ObjectNotFoundException {
        return getValue(id, personRepo);
    }

    public User getUser(int id) throws ObjectNotFoundException{
        return getValue(id, userRepo);
    }

    public User login(String name, String password)throws ObjectNotFoundException{
        String processedName = name.replace(" ", "");
        String hashedPassword = HashUtil.hash(password);
        Optional<User> user = userRepo.findByNameAndPassword(processedName, hashedPassword);
        if(user.isEmpty())throw new ObjectNotFoundException();
        return user.get();
    }
    public User getUserByName(String name) throws ObjectNotFoundException {
        Optional<User> user = userRepo.findByName(name);
        if(user.isEmpty())throw new ObjectNotFoundException();
        return user.get();
    }
}
