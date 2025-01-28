package net.esliceu.movie.Service;

import net.esliceu.movie.DAO.*;
import net.esliceu.movie.Exceptions.ObjectNotFoundException;
import net.esliceu.movie.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteService {
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

    protected void deleteObject(Object object,JpaRepository repo) throws ObjectNotFoundException {
        repo.delete(object);

    }

    public void deletePerson(Person person) throws ObjectNotFoundException {
        castRepo.deleteAllByIdPerson(person);
        crewMemberRepo.deleteAllByIdPerson(person);
        deleteObject(person, personRepo);
    }

    public void deleteCast(Cast cast) throws ObjectNotFoundException {
        deleteObject(cast, castRepo);
    }

    public void deleteAuthorization(Authorization authorization) throws ObjectNotFoundException {
        deleteObject(authorization, authorizationRepo);
    }

    public void deleteCompany(Company company) throws ObjectNotFoundException {
        movieCompanyRepo.deleteAllByIdCompany(company);
        deleteObject(company, companyRepo);
    }

    public void deleteProductionCountry(ProductionCountry productionCountry) throws ObjectNotFoundException {
        deleteObject(productionCountry, productionCountryRepo);
    }

    public void deleteCountry(Country country) throws ObjectNotFoundException {
        productionCountryRepo.deleteAllByIdCountry(country);
        deleteObject(country, countryRepo);
    }

    public void deleteCrewMember(CrewMember crewMember) throws ObjectNotFoundException {
        deleteObject(crewMember, crewMemberRepo);
    }

    public void deleteDepartment(Department department) throws ObjectNotFoundException {
        crewMemberRepo.deleteAllByIdDepartment(department);
        deleteObject(department, departmentRepo);
    }

    public void deleteGender(Gender gender) throws ObjectNotFoundException {
        castRepo.deleteAllByIdGender(gender);
        deleteObject(gender, genderRepo);
    }

    public void deleteGenre(Genre genre) throws ObjectNotFoundException {
        movieGenreRepo.deleteAllByIdGenre(genre);
        deleteObject(genre, genreRepo);
    }

    public void deleteKeyword(Keyword keyword) throws ObjectNotFoundException {
        movieKeywordRepo.deleteAllByIdKeyword(keyword);
        deleteObject(keyword, keywordRepo);
    }

    public void deleteLanguage(Language language) throws ObjectNotFoundException {
        movieLanguageRepo.deleteAllByIdLanguage(language);
        deleteObject(language, languageRepo);
    }

    public void deleteLanguageRole(LanguageRole languageRole) throws ObjectNotFoundException {
        movieLanguageRepo.deleteAllByIdLanguageRole(languageRole);
        deleteObject(languageRole, languageRoleRepo);
    }

    public void deleteMovie(Movie movie) throws ObjectNotFoundException {
        productionCountryRepo.deleteAllByIdMovie(movie);
        movieLanguageRepo.deleteAllByIdMovie(movie);
        movieKeywordRepo.deleteAllByIdMovie(movie);
        movieCompanyRepo.deleteAllByIdMovie(movie);
        movieGenreRepo.deleteAllByIdMovie(movie);
        crewMemberRepo.deleteAllByIdMovie(movie);
        castRepo.deleteAllByIdMovie(movie);
        deleteObject(movie, movieRepo);
    }

    public void deleteMovieCompany(MovieCompany movieCompany) throws ObjectNotFoundException {
        deleteObject(movieCompany, movieCompanyRepo);
    }

    public void deleteMovieGenre(MovieGenre movieGenre) throws ObjectNotFoundException {
        deleteObject(movieGenre, movieGenreRepo);
    }

    public void deleteMovieKeyword(MovieKeyword movieKeyword) throws ObjectNotFoundException {
        deleteObject(movieKeyword, movieKeywordRepo);
    }

    public void deleteMovieLanguage(MovieLanguage movieLanguage) throws ObjectNotFoundException {
        deleteObject(movieLanguage, movieLanguageRepo);
    }

    public void deletePermission(Permission permission) throws ObjectNotFoundException {
        authorizationRepo.deleteAllByIdPermission(permission);
        deleteObject(permission, permissionRepo);
    }

    public void deleteUser(User user) throws ObjectNotFoundException {
        authorizationRepo.deleteAllByIdUser(user);
        deleteObject(user, userRepo);
    }
}
