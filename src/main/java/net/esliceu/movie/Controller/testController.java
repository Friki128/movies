package net.esliceu.movie.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @Autowired
    HttpSession httpSession;
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
