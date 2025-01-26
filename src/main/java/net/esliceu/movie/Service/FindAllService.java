package net.esliceu.movie.Service;

import net.esliceu.movie.DAO.*;
import net.esliceu.movie.Model.*;
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

    public Page<Person> getAllPersonsPage(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return personRepo.findAll(pageable);
    }

    public Page<Person> getPersonsByName(String name, int page){
        Pageable pageable = PageRequest.of(page, 10);
        return personRepo.findAllByNameContainsIgnoreCase(name, pageable);
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

    public List<Department> getAllDepartments(){
        return departmentRepo.findAll();
    }

    public Page<Department> getAllDepartmentsPage(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return departmentRepo.findAll(pageable);
    }

    public Page<Department> getDepartmentsByName(String name, int page){
        Pageable pageable = PageRequest.of(page, 10);
        return departmentRepo.findAllByNameContainsIgnoreCase(name, pageable);
    }

    public List<Company> getAllCompanies(){
        return companyRepo.findAll();
    }

    public Page<Company> getAllCompaniesPage(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return companyRepo.findAll(pageable);
    }

    public Page<Company> getCompaniesByName(String name, int page){
        Pageable pageable = PageRequest.of(page, 10);
        return companyRepo.findAllByNameContainsIgnoreCase(name, pageable);
    }
    public List<Language> getAllLanguages(){
        return languageRepo.findAll();
    }

    public Page<Language> getAllLanguagesPage(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return languageRepo.findAll(pageable);
    }

    public Page<Language> getLanguagesByName(String name, int page){
        Pageable pageable = PageRequest.of(page, 10);
        return languageRepo.findAllByNameContainsIgnoreCase(name, pageable);
    }
    public List<LanguageRole> getAllLanguageRoles(){
        return languageRoleRepo.findAll();
    }

    public Page<LanguageRole> getAllLanguageRolesPage(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return languageRoleRepo.findAll(pageable);
    }

    public Page<LanguageRole> getLanguageRolesByName(String name, int page){
        Pageable pageable = PageRequest.of(page, 10);
        return languageRoleRepo.findAllByNameContainsIgnoreCase(name, pageable);
    }
    public List<Genre> getAllGenres(){
        return genreRepo.findAll();
    }

    public Page<Genre> getAllGenresPage(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return genreRepo.findAll(pageable);
    }

    public Page<Genre> getGenresByName(String name, int page){
        Pageable pageable = PageRequest.of(page, 10);
        return genreRepo.findAllByNameContainsIgnoreCase(name, pageable);
    }
    public List<Gender> getAllGenders(){
        return genderRepo.findAll();
    }

    public Page<Gender> getAllGendersPage(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return genderRepo.findAll(pageable);
    }

    public Page<Gender> getGendersByName(String name, int page){
        Pageable pageable = PageRequest.of(page, 10);
        return genderRepo.findAllByNameContainsIgnoreCase(name, pageable);
    }
    public List<Keyword> getAllKeywords(){
        return keywordRepo.findAll();
    }

    public Page<Keyword> getAllKeywordsPage(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return keywordRepo.findAll(pageable);
    }

    public Page<Keyword> getKeywordsByName(String name, int page){
        Pageable pageable = PageRequest.of(page, 10);
        return keywordRepo.findAllByNameContainsIgnoreCase(name, pageable);
    }
    public List<Permission> getAllPermissions(){
        return permissionRepo.findAll();
    }

    public Page<Permission> getAllPermissionsPage(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return permissionRepo.findAll(pageable);
    }

    public Page<Permission> getPermissionsByName(String name, int page){
        Pageable pageable = PageRequest.of(page, 10);
        return permissionRepo.findAllByNameContainsIgnoreCase(name, pageable);
    }
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public Page<User> getAllUsersPage(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return userRepo.findAll(pageable);
    }

    public Page<User> getUsersByName(String name, int page){
        Pageable pageable = PageRequest.of(page, 10);
        return userRepo.findAllByNameContainsIgnoreCase(name, pageable);
    }

    public List<Country> getAllCountries(){
        return countryRepo.findAll();
    }

    public Page<Country> getAllCountriesPage(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return countryRepo.findAll(pageable);
    }

    public Page<Country> getCountriesByName(String name, int page){
        Pageable pageable = PageRequest.of(page, 10);
        return countryRepo.findAllByNameContainsIgnoreCase(name, pageable);
    }
}
