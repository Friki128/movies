package net.esliceu.movie.Controller;

import jakarta.servlet.http.HttpSession;
import net.esliceu.movie.Model.User;
import net.esliceu.movie.Service.FindAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewListController {
    @Autowired
    HttpSession httpSession;

    private void SetStatusAndPermissions(Model model, String table){
        User user = (User) httpSession.getAttribute("user");
        Boolean logged = false;

        if(user != null){
            logged = true;
            model.addAttribute("status", user.getStatus());
        }
        model.addAttribute("logged", logged);
    }

    @GetMapping("/viewMovies")
    public String viewMovies(Model model){
        SetStatusAndPermissions(model, "Movie");
        model.addAttribute("type", "Movies");
        return "viewList";
    }
    @GetMapping("/viewPersons")
    public String viewPersons(Model model){
        SetStatusAndPermissions(model, "Person");
        model.addAttribute("type", "Persons");
        return "viewList";
    }
    @GetMapping("/viewUsers")
    public String viewUsers(Model model){
        SetStatusAndPermissions(model, "User");
        model.addAttribute("type", "Users");
        return "viewList";
    }
    @GetMapping("/viewCountries")
    public String viewCountries(Model model){
        SetStatusAndPermissions(model, "Country");
        model.addAttribute("type", "Countrys");
        return "viewList";
    }
    @GetMapping("/viewCompanies")
    public String viewCompanies(Model model){
        SetStatusAndPermissions(model, "Company");
        model.addAttribute("type", "Companys");
        return "viewList";
    }
    @GetMapping("/viewKeywords")
    public String viewKeywords(Model model){
        SetStatusAndPermissions(model, "Keyword");
        model.addAttribute("type", "Keywords");
        return "viewList";
    }
    @GetMapping("/viewPermissions")
    public String viewPermissions(Model model){
        SetStatusAndPermissions(model, "Permission");
        model.addAttribute("type", "Permissions");
        return "viewList";
    }
    @GetMapping("/viewLanguageRoles")
    public String viewLanguageRoles(Model model){
        SetStatusAndPermissions(model, "LanguageRole");
        model.addAttribute("type", "LanguageRoles");
        return "viewList";
    }
    @GetMapping("/viewLanguages")
    public String viewLanguages(Model model){
        SetStatusAndPermissions(model, "Language");
        model.addAttribute("type", "Languages");
        return "viewList";
    }
    @GetMapping("/viewGenders")
    public String viewGenders(Model model){
        SetStatusAndPermissions(model, "Gender");
        model.addAttribute("type", "Genders");
        return "viewList";
    }
    @GetMapping("/viewGenres")
    public String viewGenres(Model model){
        SetStatusAndPermissions(model, "Genre");
        model.addAttribute("type", "Genres");
        return "viewList";
    }
    @GetMapping("/viewDepartments")
    public String viewDepartments(Model model){
        SetStatusAndPermissions(model, "Department");
        model.addAttribute("type", "Departments");
        return "viewList";
    }
}
