package servlet;

import db.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Users;

import java.io.IOException;

@WebServlet(value = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("result");
        Users user = DBConnection.getUserByEmail(email);
        req.setAttribute("user", user);
        req.getRequestDispatcher("profile.jsp").forward(req,resp);
    }
}
