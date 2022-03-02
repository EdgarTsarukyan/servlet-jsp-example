package servlet;

import manager.UserManagerImpl;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserManagerImpl userManager = new UserManagerImpl();
        User user = new User();

        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");

        int age = Integer.parseInt(req.getParameter("age"));//ete uzm em tariq@ chnshel, inchpes anem?

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        user.setName(name);
        user.setLastName(lastname);
        user.setAge(age);
        user.setEmail(email);
        user.setPassword(password);
        userManager.create(user);

        req.getSession().setAttribute("msg", "user successfully was registered");
        resp.sendRedirect("/register.jsp");

    }
}
