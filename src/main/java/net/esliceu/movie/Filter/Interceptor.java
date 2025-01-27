package net.esliceu.movie.Filter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.esliceu.movie.Model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        String uri = req.getRequestURI();
        User user = (User) req.getSession().getAttribute("user");
        if (uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".webp") || uri.endsWith(".gif")||uri.contains("find")||uri.contains("view")||uri.contains("register")||uri.contains("login")||uri.contains("error")) {
            return true;
        }
        if(user == null && !uri.equals("/")) {
            resp.sendRedirect("/");
            return false;
        }
        if(uri.contains("admin")) {
            if (!user.getStatus().equals("admin")) {
                resp.sendRedirect("/");
            }
        }
        return true;
    }
}
