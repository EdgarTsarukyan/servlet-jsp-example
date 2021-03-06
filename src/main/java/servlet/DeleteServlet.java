package servlet;

import manager.UserManagerImpl;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserManagerImpl userManager = new UserManagerImpl();
        int id = Integer.parseInt(req.getParameter("id"));
        userManager.delete(id);
        req.getSession().setAttribute("msg", "user page successfully deleted");
        resp.sendRedirect("/login.jsp");

    }
}
