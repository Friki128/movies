package net.esliceu.movie.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ErrorPageController implements ErrorController {
    @RequestMapping("/error")
    public String error(Model model, @RequestParam(required = false) String error) {
        model.addAttribute("error", error);
        return "errorPage";
    }

}
