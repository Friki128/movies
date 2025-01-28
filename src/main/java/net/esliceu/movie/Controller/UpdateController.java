package net.esliceu.movie.Controller;

import jakarta.servlet.http.HttpSession;
import net.esliceu.movie.Exceptions.EmptyNameException;
import net.esliceu.movie.Exceptions.ObjectNotFoundException;
import net.esliceu.movie.Exceptions.PasswordTooShortException;
import net.esliceu.movie.Exceptions.UserNameInUseException;
import net.esliceu.movie.Model.*;
import net.esliceu.movie.Service.AddService;
import net.esliceu.movie.Service.FindService;
import net.esliceu.movie.Service.UpdateService;
import net.esliceu.movie.Utils.ViewTableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UpdateController {
    @Autowired
    HttpSession httpSession;
    @Autowired
    UpdateService updateService;
    @Autowired
    FindService findService;
    @GetMapping("/updateCompany")
    public String updateGetCompany(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Company company = findService.getCompany(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("id", "inputId", company.getId()));
            list.add(new ViewTableList("name", "inputText", company.getName()));
            model.addAttribute("type", "update");
            model.addAttribute("title", "Company");
            model.addAttribute("list", list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Company Not Found");
        }
        return "redirect:/errorDisplay";

    }
    @PostMapping("/updateCompany")
    public String updatePostCompany(Model model, RedirectAttributes redirectAttributes, @RequestParam int id, @RequestParam String name){
        try {
            updateService.updateCompany(id, name);
            return "redirect:/viewCompanies";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Company Not Found");
        }
        return "redirect:/errorDisplay";
    }

    @GetMapping("/updateCountry")
    public String updateGetCountry(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Country country = findService.getCountry(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("id", "inputId", country.getId()));
            list.add(new ViewTableList("name", "inputText", country.getName()));
            list.add(new ViewTableList("isoCode", "inputText", country.getIsoCode()));
            model.addAttribute("type", "update");
            model.addAttribute("title", "Country");
            model.addAttribute("list", list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Country Not Found");
        }
        return "redirect:/errorDisplay";
    }
    @PostMapping("/updateCountry")
    public String updatePostCountry(Model model, RedirectAttributes redirectAttributes, @RequestParam int id, @RequestParam String isoCode, @RequestParam String name){
        try {
            updateService.updateCountry(id, isoCode, name);
            return "redirect:/viewCountries";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Country Not Found");
        }
        return "redirect:/errorDisplay";
    }

    @GetMapping("/updatePerson")
    public String updateGetPerson(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Person person = findService.getPerson(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("id", "inputId", person.getId()));
            list.add(new ViewTableList("name", "inputText", person.getName()));
            model.addAttribute("type", "update");
            model.addAttribute("title", "Person");
            model.addAttribute("list", list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Person Not Found");
        }
        return "redirect:/errorDisplay";
    }
    @PostMapping("/updatePerson")
    public String updatePostPerson(Model model, RedirectAttributes redirectAttributes, @RequestParam int id, @RequestParam String name){
        try {
            updateService.updatePerson(id, name);
            return "redirect:/viewPersons";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Person Not Found");
        }
        return "redirect:/errorDisplay";
    }

    @GetMapping("/updateUser")
    public String updateGetUser(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            User user = findService.getUser(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("id", "inputId", user.getId()));
            list.add(new ViewTableList("name", "inputText", user.getName()));
            list.add(new ViewTableList("email", "inputEmail", user.getEmail()));
            list.add(new ViewTableList("status", "inputText", user.getStatus()));
            model.addAttribute("type", "update");
            model.addAttribute("title", "User");
            model.addAttribute("list", list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "User Not Found");
        }
        return "redirect:/errorDisplay";

    }
    @PostMapping("/updateUser")
    public String updatePostUser(Model model, RedirectAttributes redirectAttributes, @RequestParam int id, @RequestParam String name, @RequestParam String email, @RequestParam String status){
        try {
            updateService.updateUser(id, name, email, status);
            return "redirect:/viewUsers";
        } catch (EmptyNameException e) {
            redirectAttributes.addAttribute("error", "Empty Name");
        }  catch (UserNameInUseException e) {
            redirectAttributes.addAttribute("error", "User Name Already In Use");
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "User Not Found");
        }
        return "redirect:/errorDisplay";
    }

    @GetMapping("/updatePermission")
    public String updateGetPermission(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Permission permission = findService.getPermission(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("id", "inputId", permission.getId()));
            list.add(new ViewTableList("name", "inputText", permission.getName()));
            model.addAttribute("type", "update");
            model.addAttribute("title", "Permission");
            model.addAttribute("list", list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Permission Not Found");
        }
       return "redirect:/errorDisplay";
    }
    @PostMapping("/updatePermission")
    public String updatePostPermission(Model model, RedirectAttributes redirectAttributes, @RequestParam int id, @RequestParam String name){
        try {
            updateService.updatePermission(id, name);
            return "redirect:/viewPermissions";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Permission Not Found");
        }
        return "redirect:/errorDisplay";
    }

    @GetMapping("/updateLanguage")
    public String updateGetLanguage(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Language language = findService.getLanguage(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("id", "inputId", language.getId()));
            list.add(new ViewTableList("name", "inputText", language.getName()));
            list.add(new ViewTableList("code", "inputText", language.getCode()));
            model.addAttribute("type", "update");
            model.addAttribute("title", "Language");
            model.addAttribute("list", list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Language Not Found");
        }
        return "redirect:/errorDisplay";

    }
    @PostMapping("/updateLanguage")
    public String updatePostLanguage(Model model, RedirectAttributes redirectAttributes, @RequestParam int id, @RequestParam String code, @RequestParam String name){
        try {
            updateService.updateLanguage(id, code, name);
            return "redirect:/viewLanguages";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Language Not Found");
        }
        return "redirect:/errorDisplay";
    }

    @GetMapping("/updateLanguageRole")
    public String updateGetLanguageRole(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            LanguageRole languageRole = findService.getLanguageRole(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("id", "inputId", languageRole.getId()));
            list.add(new ViewTableList("role", "inputText", languageRole.getRole()));
            model.addAttribute("type", "update");
            model.addAttribute("title", "LanguageRole");
            model.addAttribute("list", list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "LanguageRole Not Found");
        }
        return "redirect:/errorDisplay";
    }
    @PostMapping("/updateLanguageRole")
    public String updatePostLanguageRole(Model model, RedirectAttributes redirectAttributes, @RequestParam int id, @RequestParam String role){
        try {
            updateService.updateLanguageRole(id, role);
            return "redirect:/viewLanguageRoles";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "LanguageRole Not Found");
        }
        return "redirect:/errorDisplay";
    }

    @GetMapping("/updateKeyword")
    public String updateGetKeyword(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Keyword keyword = findService.getKeyword(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("id", "inputId", keyword.getId()));
            list.add(new ViewTableList("name", "inputText", keyword.getName()));
            model.addAttribute("type", "update");
            model.addAttribute("title", "Keyword");
            model.addAttribute("list", list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Keyword Not Found");
        }
        return "redirect:/errorDisplay";
    }
    @PostMapping("/updateKeyword")
    public String updatePostKeyword(Model model, RedirectAttributes redirectAttributes, @RequestParam int id, @RequestParam String name){
        try {
            updateService.updateKeyword(id, name);
            return "redirect:/viewKeywords";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Keyword Not Found");
        }
        return "redirect:/errorDisplay";
    }

    @GetMapping("/updateGenre")
    public String updateGetGenre(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Genre genre = findService.getGenre(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("id", "inputId", genre.getId()));
            list.add(new ViewTableList("name", "inputText", genre.getName()));
            model.addAttribute("type", "update");
            model.addAttribute("title", "Genre");
            model.addAttribute("list", list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Genre Not Found");
        }
        return "redirect:/errorDisplay";
    }
    @PostMapping("/updateGenre")
    public String updatePostGenre(Model model, RedirectAttributes redirectAttributes, @RequestParam int id, @RequestParam String name){
        try {
            updateService.updateGenre(id, name);
            return "redirect:/viewGenres";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Genre Not Found");
        }
        return "redirect:/errorDisplay";
    }

    @GetMapping("/updateGender")
    public String updateGetGender(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Gender gender = findService.getGender(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("id", "inputId", gender.getId()));
            list.add(new ViewTableList("name", "inputText", gender.getName()));
            model.addAttribute("type", "update");
            model.addAttribute("title", "Gender");
            model.addAttribute("list", list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Gender Not Found");
        }
        return "redirect:/errorDisplay";

    }
    @PostMapping("/updateGender")
    public String updatePostGender(Model model, RedirectAttributes redirectAttributes, @RequestParam int id, @RequestParam String name){
        try {
            updateService.updateGender(id, name);
            return "redirect:/viewGenders";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Gender Not Found");
        }
        return "redirect:/errorDisplay";
    }

    @GetMapping("/updateDepartment")
    public String updateGetDepartment(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Department department = findService.getDepartment(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("id", "inputId", department.getId()));
            list.add(new ViewTableList("name", "inputText", department.getName()));
            model.addAttribute("type", "update");
            model.addAttribute("title", "Department");
            model.addAttribute("list", list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Department Not Found");
        }
        return "redirect:/errorDisplay";
    }
    @PostMapping("/updateDepartment")
    public String updatePostDepartment(Model model, RedirectAttributes redirectAttributes, @RequestParam int id, @RequestParam String name){
        try {
            updateService.updateDepartment(id, name);
            return "redirect:/viewDepartments";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Department Not Found");
        }
        return "redirect:/errorDisplay";
    }

    @GetMapping("/updateAdminRole")
    public String updateGetAdminRole(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            AdminRole adminRole = findService.getAdminRole(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("id", "inputId", adminRole.getId()));
            list.add(new ViewTableList("name", "inputText", adminRole.getName()));
            model.addAttribute("type", "update");
            model.addAttribute("title", "AdminRole");
            model.addAttribute("list", list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "AdminRole Not Found");
        }
        return "redirect:/errorDisplay";
    }
    @PostMapping("/updateAdminRole")
    public String updatePostAdminRole(Model model, RedirectAttributes redirectAttributes, @RequestParam int id, @RequestParam String name){
        try {
            updateService.updateAdminRole(id, name);
            return "redirect:/viewAdminRoles";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "AdminRole Not Found");
        }
        return "redirect:/errorDisplay";
    }

    @GetMapping("/updateMovie")
    public String updateGetMovie(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Movie movie = findService.getMovie(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("id", "inputId", movie.getId()));
            list.add(new ViewTableList("title", "inputText", movie.getTitle()));
            list.add(new ViewTableList("budget", "inputNumber", movie.getBudget()));
            list.add(new ViewTableList("homepage", "inputText", movie.getHomepage()));
            list.add(new ViewTableList("overview", "inputTextArea", movie.getOverview()));
            list.add(new ViewTableList("popularity", "inputFloat", movie.getPopularity()));
            list.add(new ViewTableList("releaseDate", "inputDate", movie.getReleaseDate()));
            list.add(new ViewTableList("revenue", "inputNumber", movie.getRevenue()));
            list.add(new ViewTableList("runtime", "inputNumber", movie.getRuntime()));
            list.add(new ViewTableList("status", "inputText", movie.getStatus()));
            list.add(new ViewTableList("tagline", "inputTextArea", movie.getTagline()));
            list.add(new ViewTableList("voteAverage", "inputFloat", movie.getVoteAverage()));
            list.add(new ViewTableList("voteCount", "inputNumber", movie.getVoteCount()));
            model.addAttribute("type", "update");
            model.addAttribute("title", "Movie");
            model.addAttribute("list", list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Movie Not Found");
        }
        return "redirect:/errorDisplay";
    }
    @PostMapping("/updateMovie")
    public String updatePostMovie(Model model, RedirectAttributes redirectAttributes, @RequestParam int id, @RequestParam String title, @RequestParam int budget, @RequestParam String homepage, @RequestParam String overview, @RequestParam double popularity, @RequestParam String releaseDate, @RequestParam int revenue, @RequestParam int runtime, @RequestParam String status, @RequestParam String tagline, @RequestParam double voteAverage, @RequestParam int voteCount){
        try {
            updateService.updateMovie(id, title, budget, homepage, overview, popularity, releaseDate, revenue, runtime, status, tagline, voteAverage, voteCount);
            return "redirect:/viewMovies";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Movie Not Found");
        }
        return "redirect:/errorDisplay";
    }
}
