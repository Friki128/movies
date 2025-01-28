package net.esliceu.movie.Controller;

import jakarta.servlet.http.HttpSession;
import net.esliceu.movie.Exceptions.IncorrectPermissionsException;
import net.esliceu.movie.Exceptions.ObjectNotFoundException;
import net.esliceu.movie.Model.*;
import net.esliceu.movie.Service.DeleteService;
import net.esliceu.movie.Service.FindService;
import net.esliceu.movie.Service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Key;

@Controller
public class DeleteController {
    @Autowired
    HttpSession httpSession;
    @Autowired
    DeleteService deleteService;
    @Autowired
    FindService findService;
    @Autowired
    PermissionService permissionService;
    @GetMapping("/deleteMovie")
    public String deleteMovie(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        User user = (User) httpSession.getAttribute("user");
        try {
            if(!permissionService.checkPermission("Delete", "Movie", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            Movie movie = findService.getMovie(id);
            deleteService.deleteMovie(movie);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Movie Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/deleteDepartment")
    public String deleteDepartment(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        User user = (User) httpSession.getAttribute("user");
        try {
            if(!permissionService.checkPermission("Delete", "Department", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            Department department = findService.getDepartment(id);
            deleteService.deleteDepartment(department);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Department Not Found");
        }
        return "redirect:/error";
    }

    @GetMapping("/deleteGenre")
    public String deleteGenre(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        User user = (User) httpSession.getAttribute("user");
        try {
            if(!permissionService.checkPermission("Delete", "Genre", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            Genre genre = findService.getGenre(id);
            deleteService.deleteGenre(genre);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Genre Not Found");
        }
        return "redirect:/error";
    }

    @GetMapping("/deleteGender")
    public String deleteGender(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        User user = (User) httpSession.getAttribute("user");
        try {
            if(!permissionService.checkPermission("Delete", "Gender", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            Gender gender = findService.getGender(id);
            deleteService.deleteGender(gender);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Gender Not Found");
        }
        return "redirect:/error";
    }

    @GetMapping("/deletePerson")
    public String deletePerson(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        User user = (User) httpSession.getAttribute("user");
        try {
            if(!permissionService.checkPermission("Delete", "Person", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            Person person = findService.getPerson(id);
            deleteService.deletePerson(person);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Person Not Found");
        }
        return "redirect:/error";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            User user = (User) httpSession.getAttribute("user");
            if(!permissionService.checkPermission("Delete", "User", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            User user = findService.getUser(id);
            deleteService.deleteUser(user);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "User Not Found");
        }
        return "redirect:/error";
    }

    @GetMapping("/deleteAccount")
    public String deleteAccount(Model model, RedirectAttributes redirectAttributes){
        try {
            User user = (User) httpSession.getAttribute("user");
            deleteService.deleteUser(user);
            httpSession.removeAttribute("user");
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "User Not Found");
        }
        return "redirect:/error";
    }

    @GetMapping("/deletePermission")
    public String deletePermission(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        User user = (User) httpSession.getAttribute("user");
        try {
            if(!permissionService.checkPermission("Delete", "Permission", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            Permission permission = findService.getPermission(id);
            deleteService.deletePermission(permission);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Permission Not Found");
        }
        return "redirect:/error";
    }

    @GetMapping("/deleteLanguage")
    public String deleteLanguage(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        User user = (User) httpSession.getAttribute("user");
        try {
            if(!permissionService.checkPermission("Delete", "Language", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            Language language = findService.getLanguage(id);
            deleteService.deleteLanguage(language);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Language Not Found");
        }
        return "redirect:/error";
    }

    @GetMapping("/deleteLanguageRole")
    public String deleteLanguageRole(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        User user = (User) httpSession.getAttribute("user");
        try {
            if(!permissionService.checkPermission("Delete", "LanguageRole", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            LanguageRole languageRole = findService.getLanguageRole(id);
            deleteService.deleteLanguageRole(languageRole);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Language Role Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/deleteKeyword")
    public String deleteKeyword(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        User user = (User) httpSession.getAttribute("user");
        try {
            if(!permissionService.checkPermission("Delete", "Keyword", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            Keyword keyword = findService.getKeyword(id);
            deleteService.deleteKeyword(keyword);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Keyword Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/deleteCountry")
    public String deleteCountry(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        User user = (User) httpSession.getAttribute("user");
        try {
            if(!permissionService.checkPermission("Delete", "Country", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            Country country = findService.getCountry(id);
            deleteService.deleteCountry(country);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Country Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/deleteAdminRole")
    public String deleteAdminRole(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        User user = (User) httpSession.getAttribute("user");
        try {
            if(!permissionService.checkPermission("Delete", "AdminRole", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            AdminRole adminRole = findService.getAdminRole(id);
            deleteService.deleteAdminRole(adminRole);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "AdminRole Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/deleteCompany")
    public String deleteCompany(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        User user = (User) httpSession.getAttribute("user");
        try {
            if(!permissionService.checkPermission("Delete", "Company", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            Company company = findService.getCompany(id);
            deleteService.deleteCompany(company);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Company Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/deleteMoviesLanguages")
    public String deleteMovieLanguage(Model model, RedirectAttributes redirectAttributes, @RequestParam int movie, @RequestParam int language, @RequestParam int languageRole){
        User user = (User) httpSession.getAttribute("user");
        try {
            if(!permissionService.checkPermission("Update", "Movie", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            Movie m = findService.getMovie(movie);
            Language l = findService.getLanguage(language);
            LanguageRole r = findService.getLanguageRole(languageRole);
            MovieLanguageId movieLanguageId = new MovieLanguageId(m, l, r);
            MovieLanguage movieLanguage = findService.getMovieLanguage(movieLanguageId);
            deleteService.deleteMovieLanguage(movieLanguage);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Element Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/deleteMoviesGenres")
    public String deleteMovieGenre(Model model, RedirectAttributes redirectAttributes, @RequestParam int movie, @RequestParam int genre){
        User user = (User) httpSession.getAttribute("user");
        try {
            if(!permissionService.checkPermission("Update", "Movie", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            Movie m = findService.getMovie(movie);
            Genre g = findService.getGenre(genre);
            MovieGenreId movieGenreId = new MovieGenreId(m, g);
            MovieGenre movieGenre = findService.getMovieGenre(movieGenreId);
            deleteService.deleteMovieGenre(movieGenre);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Element Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/deleteMoviesKeywords")
    public String deleteMovieKeyword(Model model, RedirectAttributes redirectAttributes, @RequestParam int movie, @RequestParam int keyword){
        User user = (User) httpSession.getAttribute("user");
        try {
            if(!permissionService.checkPermission("Update", "Movie", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            Movie m = findService.getMovie(movie);
            Keyword k = findService.getKeyword(keyword);
            MovieKeywordId movieKeywordId = new MovieKeywordId(m, k);
            MovieKeyword movieKeyword = findService.getMovieKeyword(movieKeywordId);
            deleteService.deleteMovieKeyword(movieKeyword);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Element Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/deleteMoviesCompanies")
    public String deleteMovieCompany(Model model, RedirectAttributes redirectAttributes, @RequestParam int movie, @RequestParam int company){
        User user = (User) httpSession.getAttribute("user");
        try {
            if(!permissionService.checkPermission("Update", "Movie", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            Movie m = findService.getMovie(movie);
            Company c = findService.getCompany(company);
            MovieCompanyId movieCompanyId = new MovieCompanyId(m, c);
            MovieCompany movieCompany = findService.getMovieCompany(movieCompanyId);
            deleteService.deleteMovieCompany(movieCompany);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Element Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/deleteMoviesCast")
    public String deleteMoviesCast(Model model, RedirectAttributes redirectAttributes, @RequestParam int movie, @RequestParam int person, @RequestParam int gender){
        User user = (User) httpSession.getAttribute("user");
        try {
            if(!permissionService.checkPermission("Update", "Movie", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            Movie m = findService.getMovie(movie);
            Gender g = findService.getGender(gender);
            Person p = findService.getPerson(person);
            CastId CastId = new CastId(m, p, g);
            Cast cast = findService.getCast(CastId);
            deleteService.deleteCast(cast);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Element Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/deleteMoviesCrew")
    public String deleteMoviesCrew(Model model, RedirectAttributes redirectAttributes, @RequestParam int movie, @RequestParam int person, @RequestParam int department){
        User user = (User) httpSession.getAttribute("user");
        try {
            if(!permissionService.checkPermission("Update", "Movie", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            Movie m = findService.getMovie(movie);
            Department d = findService.getDepartment(department);
            Person p = findService.getPerson(person);
            CrewMemberId crewMemberId = new CrewMemberId(d, m, p);
            CrewMember crewMember = findService.getCrewMember(crewMemberId);
            deleteService.deleteCrewMember(crewMember);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Element Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/deleteMoviesCountries")
    public String deleteMoviesCountries(Model model, RedirectAttributes redirectAttributes, @RequestParam int movie, @RequestParam int country){
        User user = (User) httpSession.getAttribute("user");
        try {
            if(!permissionService.checkPermission("Update", "Movie", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            Movie m = findService.getMovie(movie);
            Country c = findService.getCountry(country);
            ProductionCountryId productionCountryId = new ProductionCountryId(m, c);
            ProductionCountry productionCountry = findService.getProductionCountry(productionCountryId);
            deleteService.deleteProductionCountry(productionCountry);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Element Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/deleteUserPermissions")
    public String deleteUserPermissions(Model model, RedirectAttributes redirectAttributes, @RequestParam int user, @RequestParam int adminRole){
        try {
            User u = (User) httpSession.getAttribute("user");
            if(!permissionService.checkPermission("Update", "User", u))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            User u = findService.getUser(user);
            AdminRole r = findService.getAdminRole(adminRole);
            AuthorizationId authorizationId = new AuthorizationId(r, u);
            Authorization authorization = findService.getAuthorization(authorizationId);
            deleteService.deleteAuthorization(authorization);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Element Not Found");
        }
        return "redirect:/error";
    }
    @GetMapping("/deleteRolePermissions")
    public String deleteRolePermissions(Model model, RedirectAttributes redirectAttributes, @RequestParam int permission, @RequestParam int adminRole){
        User user = (User) httpSession.getAttribute("user");
        try {
            if(!permissionService.checkPermission("Update", "AdminRole", user))throw new IncorrectPermissionsException();
        } catch (Exception e){
            redirectAttributes.addAttribute("error", "Cannot access this page.");
            return "redirect:/error";
        }
        try {
            Permission p = findService.getPermission(permission);
            AdminRole r = findService.getAdminRole(adminRole);
            RolePermissionId rolePermissionId = new RolePermissionId(r, p);
            RolePermission rolePermission = findService.getRolePermission(rolePermissionId);
            deleteService.deleteRolePermission(rolePermission);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Element Not Found");
        }
        return "redirect:/error";
    }
}
