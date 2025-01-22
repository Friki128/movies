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

    protected void deleteObject(Object id,JpaRepository repo) throws ObjectNotFoundException {
        Object object = findService.getValue(id, repo);
        repo.delete(object);

    }

    public void deletePerson(int id) throws ObjectNotFoundException {
        deleteObject(id, personRepo);
    }

    public void deleteCast(CastId id) throws ObjectNotFoundException {
        deleteObject(id, castRepo);
    }

    public void deleteAuthorization(AuthorizationId id) throws ObjectNotFoundException {
        deleteObject(id, authorizationRepo);
    }

    public void deleteCompany(int id) throws ObjectNotFoundException {
        deleteObject(id, companyRepo);
    }

    public void deleteCompanyCountry(CompanyCountryId id) throws ObjectNotFoundException {
        deleteObject(id, companyCountryRepo);
    }

    public void deleteCountry(int id) throws ObjectNotFoundException {
        deleteObject(id, countryRepo);
    }

    public void deleteCrewMember(CrewMemberId id) throws ObjectNotFoundException {
        deleteObject(id, crewMemberRepo);
    }

    public void deleteDepartment(int id) throws ObjectNotFoundException {
        deleteObject(id, departmentRepo);
    }

    public void deleteGender(int id) throws ObjectNotFoundException {
        deleteObject(id, genderRepo);
    }

    public void deleteGenre(int id) throws ObjectNotFoundException {
        deleteObject(id, genreRepo);
    }

    public void deleteKeyword(int id) throws ObjectNotFoundException {
        deleteObject(id, keywordRepo);
    }

    public void deleteLanguage(int id) throws ObjectNotFoundException {
        deleteObject(id, languageRepo);
    }

    public void deleteLanguageRole(int id) throws ObjectNotFoundException {
        deleteObject(id, languageRoleRepo);
    }

    public void deleteMovie(int id) throws ObjectNotFoundException {
        deleteObject(id, movieRepo);
    }

    public void deleteMovieCompany(MovieCompanyId id) throws ObjectNotFoundException {
        deleteObject(id, movieCompanyRepo);
    }

    public void deleteMovieGenre(MovieGenreId id) throws ObjectNotFoundException {
        deleteObject(id, movieGenreRepo);
    }

    public void deleteMovieKeyword(MovieKeywordId id) throws ObjectNotFoundException {
        deleteObject(id, movieKeywordRepo);
    }

    public void deleteMovieLanguage(MovieLanguageId id) throws ObjectNotFoundException {
        deleteObject(id, movieLanguageRepo);
    }

    public void deletePermission(int id) throws ObjectNotFoundException {
        deleteObject(id, permissionRepo);
    }

    public void deleteUser(int id) throws ObjectNotFoundException {
        deleteObject(id, userRepo);
    }
}
