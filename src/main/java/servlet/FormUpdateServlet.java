package servlet;

import manager.UserManagerImpl;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/formUpdate")
public class FormUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserManagerImpl userManager = new UserManagerImpl();
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userManager.getById(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/update.jsp").forward(req, resp);


    }
}
