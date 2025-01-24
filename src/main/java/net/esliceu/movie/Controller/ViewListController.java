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
}
