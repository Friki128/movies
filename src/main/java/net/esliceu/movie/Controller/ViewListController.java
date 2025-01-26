package net.esliceu.movie.Controller;

import jakarta.servlet.http.HttpSession;
import net.esliceu.movie.Service.FindAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewListController {
    @Autowired
    HttpSession httpSession;
    @GetMapping("/viewMovies")
    public String viewMovies(Model model){
        model.addAttribute("type", "Movies");
        return "viewList";
    }
    @GetMapping("/viewPersons")
    public String viewPersons(Model model){
        model.addAttribute("type", "Persons");
        return "viewList";
    }
    @GetMapping("/viewUsers")
    public String viewUsers(Model model){
        model.addAttribute("type", "Users");
        return "viewList";
    }
    @GetMapping("/viewCountries")
    public String viewCountries(Model model){
        model.addAttribute("type", "Countrys");
        return "viewList";
    }
    @GetMapping("/viewCompanies")
    public String viewCompanies(Model model){
        model.addAttribute("type", "Companys");
        return "viewList";
    }
    @GetMapping("/viewKeywords")
    public String viewKeywords(Model model){
        model.addAttribute("type", "Keywords");
        return "viewList";
    }
    @GetMapping("/viewPermissions")
    public String viewPermissions(Model model){
        model.addAttribute("type", "Permissions");
        return "viewList";
    }
    @GetMapping("/viewLanguageRoles")
    public String viewLanguageRoles(Model model){
        model.addAttribute("type", "LanguageRoles");
        return "viewList";
    }
    @GetMapping("/viewLanguages")
    public String viewLanguages(Model model){
        model.addAttribute("type", "Languages");
        return "viewList";
    }
    @GetMapping("/viewGenders")
    public String viewGenders(Model model){
        model.addAttribute("type", "Genders");
        return "viewList";
    }
    @GetMapping("/viewGenres")
    public String viewGenres(Model model){
        model.addAttribute("type", "Genres");
        return "viewList";
    }
    @GetMapping("/viewDepartments")
    public String viewDepartments(Model model){
        model.addAttribute("type", "Departments");
        return "viewList";
    }
}
