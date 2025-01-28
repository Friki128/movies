package net.esliceu.movie.Service;

import net.esliceu.movie.DAO.*;
import net.esliceu.movie.Exceptions.ObjectNotFoundException;
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
    private AdminRoleRepo adminRoleRepo;
    @Autowired
    private PermissionRepo permissionRepo;
    @Autowired
    private RolePermissionRepo rolePermissionRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    FindService findService;

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

    public List<AdminRole> getAllAdminRoles(){
        return adminRoleRepo.findAll();
    }

    public Page<AdminRole> getAllAdminRolesPage(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return adminRoleRepo.findAll(pageable);
    }

    public Page<AdminRole> getAdminRolesByName(String name, int page){
        Pageable pageable = PageRequest.of(page, 10);
        return adminRoleRepo.findAllByNameContainsIgnoreCase(name, pageable);
    }

    public List<Cast> getAllCharacters() {
        return castRepo.findAll();
    }

    public List<Person> getAllActors() {
        return personRepo.findAllActors();
    }

    public List<Person> getAllDirectors() {
        return personRepo.findAllDirectors();
    }

    public Page<Movie> getMoviesByActor(int actor, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return movieRepo.findAllMoviesByActor(actor, pageable);
    }

    public Page<Movie> getMoviesByCharacter(String character, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return movieRepo.findAllMoviesByCharacter(character, pageable);
    }

    public Page<Movie> getMoviesByDirector(int director, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return movieRepo.findAllMoviesByDirector(director, pageable);
    }

    public Page<Movie> getMoviesByGenre(int genre, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return movieRepo.findAllMoviesByGenre(genre, pageable);
    }

    public List<MovieLanguage> getLanguagesByMovie(int id) throws ObjectNotFoundException {
        Movie movie = findService.getMovie(id);
        return movieLanguageRepo.findAllByIdMovie(movie);
    }

    public List<MovieKeyword> getAllKeywordsByMovie(int id) throws ObjectNotFoundException {
        Movie movie = findService.getMovie(id);
        return movieKeywordRepo.findAllByIdMovie(movie);
    }

    public List<MovieGenre> getAllGenresByMovie(int id) throws ObjectNotFoundException {
        Movie movie = findService.getMovie(id);
        return movieGenreRepo.findAllByIdMovie(movie);
    }

    public List<MovieCompany> getAllCompaniesByMovie(int id) throws ObjectNotFoundException {
        Movie movie = findService.getMovie(id);
        return movieCompanyRepo.findAllByIdMovie(movie);
    }

    public List<CrewMember> getAllCrewByMovie(int id) throws ObjectNotFoundException {
        Movie movie = findService.getMovie(id);
        return crewMemberRepo.findAllByIdMovie(movie);
    }

    public List<Cast> getAllCastByMovie(int id) throws ObjectNotFoundException {
        Movie movie = findService.getMovie(id);
        return castRepo.findAllByIdMovie(movie);
    }

    public List<Cast> getAllCastByPerson(int id) throws ObjectNotFoundException {
        Person person = findService.getPerson(id);
        return castRepo.findAllByIdPerson(person);
    }

    public List<CrewMember> getAllCrewByPerson(int id) throws ObjectNotFoundException {
        Person person = findService.getPerson(id);
        return crewMemberRepo.findAllByIdPerson(person);
    }

    public List<MovieLanguage> getLanguagesByRole(int id) throws ObjectNotFoundException {
        LanguageRole languageRole = findService.getLanguageRole(id);
        return movieLanguageRepo.findAllByIdLanguageRole(languageRole);
    }

    public List<MovieLanguage> getLanguagesByLanguage(int id) throws ObjectNotFoundException {
        Language language = findService.getLanguage(id);
        return movieLanguageRepo.findAllByIdLanguage(language);
    }

    public List<ProductionCountry> getAllMoviesByCountry(int id) throws ObjectNotFoundException {
        Country country = findService.getCountry(id);
        return productionCountryRepo.findAllByIdCountry(country);
    }

    public List<ProductionCountry> getAllCountriesByMovie(int id) throws ObjectNotFoundException {
        Movie movie = findService.getMovie(id);
        return productionCountryRepo.findAllByIdMovie(movie);
    }

    public List<Authorization> getAllUsersByAdminRole(int id) throws ObjectNotFoundException {
        AdminRole adminRole = findService.getAdminRole(id);
        return authorizationRepo.findAllByIdAdminRole(adminRole);
    }

    public List<Authorization> getAllAdminRolesByUser(int id) throws ObjectNotFoundException {
        User user = findService.getUser(id);
        return authorizationRepo.findAllByIdUser(user);
    }

    public List<RolePermission> getAllPermissionsByAdminRole(int id) throws ObjectNotFoundException {
        AdminRole adminRole = findService.getAdminRole(id);
        return rolePermissionRepo.findAllByIdAdminRole(adminRole);
    }

    public List<RolePermission> getAllAdminRolesByPermission(int id) throws ObjectNotFoundException {
        Permission permission = findService.getPermission(id);
        return rolePermissionRepo.findAllByIdPermission(permission);
    }

    public List<MovieKeyword> getAllMoviesByKeyword(int id) throws ObjectNotFoundException {
        Keyword keyword = findService.getKeyword(id);
        return movieKeywordRepo.findAllByIdKeyword(keyword);
    }

    public List<CrewMember> getAllCrewByDepartment(int id) throws ObjectNotFoundException {
        Department department = findService.getDepartment(id);
        return crewMemberRepo.findAllByIdDepartment(department);
    }

    public List<Cast> getAllCastByGender(int id) throws ObjectNotFoundException {
        Gender gender = findService.getGender(id);
        return castRepo.findAllByIdGender(gender);
    }

    public List<MovieGenre> getAllMoviesByGenre(int id) throws ObjectNotFoundException {
        Genre genre = findService.getGenre(id);
        return movieGenreRepo.findAllByIdGenre(genre);
    }

    public List<MovieCompany> getAllMoviesByCompany(int id) throws ObjectNotFoundException {
        Company company = findService.getCompany(id);
        return movieCompanyRepo.findAllByIdCompany(company);
    }

}
