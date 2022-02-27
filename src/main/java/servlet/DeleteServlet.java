package servlet;

import manager.UserManager;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserManager userManager = new UserManager();
        User user = (User) req.getSession().getAttribute("user");
        int id = user.getId();
        userManager.delete(id);
        req.getSession().setAttribute("msg", "user page successfully deleted");
        resp.sendRedirect("/login.jsp");

    }
}
