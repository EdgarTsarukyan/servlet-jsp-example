package servlet;

import manager.UserManagerImpl;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserManagerImpl userManager = new UserManagerImpl();
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userManager.getById(id);

        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String age = req.getParameter("age");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (name == null || name == "") {
            user.setName(user.getName());
        } else {
            user.setName(name);
        }

        if (lastname == null || lastname == "") {
            user.setLastName(user.getLastName());
        } else {
            user.setLastName(lastname);
        }

        if (age == "") {
            user.setAge(user.getAge());
        } else {
            int i = Integer.parseInt(age);
            user.setAge(i);
        }

        if (email == null || email == "") {
            user.setEmail(user.getEmail());
        } else {
            user.setEmail(email);
        }

        if (password == null || password == "") {
            user.setPassword(user.getPassword());
        } else {
            user.setPassword(password);
        }

        userManager.update(user);
        req.setAttribute("email", user.getEmail());
        req.setAttribute("password", user.getPassword());
        req.getRequestDispatcher("/login").forward(req, resp);

    }
}
