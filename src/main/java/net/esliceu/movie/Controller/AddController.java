package net.esliceu.movie.Controller;

import jakarta.servlet.http.HttpSession;
import net.esliceu.movie.Exceptions.EmptyNameException;
import net.esliceu.movie.Exceptions.ObjectNotFoundException;
import net.esliceu.movie.Exceptions.PasswordTooShortException;
import net.esliceu.movie.Exceptions.UserNameInUseException;
import net.esliceu.movie.Model.Movie;
import net.esliceu.movie.Service.AddService;
import net.esliceu.movie.Service.FindService;
import net.esliceu.movie.Utils.ViewTableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AddController {
    @Autowired
    HttpSession httpSession;
    @Autowired
    AddService addService;
    @Autowired
    FindService findService;

    @GetMapping("/addCompany")
    public String addGetCompany(Model model){
        List<ViewTableList> list = new ArrayList<>();
        list.add(new ViewTableList("name", "inputText", ""));
        model.addAttribute("type", "add");
        model.addAttribute("title", "Company");
        model.addAttribute("list", list);
        return "viewOne";
    }
    @PostMapping("/addCompany")
    public String addPostCompany(Model model, @RequestParam String name){
        addService.addCompany(name);
        return "redirect:/viewCompanies";
    }

    @GetMapping("/addCountry")
    public String addGetCountry(Model model){
        List<ViewTableList> list = new ArrayList<>();
        list.add(new ViewTableList("name", "inputText", ""));
        list.add(new ViewTableList("isoCode", "inputText", ""));
        model.addAttribute("type", "add");
        model.addAttribute("title", "Country");
        model.addAttribute("list", list);
        return "viewOne";
    }
    @PostMapping("/addCountry")
    public String addPostCountry(Model model, @RequestParam String isoCode, @RequestParam String name){
        addService.addCountry(isoCode, name);
        return "redirect:/viewCountries";
    }

    @GetMapping("/addPerson")
    public String addGetPerson(Model model){
        List<ViewTableList> list = new ArrayList<>();
        list.add(new ViewTableList("name", "inputText", ""));
        model.addAttribute("type", "add");
        model.addAttribute("title", "Person");
        model.addAttribute("list", list);
        return "viewOne";
    }
    @PostMapping("/addPerson")
    public String addPostPerson(Model model, @RequestParam String name){
        addService.addPerson(name);
        return "redirect:/viewPersons";
    }

    @GetMapping("/addUser")
    public String addGetUser(Model model){
        List<ViewTableList> list = new ArrayList<>();
        list.add(new ViewTableList("name", "inputText", ""));
        list.add(new ViewTableList("password", "inputPassword", ""));
        list.add(new ViewTableList("email", "inputEmail", ""));
        list.add(new ViewTableList("status", "inputText", ""));
        model.addAttribute("type", "add");
        model.addAttribute("title", "User");
        model.addAttribute("list", list);
        return "viewOne";
    }
    @PostMapping("/addUser")
    public String addPostUser(Model model, RedirectAttributes redirectAttributes, @RequestParam String name, @RequestParam String password, @RequestParam String email, @RequestParam String status){
        try {
            addService.addUser(name, password, email, status);
            return "redirect:/viewUsers";
        } catch (EmptyNameException e) {
            redirectAttributes.addAttribute("error", "Empty Name");
        } catch (PasswordTooShortException e) {
            redirectAttributes.addAttribute("error", "Password Too Short");
        } catch (UserNameInUseException e) {
            redirectAttributes.addAttribute("error", "User Name Already In Use");
        }
        return "redirect:/errorDisplay";
    }

    @GetMapping("/addPermission")
    public String addGetPermission(Model model){
        List<ViewTableList> list = new ArrayList<>();
        list.add(new ViewTableList("name", "inputText", ""));
        model.addAttribute("type", "add");
        model.addAttribute("title", "Permission");
        model.addAttribute("list", list);
        return "viewOne";
    }
    @PostMapping("/addPermission")
    public String addPostPermission(Model model, @RequestParam String name){
        addService.addPermission(name);
        return "redirect:/viewPermissions";
    }

    @GetMapping("/addLanguage")
    public String addGetLanguage(Model model){
        List<ViewTableList> list = new ArrayList<>();
        list.add(new ViewTableList("name", "inputText", ""));
        list.add(new ViewTableList("code", "inputText", ""));
        model.addAttribute("type", "add");
        model.addAttribute("title", "Language");
        model.addAttribute("list", list);
        return "viewOne";
    }
    @PostMapping("/addLanguage")
    public String addPostLanguage(Model model, @RequestParam String code, @RequestParam String name){
        addService.addLanguage(code, name);
        return "redirect:/viewLanguages";
    }

    @GetMapping("/addLanguageRole")
    public String addGetLanguageRole(Model model){
        List<ViewTableList> list = new ArrayList<>();
        list.add(new ViewTableList("role", "inputText", ""));
        model.addAttribute("type", "add");
        model.addAttribute("title", "LanguageRole");
        model.addAttribute("list", list);
        return "viewOne";
    }
    @PostMapping("/addLanguageRole")
    public String addPostLanguageRole(Model model, @RequestParam String role){
        addService.addLanguageRole(role);
        return "redirect:/viewLanguageRoles";
    }

    @GetMapping("/addKeyword")
    public String addGetKeyword(Model model){
        List<ViewTableList> list = new ArrayList<>();
        list.add(new ViewTableList("name", "inputText", ""));
        model.addAttribute("type", "add");
        model.addAttribute("title", "Keyword");
        model.addAttribute("list", list);
        return "viewOne";
    }
    @PostMapping("/addKeyword")
    public String addPostKeyword(Model model, @RequestParam String name){
        addService.addKeyword(name);
        return "redirect:/viewKeywords";
    }

    @GetMapping("/addGenre")
    public String addGetGenre(Model model){
        List<ViewTableList> list = new ArrayList<>();
        list.add(new ViewTableList("name", "inputText", ""));
        model.addAttribute("type", "add");
        model.addAttribute("title", "Genre");
        model.addAttribute("list", list);
        return "viewOne";
    }
    @PostMapping("/addGenre")
    public String addPostGenre(Model model, @RequestParam String name){
        addService.addGenre(name);
        return "redirect:/viewGenres";
    }

    @GetMapping("/addGender")
    public String addGetGender(Model model){
        List<ViewTableList> list = new ArrayList<>();
        list.add(new ViewTableList("id", "inputNumber", ""));
        list.add(new ViewTableList("name", "inputText", ""));
        model.addAttribute("type", "add");
        model.addAttribute("title", "Gender");
        model.addAttribute("list", list);
        return "viewOne";
    }
    @PostMapping("/addGender")
    public String addPostGender(Model model, @RequestParam int id, @RequestParam String name){
        addService.addGender(id, name);
        return "redirect:/viewGenders";
    }

    @GetMapping("/addDepartment")
    public String addGetDepartment(Model model){
        List<ViewTableList> list = new ArrayList<>();
        list.add(new ViewTableList("name", "inputText", ""));
        model.addAttribute("type", "add");
        model.addAttribute("title", "Department");
        model.addAttribute("list", list);
        return "viewOne";
    }
    @PostMapping("/addDepartment")
    public String addPostDepartment(Model model, @RequestParam String name){
        addService.addDepartment(name);
        return "redirect:/viewDepartments";
    }

    @GetMapping("/addMovie")
    public String addGetMovie(Model model){
        List<ViewTableList> list = new ArrayList<>();
        list.add(new ViewTableList("title", "inputText", ""));
        list.add(new ViewTableList("budget", "inputNumber", ""));
        list.add(new ViewTableList("homepage", "inputText", ""));
        list.add(new ViewTableList("overview", "inputTextArea", ""));
        list.add(new ViewTableList("popularity", "inputFloat", ""));
        list.add(new ViewTableList("releaseDate", "inputDate", ""));
        list.add(new ViewTableList("revenue", "inputNumber", ""));
        list.add(new ViewTableList("runtime", "inputNumber", ""));
        list.add(new ViewTableList("status", "inputText", ""));
        list.add(new ViewTableList("tagline", "inputTextArea", ""));
        list.add(new ViewTableList("voteAverage", "inputFloat", ""));
        list.add(new ViewTableList("voteCount", "inputNumber", ""));
        model.addAttribute("type", "add");
        model.addAttribute("title", "Movie");
        model.addAttribute("list", list);
        return "viewOne";
    }
    @PostMapping("/addMovie")
    public String addPostMovie(Model model, @RequestParam String title, @RequestParam int budget, @RequestParam String homepage, @RequestParam String overview, @RequestParam double popularity, @RequestParam String releaseDate, @RequestParam int revenue, @RequestParam int runtime, @RequestParam String status, @RequestParam String tagline, @RequestParam double voteAverage, @RequestParam int voteCount){
        addService.addMovie(title, budget, homepage, overview, popularity, releaseDate, revenue, runtime, status, tagline, voteAverage, voteCount);
        return "redirect:/viewMovies";
    }

    @GetMapping("/addMoviesLanguage")
    public String addGetMoviesLanguage(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Movie movie = findService.getMovie(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("language", "inputAuto", "/findAllLanguages"));
            list.add(new ViewTableList("role", "inputAuto", "/findAllLanguageRoles"));
            list.add(new ViewTableList("id", "inputId", id));
            model.addAttribute("type", "add");
            model.addAttribute("title", movie.getTitle());
            model.addAttribute("list", list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Movie Not Found");
        }
        return "redirect:/errorDisplay";
    }

    @PostMapping("/addMoviesLanguage")
    public String addPostMoviesLanguage(Model model, RedirectAttributes redirectAttributes, @RequestParam int id, @RequestParam int role, @RequestParam int language){
        try {
            addService.addMovieLanguage(id, language, role);
            return "redirect:/viewMovies";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Element Not Found");
        }
        return "redirect:/errorDisplay";
    }

    @GetMapping("/addMoviesKeywords")
    public String addGetMoviesKeywords(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Movie movie = findService.getMovie(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("keyword", "inputAuto", "/findAllKeywords"));
            list.add(new ViewTableList("id", "inputId", id));
            model.addAttribute("type", "add");
            model.addAttribute("title", movie.getTitle());
            model.addAttribute("list", list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Movie Not Found");
        }
        return "redirect:/errorDisplay";
    }
    @PostMapping("addMoviesKeywords")
    public String addPostMoviesKeywords(Model model, RedirectAttributes redirectAttributes, @RequestParam int id, @RequestParam int keyword){
        try {
            addService.addMovieKeyword(id, keyword);
            return "redirect:/viewMovies";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Element Not Found");
        }
        return "redirect:/errorDisplay";
    }

    @GetMapping("/addMoviesGenres")
    public String addGetMoviesGenres(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Movie movie = findService.getMovie(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("genre", "inputAuto", "/findAllGenres"));
            list.add(new ViewTableList("id", "inputId", id));
            model.addAttribute("type", "add");
            model.addAttribute("title", movie.getTitle());
            model.addAttribute("list", list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Movie Not Found");
        }
        return "redirect:/errorDisplay";
    }
    @PostMapping("addMoviesGenres")
    public String addPostMoviesGenres(Model model, RedirectAttributes redirectAttributes, @RequestParam int id, @RequestParam int genre){
        try {
            addService.addMovieGenre(id, genre);
            return "redirect:/viewMovies";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Element Not Found");
        }
        return "redirect:/errorDisplay";
    }

    @GetMapping("/addMoviesCompanies")
    public String addGetMoviesCompanies(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Movie movie = findService.getMovie(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("company", "inputAuto", "/findAllCompanys"));
            list.add(new ViewTableList("id", "inputId", id));
            model.addAttribute("type", "add");
            model.addAttribute("title", movie.getTitle());
            model.addAttribute("list", list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Movie Not Found");
        }
        return "redirect:/errorDisplay";
    }
    @PostMapping("addMoviesCompanies")
    public String addPostMoviesCompanies(Model model, RedirectAttributes redirectAttributes, @RequestParam int id, @RequestParam int company){
        try {
            addService.addMovieCompany(id, company);
            return "redirect:/viewMovies";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Element Not Found");
        }
        return "redirect:/errorDisplay";
    }

    @GetMapping("/addMoviesCountries")
    public String addGetMoviesCountries(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Movie movie = findService.getMovie(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("country", "inputAuto", "/findAllCountrys"));
            list.add(new ViewTableList("id", "inputId", id));
            model.addAttribute("type", "add");
            model.addAttribute("title", movie.getTitle());
            model.addAttribute("list", list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Movie Not Found");
        }
        return "redirect:/errorDisplay";
    }
    @PostMapping("addMoviesCountries")
    public String addPostMoviesCountries(Model model, RedirectAttributes redirectAttributes, @RequestParam int id, @RequestParam int country){
        try {
            addService.addProductionCountry(id, country);
            return "redirect:/viewMovies";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Element Not Found");
        }
        return "redirect:/errorDisplay";
    }
    @GetMapping("/addMoviesCrew")
    public String addGetMoviesCrew(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Movie movie = findService.getMovie(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("job", "inputText", ""));
            list.add(new ViewTableList("department", "inputAuto", "/findAllDepartments"));
            list.add(new ViewTableList("person", "inputAuto", "/findAllPersons"));
            list.add(new ViewTableList("id", "inputId", id));
            model.addAttribute("type", "add");
            model.addAttribute("title", movie.getTitle());
            model.addAttribute("list", list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Movie Not Found");
        }
        return "redirect:/errorDisplay";
    }
    @PostMapping("addMoviesCrew")
    public String addPostMoviesCrew(Model model, RedirectAttributes redirectAttributes, @RequestParam int id, @RequestParam int person, @RequestParam int department, @RequestParam String job){
        try {
            addService.addCrewMember(department, id, person, job);
            return "redirect:/viewMovies";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Element Not Found");
        }
        return "redirect:/errorDisplay";
    }

    @GetMapping("/addMoviesCast")
    public String addGetMoviesCast(Model model, RedirectAttributes redirectAttributes, @RequestParam int id){
        try {
            Movie movie = findService.getMovie(id);
            List<ViewTableList> list = new ArrayList<>();
            list.add(new ViewTableList("name", "inputText", ""));
            list.add(new ViewTableList("order", "inputNumber", ""));
            list.add(new ViewTableList("gender", "inputAuto", "/findAllGenders"));
            list.add(new ViewTableList("person", "inputAuto", "/findAllPersons"));
            list.add(new ViewTableList("id", "inputId", id));
            model.addAttribute("type", "add");
            model.addAttribute("title", movie.getTitle());
            model.addAttribute("list", list);
            return "viewOne";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Movie Not Found");
        }
        return "redirect:/errorDisplay";
    }
    @PostMapping("addMoviesCast")
    public String addPostMoviesCast(Model model, RedirectAttributes redirectAttributes, @RequestParam int id, @RequestParam int person, @RequestParam int gender, @RequestParam String name, @RequestParam int order){
        try {
            addService.addCast(id, person, gender, name, order);
            return "redirect:/viewMovies";
        } catch (ObjectNotFoundException e) {
            redirectAttributes.addAttribute("error", "Element Not Found");
        }
        return "redirect:/errorDisplay";
    }
}
