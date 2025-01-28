package net.esliceu.movie.Controller;

import jakarta.servlet.http.HttpSession;
import net.esliceu.movie.Exceptions.ObjectNotFoundException;
import net.esliceu.movie.Model.*;
import net.esliceu.movie.Service.FindAllService;
import net.esliceu.movie.Service.FindService;
import net.esliceu.movie.Service.PermissionService;
import net.esliceu.movie.Utils.DTOUtil;
import net.esliceu.movie.Utils.ViewTableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController {
    @Autowired
    HttpSession httpSession;
    @Autowired
    FindService findService;
    @Autowired
    FindAllService findAllService;
    @Autowired
    PermissionService permissionService;

    private void setModel(Model model, String table, String type, int id, String title, List<ViewTableList> list) throws ObjectNotFoundException {
        User user = (User) httpSession.getAttribute("user");
        Boolean canUpdate = false;
        Boolean canDelete = false;
        if(user != null){
            canUpdate = permissionService.checkPermission("Update", table, user);
            canDelete =  permissionService.checkPermission("Delete", table, user);
        }
        model.addAttribute("id", id);
        model.addAttribute("list", list);
        model.addAttribute("type", type);
        model.addAttribute("title", title);
        model.addAttribute("table", table);
        model.addAttribute("canUpdate",canUpdate);
        model.addAttribute("canDelete",canDelete);
    }

    @GetMapping("/viewMovie")
    public String getMovie(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Movie movie = findService.getMovie(id);
            List<MovieLanguage> movieLanguages = findAllService.getLanguagesByMovie(id);
            List<MovieKeyword> keywords = findAllService.getAllKeywordsByMovie(id);
            List<MovieGenre> genres = findAllService.getAllGenresByMovie(id);
            List<MovieCompany> companies = findAllService.getAllCompaniesByMovie(id);
            List<CrewMember> crew = findAllService.getAllCrewByMovie(id);
            List<Cast> cast = findAllService.getAllCastByMovie(id);
            List<ProductionCountry> countries = findAllService.getAllCountriesByMovie(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("Title", "para", movie.getTitle()));
            list.add(new ViewTableList("Status", "para", movie.getStatus()));
            list.add(new ViewTableList("Release Date", "para", movie.getReleaseDate()));
            list.add(new ViewTableList("Runtime", "para", movie.getRuntime()));
            list.add(new ViewTableList("Budget", "para", movie.getBudget()));
            list.add(new ViewTableList("Revenue", "para", movie.getRevenue()));
            list.add(new ViewTableList("Overview", "text", movie.getOverview()));
            list.add(new ViewTableList("Tag Line", "text", movie.getTagline()));
            list.add(new ViewTableList("Popularity", "para", movie.getPopularity()));
            list.add(new ViewTableList("Vote Average", "para", movie.getVoteAverage()));
            list.add(new ViewTableList("Vote Count", "para", movie.getVoteCount()));
            list.add(new ViewTableList("Homepage", "para", movie.getHomepage()));
            list.add(new ViewTableList("Languages", "list", DTOUtil.printContainers(movieLanguages, "movie"), true, "MoviesLanguages"));
            list.add(new ViewTableList("Keywords", "list", DTOUtil.printContainers(keywords, "movie"), true, "MoviesKeywords"));
            list.add(new ViewTableList("Genres", "list", DTOUtil.printContainers(genres, "movie"), true, "MoviesGenres"));
            list.add(new ViewTableList("Companies", "list", DTOUtil.printContainers(companies, "movie"), true, "MoviesCompanies"));
            list.add(new ViewTableList("Crew", "list", DTOUtil.printContainers(crew, "movie"), true, "MoviesCrew"));
            list.add(new ViewTableList("Characters", "list", DTOUtil.printContainers(cast, "movie"), true, "MoviesCast"));
            list.add(new ViewTableList("Countries", "list", DTOUtil.printContainers(countries, "movie"), true, "MoviesCountries"));
            setModel(model, "Movie", "view", id, movie.getTitle(), list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Movie Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/viewPerson")
    public String getPerson(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Person person = findService.getPerson(id);
            List<ViewTableList> list = new ArrayList<>();
            List<Cast> cast = findAllService.getAllCastByPerson(id);
            List<CrewMember> crew = findAllService.getAllCrewByPerson(id);
            list.add(new ViewTableList("Name", "para", person.getName()));
            list.add(new ViewTableList("Played", "list", DTOUtil.printContainers(cast, "person")));
            list.add(new ViewTableList("Worked", "list", DTOUtil.printContainers(crew, "person")));
            setModel(model, "Person", "view", id, person.getName(), list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Person Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/viewUser")
    public String getUser(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            User user = findService.getUser(id);
            List<ViewTableList> list = new ArrayList<>();
            List<Authorization> authorizations = findAllService.getAllAdminRolesByUser(id);
            list.add(new ViewTableList("Name", "para", user.getName()));
            list.add(new ViewTableList("Email", "para", user.getEmail()));
            list.add(new ViewTableList("Status", "para", user.getStatus()));
            list.add(new ViewTableList("Authorizations", "list", DTOUtil.printContainers(authorizations, "user"), true, "UserPermissions"));
            setModel(model, "User", "view", id, user.getName(), list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "User Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/viewPermission")
    public String getPermission(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Permission permission = findService.getPermission(id);
            List<ViewTableList> list = new ArrayList<>();
            List<RolePermission> rolePermissions = findAllService.getAllAdminRolesByPermission(id);
            list.add(new ViewTableList("Name", "para", permission.getName()));
            list.add(new ViewTableList("Roles", "list", DTOUtil.printContainers(rolePermissions, "permission")));
            setModel(model, "Permission", "view", id, permission.getName(), list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Permission Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/viewLanguageRole")
    public String getLanguageRole(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            LanguageRole languageRole = findService.getLanguageRole(id);
            List<ViewTableList> list = new ArrayList<>();
            List<MovieLanguage> movieLanguages = findAllService.getLanguagesByRole(id);
            list.add(new ViewTableList("Name", "para", languageRole.getName()));
            list.add(new ViewTableList("Movies", "list", DTOUtil.printContainers(movieLanguages, "role")));
            setModel(model, "LanguageRole", "view", id, languageRole.getName(), list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Role Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/viewLanguage")
    public String getLanguage(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Language language = findService.getLanguage(id);
            List<MovieLanguage> movieLanguages = findAllService.getLanguagesByLanguage(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("Name", "para", language.getName()));
            list.add(new ViewTableList("Code", "para", language.getCode()));
            list.add(new ViewTableList("Movies", "list", DTOUtil.printContainers(movieLanguages, "language")));
            setModel(model, "Language", "view", id, language.getName(), list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Language Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/viewCountry")
    public String getCountry(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Country country = findService.getCountry(id);
            List<ProductionCountry> movies = findAllService.getAllMoviesByCountry(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("Name", "para", country.getName()));
            list.add(new ViewTableList("Iso", "para", country.getIsoCode()));
            list.add(new ViewTableList("Movies", "list", DTOUtil.printContainers(movies, "country")));
            setModel(model, "Country", "view", id, country.getName(), list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Country Not Found");
        }
        return "redirect:/error";
    }

    @GetMapping("/viewAdminRole")
    public String getAdminRole(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            AdminRole adminRole = findService.getAdminRole(id);
            List<ViewTableList> list = new ArrayList<>();
            List<Authorization> authorizations = findAllService.getAllUsersByAdminRole(id);
            List<RolePermission> rolePermissions = findAllService.getAllPermissionsByAdminRole(id);
            list.add(new ViewTableList("Name", "para", adminRole.getName()));
            list.add(new ViewTableList("Authorizations", "list", DTOUtil.printContainers(authorizations, "role")));
            list.add(new ViewTableList("Permissions", "list", DTOUtil.printContainers(rolePermissions, "role"), true, "RolePermissions"));
            setModel(model, "AdminRole", "view", id, adminRole.getName(), list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "AdminRole Not Found");
        }
        return "redirect:/error";
    }

    @GetMapping("/viewCompany")
    public String getCompany(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Company company = findService.getCompany(id);
            List<ViewTableList> list = new ArrayList<>();
            List<MovieCompany> movies = findAllService.getAllMoviesByCompany(id);
            list.add(new ViewTableList("Name", "para", company.getName()));
            list.add(new ViewTableList("Movies", "list", DTOUtil.printContainers(movies, "company")));
            setModel(model, "Company", "view", id, company.getName(), list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Company Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/viewKeyword")
    public String getKeyword(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Keyword keyword = findService.getKeyword(id);
            List<MovieKeyword> movies = findAllService.getAllMoviesByKeyword(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("Name", "para", keyword.getName()));
            list.add(new ViewTableList("Movies", "list", DTOUtil.printContainers(movies, "keyword")));
            setModel(model, "Keyword", "view", id, keyword.getName(), list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Keyword Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/viewDepartment")
    public String getDepartment(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Department department = findService.getDepartment(id);
            List<CrewMember> crewMembers = findAllService.getAllCrewByDepartment(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("Name", "para", department.getName()));
            list.add(new ViewTableList("Work", "list", DTOUtil.printContainers(crewMembers, "department")));
            setModel(model, "Department", "view", id, department.getName(), list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Department Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/viewGender")
    public String getGender(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Gender gender = findService.getGender(id);
            List<ViewTableList> list = new ArrayList<>();
            List<Cast> characters = findAllService.getAllCastByGender(id);
            list.add(new ViewTableList("name", "para", gender.getName()));
            list.add(new ViewTableList("Characters", "list", DTOUtil.printContainers(characters, "gender")));
            setModel(model, "Gender", "view", id, gender.getName(), list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Gender Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/viewGenre")
    public String getGenre(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Genre genre = findService.getGenre(id);
            List<ViewTableList> list = new ArrayList<>();
            List<MovieGenre> movies = findAllService.getAllMoviesByGenre(id);
            list.add(new ViewTableList("Name", "para", genre.getName()));
            list.add(new ViewTableList("Movies", "list", DTOUtil.printContainers(movies, "genre")));
            setModel(model, "Genre", "view", id, genre.getName(), list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Genre Not Found");
        }
        return "redirect:/error";
    }
}
