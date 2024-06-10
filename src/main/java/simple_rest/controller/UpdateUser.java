package simple_rest.controller;

import simple_rest.entity.User;
import simple_rest.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/update")
public class UpdateUser extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) {
        int userId = 0;
        int age = 0;
        try {
            userId = Integer.parseInt(req.getParameter("id"));
            age = Integer.parseInt(req.getParameter("age"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        String name = req.getParameter("nickname");

        userService.updateUser(userId, new User(name, age));
    }
}