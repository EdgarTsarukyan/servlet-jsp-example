package servlet;

import manager.UserManager;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserManager userManager = new UserManager();

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        List<User> all = userManager.getAll();
        for (User user : all){
            if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                req.setAttribute("user", user);
                req.getRequestDispatcher("/home.jsp").forward(req, resp);
                return;
            }

        }
        req.getSession().setAttribute("msg", "email or password is wrong");
        resp.sendRedirect("/login.jsp");

    }
}
