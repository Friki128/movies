package net.esliceu.movie.Controller;

import jakarta.servlet.http.HttpSession;
import net.esliceu.movie.Exceptions.EmptyNameException;
import net.esliceu.movie.Exceptions.ObjectNotFoundException;
import net.esliceu.movie.Exceptions.PasswordTooShortException;
import net.esliceu.movie.Exceptions.UserNameInUseException;
import net.esliceu.movie.Model.User;
import net.esliceu.movie.Service.AddService;
import net.esliceu.movie.Service.DeleteService;
import net.esliceu.movie.Service.FindService;
import net.esliceu.movie.Service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class UserController {
    @Autowired
    DeleteService deleteService;
    @Autowired
    AddService addService;
    @Autowired
    UpdateService updateService;
    @Autowired
    FindService findService;
    @Autowired
    HttpSession httpSession;

    @GetMapping("/login")
    public String getLogin(Model model) throws IOException {
        if(httpSession.getAttribute("user") != null){
            return "redirect:/";
        }
        model.addAttribute("title", "login");
        return "loginRegisterForm";
    }
    @PostMapping("/login")
    public String postLogin(Model model, @RequestParam String name, @RequestParam String password) throws IOException{
        try {
            User user = findService.login(name, password);
            httpSession.setAttribute("user", user);
            return "redirect:/";
        } catch (ObjectNotFoundException e) {
            model.addAttribute("error", "Name and Password don't match");
        }
        model.addAttribute("title", "login");
        return "loginRegisterForm";
    }

    @GetMapping("/register")
    public String getRegister(Model model){
        if(httpSession.getAttribute("user") != null){
            return "redirect:/";
        }
        model.addAttribute("title", "register");
        return "loginRegisterForm";
    }
    @PostMapping("/register")
    public String postRegister(Model model, @RequestParam String name, @RequestParam String password, @RequestParam String email) throws IOException{
        try {
            addService.addUser(name, password, email, "user");
            return "redirect:/login";
        } catch (PasswordTooShortException e) {
            model.addAttribute("error", "The password is too short");
        } catch (EmptyNameException e) {
            model.addAttribute("error", "Name is empty");
        } catch (UserNameInUseException e) {
            model.addAttribute("error", "Name already in use.");
        }
        model.addAttribute("title", "register");
        return "loginRegisterForm";
    }
}
