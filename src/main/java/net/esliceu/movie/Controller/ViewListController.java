package net.esliceu.movie.Controller;

import jakarta.servlet.http.HttpSession;
import net.esliceu.movie.Exceptions.ObjectNotFoundException;
import net.esliceu.movie.Model.User;
import net.esliceu.movie.Service.FindAllService;
import net.esliceu.movie.Service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewListController {
    @Autowired
    HttpSession httpSession;
    @Autowired
    PermissionService permissionService;

    private void SetStatusAndPermissions(Model model, String table, String type) throws ObjectNotFoundException {
        User user = (User) httpSession.getAttribute("user");
        Boolean logged = false;
        Boolean canAdd = false;
        if(user != null){
            logged = true;
            canAdd = permissionService.checkPermission("Add", table, user);
        }
        model.addAttribute("logged", logged);
        model.addAttribute("canAdd", canAdd);
        model.addAttribute("type", type);
        model.addAttribute("addValue", table);
    }

    @GetMapping("/viewMovies")
    public String viewMovies(Model model){
        try {
            SetStatusAndPermissions(model, "Movie", "Movies");
            return "viewList";
        } catch (ObjectNotFoundException e) {
            return "redirect:/error";
        }
    }
    @GetMapping("/viewPersons")
    public String viewPersons(Model model){
        try {
            SetStatusAndPermissions(model, "Person", "Persons");
            return "viewList";
        } catch (ObjectNotFoundException e) {
            return "redirect:/error";
        }
    }
    @GetMapping("/viewUsers")
    public String viewUsers(Model model){
        try {
            SetStatusAndPermissions(model, "User", "Users");
            return "viewList";
        } catch (ObjectNotFoundException e) {
            return "redirect:/error";
        }
    }
    @GetMapping("/viewCountries")
    public String viewCountries(Model model){
        try {
            SetStatusAndPermissions(model, "Country", "Countrys");
            return "viewList";
        } catch (ObjectNotFoundException e) {
            return "redirect:/error";
        }
    }
    @GetMapping("/viewCompanies")
    public String viewCompanies(Model model){
        try {
            SetStatusAndPermissions(model, "Company", "Companys");
            return "viewList";
        } catch (ObjectNotFoundException e) {
            return "redirect:/error";
        }
    }
    @GetMapping("/viewKeywords")
    public String viewKeywords(Model model){
        try {
            SetStatusAndPermissions(model, "Keyword", "Keywords");
            return "viewList";
        } catch (ObjectNotFoundException e) {
            return "redirect:/error";
        }
    }
    @GetMapping("/viewPermissions")
    public String viewPermissions(Model model){
        try {
            SetStatusAndPermissions(model, "Permission", "Permissions");
            return "viewList";
        } catch (ObjectNotFoundException e) {
            return "redirect:/error";
        }
    }
    @GetMapping("/viewLanguageRoles")
    public String viewLanguageRoles(Model model){
        try {
            SetStatusAndPermissions(model, "LanguageRole", "LanguageRoles");
            return "viewList";
        } catch (ObjectNotFoundException e) {
            return "redirect:/error";
        }
    }
    @GetMapping("/viewLanguages")
    public String viewLanguages(Model model){
        try {
            SetStatusAndPermissions(model, "Language", "Languages");
            return "viewList";
        } catch (ObjectNotFoundException e) {
            return "redirect:/error";
        }
    }
    @GetMapping("/viewGenders")
    public String viewGenders(Model model){
        try {
            SetStatusAndPermissions(model, "Gender", "Genders");
            return "viewList";
        } catch (ObjectNotFoundException e) {
            return "redirect:/error";
        }
    }
    @GetMapping("/viewGenres")
    public String viewGenres(Model model){
        try {
            SetStatusAndPermissions(model, "Genre", "Genres");
            return "viewList";
        } catch (ObjectNotFoundException e) {
            return "redirect:/error";
        }
    }
    @GetMapping("/viewDepartments")
    public String viewDepartments(Model model){
        try {
            SetStatusAndPermissions(model, "Department", "Departments");
            return "viewList";
        } catch (ObjectNotFoundException e) {
            return "redirect:/error";
        }
    }
    @GetMapping("/viewAdminRoles")
    public String viewAdminRoles(Model model){
        try {
            SetStatusAndPermissions(model, "AdminRole", "AdminRoles");
            return "viewList";
        } catch (ObjectNotFoundException e) {
            return "redirect:/error";
        }
    }
}
