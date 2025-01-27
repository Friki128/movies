package net.esliceu.movie.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String mainPage(){
        return "redirect:/viewMovies";
    }
    @GetMapping("/admin")
    public String adminPage(){
        return "adminPage";
    }
}
