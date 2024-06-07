package simple_rest.controller;

import simple_rest.entity.User;
import simple_rest.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateUser extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("id"));

        String name = req.getParameter("nickname");
        int age = Integer.parseInt(req.getParameter("age"));

        userService.updateUser(userId, new User(name, age));
    }
}