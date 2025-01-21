package net.esliceu.movie.Service;

import net.esliceu.movie.DAO.*;
import net.esliceu.movie.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void deletePerson(int id){
        personRepo.deleteById(id);
    }
    public void deleteCast(CastId id){
        castRepo.deleteById(id);
    }
    public void deleteAuthorization(AuthorizationId id){
        authorizationRepo.deleteById(id);
    }
    public void deleteCompany(int id){
        companyRepo.deleteById(id);
    }
    public void deleteCompanyCountry(CompanyCountryId id){
        companyCountryRepo.deleteById(id);
    }
    public void deleteCountry(int id){
        countryRepo.deleteById(id);
    }
    public void deleteCrewMember(CrewMemberId id){
        crewMemberRepo.deleteById(id);
    }
    public void deleteDepartment(int id){
        departmentRepo.deleteById(id);
    }
    public void deleteGender(int id){
        genderRepo.deleteById(id);
    }
    public void deleteGenre(int id){
        genreRepo.deleteById(id);
    }
    public void deleteKeyword(int id){
        keywordRepo.deleteById(id);
    }
    public void deleteLanguage(int id){
        languageRepo.deleteById(id);
    }
    public void deleteLanguageRole(int id){
        languageRoleRepo.deleteById(id);
    }
    public void deleteMovie(int id){
        movieRepo.deleteById(id);
    }
    public void deleteMovieCompany(MovieCompanyId id){
        movieCompanyRepo.deleteById(id);
    }
    public void deleteMovieGenre(MovieGenreId id){
        movieGenreRepo.deleteById(id);
    }
    public void deleteMovieKeyword(MovieKeywordId id){
        movieKeywordRepo.deleteById(id);
    }
    public void deleteMovieLanguage(MovieLanguageId id){
        movieLanguageRepo.deleteById(id);
    }
    public void deletePermission(int id){
        permissionRepo.deleteById(id);
    }
    public void deleteUser(int id){
        userRepo.deleteById(id);
    }
}
